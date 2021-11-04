
import java.util.Arrays;

/**
 * @author lyle
 */
public class test3 {
    public static void main(String[] args) {
        int[] myList = new int[10];
        Arrays.fill(myList,0);
        System.out.println(Arrays.toString(myList));
        myList = new int[20];
        Arrays.fill(myList,1);
        System.out.println(Arrays.toString(myList));
    }
}
