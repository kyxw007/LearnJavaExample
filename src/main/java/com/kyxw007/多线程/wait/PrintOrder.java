package com.kyxw007.多线程.wait;

/**
 * Created by kyxw007 on 15/4/11.
 *
 *  实现三个线程A->B->C->A->B->C这样的顺序不断执行下去
 */

public class PrintOrder implements Runnable {

    private String name;
    private Lock prev;
    private Lock self;

    private PrintOrder(String name, Lock prev, Lock self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            System.out.println(name+":wait sync "+prev.getName());
            synchronized (prev) {

                System.out.println(name+":lock "+prev.getName());
                System.out.println(name+":wait sync "+self.getName());
                synchronized (self) {
                    System.out.println(name+":lock "+ self.getName());
                    System.out.println("->" + name);
                    count--;
                    System.out.println(name+":notify " + self.getName());
                    self.notify();
                }
                System.out.println(name+":release "+self.getName());

                try {
                    System.out.println(name+":release "+prev.getName());
                    System.out.println(name+":wait notify from " + prev.getName());
                    prev.wait();
                    System.out.println(name+":recive notify from "+prev.getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }
    }

    public static void main(String[] args) throws Exception {
        Lock a = new Lock("a");
        Lock b = new Lock("b");
        Lock c = new Lock("c");

        PrintOrder pa = new PrintOrder("A", a, b);
        PrintOrder pb = new PrintOrder("B", b, c);
        PrintOrder pc = new PrintOrder("C", c, a);

        new Thread(pb).start();
        new Thread(pa).start();
        Thread.sleep(300);
        //new Thread(pc).start();
    }

}

class Lock{
    String name ;
    Lock(String _name){
        name = _name;
    }
    public String getName(){
        return name;
    }

}