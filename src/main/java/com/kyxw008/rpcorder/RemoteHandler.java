package com.kyxw008.rpcorder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kyxw007 on 15/4/4.
 */
public class RemoteHandler {
    private List<Integer> doneList = new ArrayList<Integer>();
    private int current = 1;
    private RpcHeap rh = new RpcHeap();

    public List<Integer> getDoneList(){
        return doneList;
    }

    /**
     * 重置处理器
     */
    public void reset() {
        current = 1;
        RpcHeap rh = new RpcHeap();
        doneList = new ArrayList<Integer>();
    }
    /**
     * 处理请求
     * @param i
     */
    public void handle(int i){
        System.out.println("请求：" + i);
        if (i==current){ //若请求顺序正确，即马上执行请求，并查找堆顶元素是否适合马上进行处理
            System.out.println("处理"+current);
            doneList.add(current);
            current++;
            while (rh.getTop()==current){
                System.out.println("处理"+current);
                doneList.add(current);
                rh.delete();
                current++;
            }
        }else{//出现乱序则将其插入最小请求堆中
            rh.insert(i);
        }
    }



    /**
     * 最小请求堆
     */
    private class RpcHeap{
        private ArrayList<Integer> heap = new ArrayList<Integer>();
        public int getTop(){
            if (heap.size()>0){
                return heap.get(0);
            }else {
                return -1;
            }

        }
        /**
         * 插入堆
         * @param i
         */
        public void insert(int i){

            heap.add(i);

            int compare2 = heap.size()-1;
            int compare1 = (compare2-1)/2;
            while (compare1>=0){
                if(heap.get(compare1)>heap.get(compare2)){
                    swap(heap,compare1,compare2);
                    compare2--;
                    compare1 = (compare2-1)/2;
                }else {
                    compare2--;
                    compare1 = (compare2-1)/2;
                }
            }
//            System.out.print("插入"+i+"后堆：");
//            print();
        }

        /**
         * 删除堆顶
         */
        public void delete(){
            swap(heap,0,heap.size()-1);
            heap.remove(heap.size()-1);

            int compare1 = 0;
            int compare2 = 2*compare1+1;

            while (compare2<heap.size()) {

                if ((compare2 + 1)< heap.size()) {
                    compare2 = heap.get(compare2) < heap.get(compare2 + 1) ? compare2 : (compare2 + 1);
                }
                if (heap.get(compare1) > heap.get(compare2)) {
                    swap(heap, compare1, compare2);
                    compare1++;
                    compare2 = 2 * compare1 + 1;
                }else {
                    compare1++;
                    compare2 = 2 * compare1 + 1;
                }
            }
            //System.out.print("删除后：");
            //print();
        }

        /**
         * 交换列表元素
         * @param list
         * @param a
         * @param b
         */
        private void swap (List list, int a, int b){
            Object objA = list.get(a);
            list.set(a, list.get(b));
            list.set(b, objA);
        }

        /**
         * 打印List
         */
        public void print(){
            for (int i=0;i<heap.size();i++){
                System.out.print(heap.get(i) + ",");
            }
            System.out.print("\n");
        }
    }


}
