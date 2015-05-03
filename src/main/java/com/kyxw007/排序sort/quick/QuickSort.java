package com.kyxw007.排序sort.quick;

/**
 * Created by kyxw007 on 15/3/10.
 */
public class QuickSort {
    private int[] data;
    public int[] getData(){
        return this.data;
    }
    public void setData(int[] _data){
        this.data = _data;
    }

    private int partition(int low,int hight)
    {
        int key = data[low];

        while(low<hight)
        {
            while(low<hight && data[hight]>=key)
                hight--;
            data[low] = data[hight];

            while(low<hight && data[low]<=key)
                low++;
            data[hight] = data[low];
        }
        data[low] = key;
        return low;
    }

    public void sort(int low,int hight)
    {
        if(low<hight)
        {
            int result = partition(low,hight);
            sort(low,result-1);
            sort(result+1,hight);
        }

    }


    public void display()
    {
        for(int i=0;i<data.length;i++)
        {
            System.out.print(data[i]);
            System.out.print(" ");
        }
    }
}
