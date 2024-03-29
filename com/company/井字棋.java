package com.company;
import java.util.Arrays;
import java.util.Scanner;
/**
 * @author lyle
 * @date 2020/6/19
 */
class TicTacToe {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int[][]qiPan=new int[3][3];
        for (int i=0;i<qiPan.length;i++){
            Arrays.fill(qiPan[i], 0);
        }
        System.out.println("棋盘如下：");
        Pan(qiPan);
        int juShu=0,shuMax=9,res=4;
        boolean jie=true;
        boolean yes;
        while (juShu<shuMax){
            System.out.println("请输入第"+(juShu+1)+"个棋子的行数");
            for (int i = 0; i < 1; i++) {
                int a = input.nextInt();
                if (a > 3 | a < 1) {
                    System.out.println("请重新输入");
                    continue;
                }
                System.out.println("请输入第" + (juShu + 1) + "个棋子的列数");
                int b = input.nextInt();
                if (b > 3 | b < 1) {
                    System.out.println("请重新输入");
                    continue;
                }
                qiPan[a - 1][b - 1] = 1;
                Pan(qiPan);
                jie=false;
                yes=result(qiPan);
                if (yes){
                    juShu=9;
                    jie=true;
                }
            }
            if(!jie){
            PanAi(qiPan);
            yes= result(qiPan);
            if (yes){
               juShu=9;
            }
            juShu++;
        }
        }
    }
    public static void Pan(int[][]pan){
        for (int[] ints : pan) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
    public  static  void PanAi(int [][]pan){

        System.out.println("电脑思考中：");
        long t1=System.currentTimeMillis();
        long time1= (long) (2000*Math.random()+1000);
        for (int time=0;time<time1;time++){
            long t2=System.currentTimeMillis();
            time=(int)(t2-t1);
        }
        for (int i=0;i<2;i++){
            int a= (int) (3*Math.random()+1);
            int b= (int) (3*Math.random()+1);
            if (pan[a-1][b-1]==0){
                pan[a-1][b-1]=2;
                i=3;
            }else{
               i--;
            }
        }
        Pan(pan);
    }
    public static boolean result(int[][]pan){
        boolean re=false;
        for (int i=0;i<pan.length;i++){
           if (pan[i][0]==pan[i][1]&pan[i][0]==pan[i][2]&pan[i][0]!=0){
               re=true;

               if (pan[i][0]==1){
                   System.out.println("你赢了");
               }else {
                   System.out.println("你输了");
               }
               i=4;
           }
           if(i!=4){
               if (pan[0][i]==pan[1][i]&pan[0][i]==pan[2][i]&pan[0][i]!=0){
                   re=true;
                   if (i<3){
                       if (pan[0][i]==1){
                           System.out.println("你赢了");
                       }else {
                           System.out.println("你输了");
                       }
                   }
                   i=4;
               }
           }
        }
        if (!re){
            if (pan[0][0]==pan[1][1]&pan[0][0]==pan[1][1]&pan[0][0]!=0){
                re=true;
                if (pan[0][0]==1){
                    System.out.println("你赢了");
                }else {
                    System.out.println("你输了");
                }
            }
            if (!re){
                if (pan[0][2]==pan[1][1]&pan[2][0]==pan[0][2]&pan[1][1]!=0){
                    re=true;
                    if (pan[1][1]==1){
                        System.out.println("你赢了");
                    }else {
                        System.out.println("你输了");
                    }
                }
            }
        }
        return re;
    }
}
