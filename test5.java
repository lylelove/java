import java.util.Arrays;
import java.util.Random;

/**
 * @author lyle
 */
public class test5 {
    public static void main(String[] args) {
         int[] a= new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] res = sum(a,100);
        System.out.println(Arrays.toString(res));
    }

    public static int[] sum(int[] qiPan,long num){
        int[] res ={0,0,0};
        for (long i=0;i<num;i++){
            switch (game(qiPan)){
                case 1:
                    res[0]++;
                    break;
                case 2:
                    res[1]++;
                    break;
                case 3:
                    res[2]++;
                    break;
                default:
            }
        }
        return res;
    }

    public static int game(int[] qiPan){
        int[] a = qiPan;
        int[] xiaoming = new int[9];
        int[] xiaohong = new int[9];
        int turn = 1;
        long d=System.currentTimeMillis();
        Random r =new Random(d);
        for (int i =0;i<=9;i++){
            if (!judgeGame(xiaoming) & !judgeGame(xiaohong)){

                int r1 =r.nextInt(9-i);
                if (turn%2==1){
                    xiaoming[turn/2+1]=a[r1];
                }else {
                    xiaohong[turn/2]=a[r1];
                }
                a = upDate(r1,a);
                if (a.length == 0){
                    break;
                }
                turn++;
            }else if (judgeGame(xiaoming)){
                return 1;
            }else if (judgeGame(xiaohong)){
                return 2;
            }
            d++;
        }
        return 3;
    }




    public static boolean judgeNumber (int[] targetArray, int number){
        for (int s:targetArray) {
            if (s==number){
                return true;
            }
        }
        return false;
    }

    public static boolean judgeGame (int[] targetArray){
        if (judgeNumber(targetArray, 1) & judgeNumber(targetArray, 2) & judgeNumber(targetArray, 3)){
            return true;
        }
        if (judgeNumber(targetArray, 1) & judgeNumber(targetArray, 4) & judgeNumber(targetArray, 7)){
            return true;
        }
        if (judgeNumber(targetArray, 1) & judgeNumber(targetArray, 5) & judgeNumber(targetArray, 9)){
            return true;
        }
        if (judgeNumber(targetArray, 4) & judgeNumber(targetArray, 5) & judgeNumber(targetArray, 6)){
            return true;
        }
        if (judgeNumber(targetArray, 7) & judgeNumber(targetArray, 8) & judgeNumber(targetArray, 9)){
            return true;
        }
        if (judgeNumber(targetArray, 2) & judgeNumber(targetArray, 5) & judgeNumber(targetArray, 8)){
            return true;
        }
        if (judgeNumber(targetArray, 3) & judgeNumber(targetArray, 6) & judgeNumber(targetArray, 9)){
            return true;
        }
        if (judgeNumber(targetArray, 3) & judgeNumber(targetArray, 5) & judgeNumber(targetArray, 7)){
            return true;
        }
        return false;
    }

    public static int[] upDate(int rand, int[] arr){
        if (arr.length>1){
            if (rand!=arr.length-1){
                for (int i=rand;i<arr.length-1;i++){
                    arr[i]=arr[i+1];
                }
                arr = Arrays.copyOf(arr,arr.length-1);
            }else {
                arr = Arrays.copyOf(arr,arr.length-1);
            }
        }else {
            arr = Arrays.copyOf(arr,arr.length-1);
        }
        return arr;
    }
}
