package com.company;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author lyle
 * @date 2020/5/13
 */
public class piConduct {


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入数字：");
        double a=scanner.nextInt();
        long t1=System.currentTimeMillis();
        double b=1/a;
        System.out.println(a);
        double[]x=new double[(int)a];
        for (int i=0;i<x.length;i++){
            x[i]=b*(i+1);
            x[i]=1-x[i]*x[i];
            x[i]=Math.sqrt(x[i]);
        }
        double result=0;
       for (int i=1;i<x.length-1;i++){
            result=x[i]*b+result;
        }
       result=result*4;
       long t2=System.currentTimeMillis();
        System.out.println(result);
        System.out.println(t2-t1);
    }

}
