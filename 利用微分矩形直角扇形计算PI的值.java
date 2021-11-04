package com.company;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author lyle
 * @date 2020/5/13
 */
public class piConduct1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入数字：");
        //该数字决定直角扇形微分的分数，数字越大，得到的结果越准确。
        double n=scanner.nextDouble();
        long t1=System.currentTimeMillis();
        //利用t1记录程序开始时的时间。
        double[]x=new double[(int)n+1];
        for (int i=0;i<x.length;i++){
            x[i]=1/n;
            x[i]=x[i]*i;
        }
        //求出每一个x的值。
        double[]y=new double[(int)n+1];
        for (int i=0;i<y.length;i++){
            y[i]=Math.sqrt(1-x[i]*x[i]);
        }
        //求出每一个y的值。
        double sum=0;
        for (int i=1;i<x.length-1;i++){
            sum=y[i]/n+sum;
        }
        //求出直角扇形的面积。
        double PI=4*sum;
        long t2=System.currentTimeMillis();//利用t2记录程序结束时的时间。
        System.out.println(PI);//打印PI的值
        System.out.println(t2-t1);//得到程序运行的时间。
    }
}
