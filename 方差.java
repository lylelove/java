package javatest;

/**
 * @author lyle
 * @date 2020/5/30
 */
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Subsets90 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        int[] nums =new int[num];
        for (int i=0;i<nums.length;i++){
            nums[i]=scanner.nextInt();
        }
        List<List<Integer>> set=subsetsWithDup(nums);
        double DX=0;
        for (int i=0;i<set.size();i++){
            if (set.get(i).size()>1){
                double dx1=0;
                double dx2=0;
                for (int j=0;j<set.get(i).size();j++){
                    dx1=dx1+set.get(i).get(j);
                }
                dx1=dx1/set.get(i).size();
                for (int j=0;j<set.get(i).size();j++){
                    dx2=dx2+Math.pow((set.get(i).get(j)-dx1),2);
                }
                dx2=dx2/set.get(i).size();
                DX=DX+dx2;
            }
        }
        if (num>1){
            String ab= String.valueOf(DX);
            BigDecimal SHU=new BigDecimal("1000000007");
            BigDecimal AB=new BigDecimal(ab);
            String result= String.valueOf(SHU.remainder(AB));
            double result1= Double.parseDouble(result);
            System.out.printf("%4.7f",result1);
        }else {
            System.out.println(0);
        }
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        helper(res, new ArrayList<>(), nums, 0);
        return res;
    }
    private static void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int index) {
        res.add(new ArrayList<Integer>(list));
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            helper(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
