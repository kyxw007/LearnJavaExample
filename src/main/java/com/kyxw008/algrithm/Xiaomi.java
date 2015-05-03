package com.kyxw008.algrithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kyxw007 on 15/3/25.
 */
public class Xiaomi {
    public static void main(String[] args){
        Xiaomi xiaomi = new Xiaomi();
        xiaomi.init();

    }

    public void init(){
        ArrayList<String> allMember = new ArrayList<String>();
        for(int i=0;i<5;i++){
            allMember.add(String.valueOf(i));
        }

        ArrayList<Request> requests = new ArrayList<Request>();

        //request from 1
        Request r = new Request();
        ArrayList<RequestItem> rilist = new ArrayList<RequestItem>();
        r.owner = "1";
        RequestItem ri1 = new RequestItem();
        ri1.member = "2";// 1 要求在2之后
        ri1.standFront = false;
        rilist.add(ri1);
        RequestItem ri2= new RequestItem();
        ri2.member = "3";// 1 要求在3之前
        ri2.standFront = true;
        rilist.add(ri2);
        r.requestItems = rilist;
        requests.add(r);
        //Request  from 3
        Request r1 = new Request();
        ArrayList<RequestItem> rilist1 = new ArrayList<RequestItem>();
        r1.owner = "3";
        RequestItem ri3 = new RequestItem();
        ri3.member = "2";    //3 要求在 2之后
        ri3.standFront = false;
        rilist1.add(ri3);
        RequestItem ri4 = new RequestItem();
        ri4.member = "4";
        ri4.standFront = true;
        rilist1.add(ri4);
        r1.requestItems = rilist1;
        requests.add(r1);

        List<String> order = getValidOrder(allMember, requests);
        for (String a:allMember){
            System.out.println(a);
        }

    }

    private List<String> getValidOrder(List<String> allMembers, List<Request> requests){


        for (Request re:requests){
            System.out.println("ower:"+re.owner);
            System.out.println("request");
            for (RequestItem rei:re.requestItems){
                if (rei.standFront){
                    System.out.println("\t stand front of "+rei.member);
                }else{
                    System.out.println("\t stand behind of "+rei.member);
                }

            }

        }


        for (Request r : requests)
        {
            if (r.requestItems != null && r.requestItems.size() > 0)// 有要求
            {
                // 检查这个人的要求
                if (!checkRequest(r))
                {
                    throw new RuntimeException(r.owner + "要求不合法!");
                }
                int myi = allMembers.indexOf(r.owner);// 要求人的位置
                // 满足所有要求
                for (int i = 0, size = r.requestItems.size(); i < size; i++)
                {
                    RequestItem it = r.requestItems.get(i);

                    int otheri = allMembers.indexOf(it.member);// 调换人的位置
                    List<RequestItem> memberitems=findRequest(requests,it.member);//调换人的要求

                    // 是否与调换人的要求矛盾
                    if (checkStandFront(memberitems, r.owner,it.standFront))
                    {
                        //无结果
                        return null;
                    }
                    // allMembers.remove(r.owner);
                    allMembers.remove(myi);//
                    if (it.standFront)
                    {
                        // 前面
                        allMembers.add(otheri, r.owner);
                    } else
                    {
                        // 后面
                        allMembers.add(otheri + 1, r.owner);
                    }
                }
            }
        }
        return allMembers;
    }



    /**
     * 检查这个要求是否合法，包括要求数量，是否矛盾
     *
     * @param r
     * @return
     */
    boolean checkRequest(Request r)
    {
        if (r.requestItems.size() > 10)
        {
            return false;
        }
        return true;
    }

    /**
     * 检查items是否要求站在owner之前
     *
     * @return
     */
    boolean checkStandFront(List<RequestItem> items, String owner,
                            boolean StandFront)
    {
        if(items==null||items.size()==0)//无要求
        {
            return false;
        }
        for(RequestItem it:items)
        {
            if(it.member.equals(owner))
            {
                return it.standFront==StandFront;//我要站在你前面，你也要站在我前面
            }
        }
        return false;
    }

    /**
     * 查找member的需求，或者修改Request类
     * @return
     */
    List<RequestItem> findRequest(List<Request> requests, String member)
    {
        for(Request r:requests)
        {
            if(member.equals(r.owner))
            {
                return r.requestItems;
            }
        }
        return null;
    }


}
