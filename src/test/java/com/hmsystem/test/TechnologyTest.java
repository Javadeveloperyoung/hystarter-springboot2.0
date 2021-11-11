package com.hmsystem.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TechnologyTest {

    public static void main(String[] args) {
        arrayToList();
        listToArray();
    }

    /**
     * 配列がリストを変更する
     */
    public static void arrayToList(){
        String[] str = {"213","241","1241","1241"};
        List<String> alist = new ArrayList<String>();
        // 把数组转成集合，也就是把数组里面的数据存进集合；
        Collections.addAll(alist,str);
        for(String s:alist){
            System.out.println(s);
        }
    }

    /**
     * リストが配列を変更する
     */
    public static void listToArray(){
        List<String> list = new ArrayList<String>();
        list.add("開始");
        list.add("世界");
        list.add("安養寺");
        list.add("ソフト開発");
        list.add("終了");
        System.out.println("-----"+list.get(0));
        String[] arrayStr =list.toArray(new String[list.size()]);
        for (int i=0; i<arrayStr.length; i++) {
            System.out.println(arrayStr[i]);
        }
    }
}
