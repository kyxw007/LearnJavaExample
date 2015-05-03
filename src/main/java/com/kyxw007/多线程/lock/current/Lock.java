package com.kyxw007.多线程.lock.current;

/**
 * Created by kyxw007 on 15/4/12.
 */

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

/**
 * Lock的继承提供了比{@code synchronized}更多的扩展锁操作，允许更灵活的结构，
 * 可以拥有差异非常大的属性（may have quite different properties），并支持
 * 复合关联，通过 {@link java.util.concurrent.locks.Condition}对象来实现
 *
 * <p>锁是控制一个被多个线程共享的资源使用权利的工具，锁提供独自占有共享资源的权
 * 利：同一时刻，只有一个线程可以获取锁，并使用共享资源，但是，也有一些锁允许同时
 * 使用共享资源，例如{@link java.util.concurrent.locks.ReadWriteLock}.
 *
 * <p>使用{@code synchronized}的方法或语句可以使用一个隐含的monitor来锁关联
 * 任何的对象，但是所有的锁请求和释放被强制在一个块结构中实现，当需要复合锁的时候
 * 他们必须反序释放，而且所有锁必须在获取锁的同一个语法范围内释放
 *
 *
 * <p>虽然{@code synchronized}的代码块锁使得使用monitor locks编程更加容易，
 * 并且帮助避免很多和锁有关的错误，但是很多时候，我们需要更灵活的使用锁。例如,一
 * 些算法为了遍历并发访问数据结构，需要使用“hand-over-hand”或者“chain locking”
 * 必须获取Node A的锁然后获取Node B的锁，然后释放A再获取C,释放B获取D等等。这时
 * 候{@code Lock}的实现允许以任意的顺序，获取和释放锁
 *
 *
 * <p>灵活性的增加，带来了附加的责任。没有了{@code synchronized}块结构的限制
 * ，无法自动释放锁，很多情况下，下列语句会经常被用到：
 *
 *  <pre> {@code
 * Lock l = ...;
 * l.lock();
 * try {
 *   // access the resource protected by this lock
 * } finally {
 *   l.unlock();
 * }}</pre>
 *
 * 当locking和unlocking在不同的区域发生，最应该注意的时确定所有的代码在
 * try-finally 或 try-catch 中，确保最后把锁释放掉。
 *
 *
 * <p> {@code Lock}的实现还提供了{@code synchronized}方法或代码块更多的功能
 * 又通过提供非阻塞获取锁的方法({@link#tryLock()})；
 * 提供了可以被中断的锁({@link#lockInterrutibly})；
 * 和一个可能超时的获取锁的方法({@link#tryLock(long,TimeUnit)}).
 *
 * <p>一个{@code Lock}类通常会提供和隐含monitor lock非常不同的行为和语义，如：
 * 保证排序（guaranteed ordering）不可重入用法（non-reentrant usage）或死锁
 * 检测（deadlock detection）,如果锁的实现提供了特殊的语义，那么必须在文档中说
 * 明
 *
 * <p>注意：{@code Lock}实例只是一个普通对象，可以在语句中用作{@code synchronized}
 * 的目标获取{@code Lock}实例的monitor lock 而且和这个实例的方法没有特定的关系
 * ，不推荐这样使用{@code Lock}，以避免混乱。
 * It is recommended that to avoid confusion you never use {@code Lock}
 * instances in this way, except within their own implementation.
 *
 * <p>除特别注明外，向任何参数传递null值将导致一个NullPointerException异常被抛出。
 *
 * <h3>Memory Synchronization 内存同步</h3>
 *
 * <p>所有{@code Lock}的实现 <em>必须<em/>强制使用相同的内存同步语义，和内置监测锁
 * 一样，在<a href="http://docs.oracle.com/javase/specs/jls/se7/html/jls-17.html#jls-17.4">
 * The Java Language Specification (17.4 Memory Model)</a>中描述的，一个成功的
 * {@code lock}操作和Lock有一样的同步内存影响。一个成功的{@code unlock}操作和Unlock
 * 有一样的同步内存影响。
 *     All {@code Lock} implementations <em>must</em> enforce the same
 * memory synchronization semantics as provided by the built-in monitor
 * lock, as described in
 * <a href="http://docs.oracle.com/javase/specs/jls/se7/html/jls-17.html#jls-17.4">
 * The Java Language Specification (17.4 Memory Model)</a>:
 * <ul>
 * <li>A successful {@code lock} operation has the same memory
 * synchronization effects as a successful <em>Lock</em> action.
 * <li>A successful {@code unlock} operation has the same
 * memory synchronization effects as a successful <em>Unlock</em> action.
 * </ul>
 *
 * 不成功的locking和unlocking操作，和reentrant locking/unlocking操作，不要求任何
 * 同步内存的效果。
 *
 *
 * <h3>Implementation Considerations 实现注意事项</h3>
 *
 * <p>三种不同形式的锁获取方式(interruptible,non-interruptible, and timed)
 * 会使他们的性能特征、排序保证以及其他实现的质量不同。再者，中断正在获取锁的功能可能
 * 无法使用。
 *      Further, the ability to interrupt the <em>ongoing</em>
 * acquisition of a lock may not be available in a given {@code Lock}
 * class.
 *因此，一个Lock接口的实现不被要求定义的三种形式的锁获取方法有完全一样的保证或语义
 * 或必须支持中断一个正在获取锁的过程。
 * Consequently, an implementation is not required to define
 * exactly the same guarantees or semantics for all three forms of
 * lock acquisition, nor is it required to support interruption of an
 * ongoing lock acquisition.
 *
 * 但是，一个接口的实现要求定义每个方法明确的语义和保证的文档说明，它也必须遵守
 * 中断的语义在这个接口中定义的，为了扩展锁获取的中断支持可以：
 * An implementation is required to clearly
 * document the semantics and guarantees provided by each of the
 * locking methods. It must also obey the interruption semantics as
 * defined in this interface, to the extent that interruption of lock
 * acquisition is supported: which is either totally, or only on
 * method entry.
 *
 *
 * <p>As interruption generally implies cancellation, and checks for
 * interruption are often infrequent, an implementation can favor responding
 * to an interrupt over normal method return. This is true even if it can be
 * shown that the interrupt occurred after another action may have unblocked
 * the thread. An implementation should document this behavior.
 *
 *
 * @since 1.5
 * @author Doug Lea
 */
public interface Lock {
    /**
     * 获取锁
     * <p>
     * 如果这时候锁不可用，那么调度目的当前线程为了将变为disable，并处于休眠状态，直
     * 到获得锁
     * <p/>
     *
     *
     * <p><b>实现注意事项</b>
     * <p>
     *
     * <p/>一个锁的实现可能可以检测到lock的错误使用，例如一个引用可能导致死锁，并且
     * 实现必须在这些情况下抛出一个（unchecked）异常，并在文档中做说明。
     *
     */
    void lock();

    /**
     *获取锁，仅当当前线程的状态为：{@linkplain Thread#interrupt interrupted}.
     *
     * <p>如果锁可用，则马上返回
     *     Acquires the lock if it is available and returns immediately.
     *
     * <p>如果锁不可用，则当前线程因进程调度而变为disable，并保持休眠，直到下列两
     * 个情况中的一个发生：
     * 1、锁被当前线程获取，
     * 2、或者，其他线程中断了{@linkplain Thread#interrupt interrupts}
     * 当前线程，并且所获取中断是被支持的
     *
     *如果当前线程：
     * 的中断状态被设置进这个方法，
     * 或者被中断，当获取锁时，并且锁获取的中断被支持
     * 那么当前的线程抛出 {@link InterruptedException}并且清除中断状态
     *
     *
     * <p><b>Implementation Considerations</b>
     *
     * <p>The ability to interrupt a lock acquisition in some
     * implementations may not be possible, and if possible may be an
     * expensive operation.  The programmer should be aware that this
     * may be the case. An implementation should document when this is
     * the case.
     *
     * <p>An implementation can favor responding to an interrupt over
     * normal method return.
     *
     * <p>A {@code Lock} implementation may be able to detect
     * erroneous use of the lock, such as an invocation that would
     * cause deadlock, and may throw an (unchecked) exception in such
     * circumstances.  The circumstances and the exception type must
     * be documented by that {@code Lock} implementation.
     *
     * @throws InterruptedException
     */
    void lockInterruptibly() throws InterruptedException;

    /**
     * 获取锁如果锁当前是自由的。
     * <p>
     * 如果锁是自由的，获取锁并马上返回true
     * 如果锁不可用，则马上返回false
     * <p/>
     *
     * <p>典型的用法如下：
     *  <pre> {@code
     * Lock lock = ...;
     * if (lock.tryLock()) {
     *   try {
     *     // manipulate protected state
     *   } finally {
     *     lock.unlock();
     *   }
     * } else {
     *   // perform alternative actions
     * }}</pre>
     * 这个用法确保了锁是unlock状态时不会尝试unlock
     * This usage ensures that the lock is unlocked if it was acquired, and
     * doesn't try to unlock if the lock was not acquired.
     *
     * @return {@code true} if the lock was acquired and
     *         {@code false} otherwise
     */
    boolean tryLock();

    /**
     *
     * 等待时间，等待可被中断，并抛出 InterruptedException
     *
     * @param time the maximum time to wait for the lock
     * @param unit the time unit of the {@code time} argument
     * @return {@code true} if the lock was acquired and {@code false}
     *         if the waiting time elapsed before the lock was acquired
     *
     * @throws InterruptedException if the current thread is interrupted
     *         while acquiring the lock (and interruption of lock
     *         acquisition is supported)
     */
    boolean tryLock(long time, TimeUnit unit) throws InterruptedException;

    /**
     * 释放锁
     *
     * <p><b>Implementation Considerations</b>
     *
     * <p>A {@code Lock} implementation will usually impose
     * restrictions on which thread can release a lock (typically only the
     * holder of the lock can release it) and may throw
     * an (unchecked) exception if the restriction is violated.
     * Any restrictions and the exception
     * type must be documented by that {@code Lock} implementation.
     */
    void unlock();


    /**
     * 返回一个{@link java.util.concurrent.locks.Condition}实例，绑定到这个锁实例
     *
     * <p>
     * 在condition等待之前，当前线程必须先获得锁
     * 调用await() 将在开始等待前自动释放锁，并且在等待返回前重新获得锁。
     *
     * <p><b>Implementation Considerations</b>
     *
     * <p>The exact operation of the {@link java.util.concurrent.locks.Condition} instance depends on
     * the {@code Lock} implementation and must be documented by that
     * implementation.
     *
     * @return A new {@link java.util.concurrent.locks.Condition} instance for this {@code Lock} instance
     * @throws UnsupportedOperationException if this {@code Lock}
     *         implementation does not support conditions
     */
    Condition newCondition();
}
