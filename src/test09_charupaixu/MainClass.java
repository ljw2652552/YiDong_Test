package test09_charupaixu;

import java.util.Arrays;

public class MainClass {

    public static void main(String[] args) {
        int[] ints = new int[]{1,2,5,7,4,3,6,8,9,10};
        version1(ints);
        System.out.println(Arrays.toString(ints));
    }

    private static void version1(int[] ints) {
        for (int i = 1; i < ints.length; i++) {
            int curr = ints[i];
            int j = i - 1;
            for (;j > -1;--j){
                if (ints[j] > curr){
                    ints[j+1] = ints[j];
                }else {
                    break;
                }
            }

            ints[j+1] = curr;

        }
    }

}
