import java.util.Arrays;
import java.util.Random;

public class test1 {
    public static void main(String[] args) {
      Random r = new Random(System.currentTimeMillis());
        for (int i =0;i<100;i++){
            System.out.println(r.nextInt(100));
            System.out.println(r.nextInt(100));
        }


    }
}
