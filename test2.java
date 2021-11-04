import java.util.Scanner;

/**
 * @author lyle
 */
public class test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a= scanner.nextInt();
        System.out.println(factorial(a));
    }
    static long factorial(int n){
        if (n==1){
            return 1;
        }else{
            return n*factorial(n-1);
        }
    }
}
