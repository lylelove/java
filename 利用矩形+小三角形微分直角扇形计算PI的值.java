package com.company;
import java.util.Scanner;
/**
 * @author lyle
 * @date 2020/5/13
 */
public class piConduct2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入数字：");
        double n=scanner.nextDouble();
        long t1=System.currentTimeMillis();
        double[]x=new double[(int)n+1];
        for (int i=0;i<x.length;i++){
            x[i]=1/n;
            x[i]=x[i]*i;
        }
        double[]y=new double[(int)n+1];
        for (int i=0;i<y.length;i++){
            y[i]=Math.sqrt(1-x[i]*x[i]);
        }
        double sum1=0;
        double sum2=0;
        for (int i=0;i<y.length-1;i++){
            sum1=(y[i]-y[i+1])/n/2+sum1;
        }
        for (int i=1;i<x.length-1;i++){
            sum2=y[i]/n+sum2;
        }
        double PI=4*(sum1+sum2);
        long t2=System.currentTimeMillis();
        System.out.println(PI);
        System.out.println(t2-t1);
    }
}
