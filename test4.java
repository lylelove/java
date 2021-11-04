import java.util.Scanner;

/**
 * @author lyle
 */
public class test4 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        String a = scanner.next();
        System.out.println(a.length());
        int z1 = 0,z2=0,z3=0,z4=0,z5=0,z6=0,z7=0,z8=0,z9=0,z0=0;
        for (int i=0;i<a.length();i++){
            int b = Integer.parseInt(String.valueOf(a.charAt(i)));
            if (b==1) {
                z1 = z1 + 1;
            } else if (b==2) {
                z2 = z2 + 1;
            } else if (b == 3) {
                z3 = z3 + 1;
            } else if (b == 4) {
                z4 = z4 + 1;
            } else if (b== 5) {
                z5 = z5 + 1;
            } else if (b == 6) {
                z6 = z6 + 1;
            } else if (b == 7) {
                z7 = z7 + 1;
            } else if (b == 8) {
                z8 = z8 + 1;
            } else if (b== 9) {
                z9 = z9 + 1;
            } else if (b == 0) {
                z0 = z0 + 1;
            }
        }
        System.out.println(z0);
        System.out.println(z1);
        System.out.println(z2);
        System.out.println(z3);
        System.out.println(z4);
        System.out.println(z5);
        System.out.println(z6);
        System.out.println(z7);
        System.out.println(z8);
        System.out.println(z9);
    }
}
