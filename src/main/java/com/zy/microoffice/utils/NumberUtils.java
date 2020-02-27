package com.zy.microoffice.utils;

import java.util.Random;

public class NumberUtils {
    /**
     * 返回区间内的随机整数
     * @param start 开始值
     * @param end   结束值
     * @return
     */
    public static int getNumberByRange(int start,int end){
        Random random=new Random();
        return random.nextInt(end)%(end-start+1) + start;
    }
}
