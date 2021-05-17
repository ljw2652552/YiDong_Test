package test08_maopaopaixu;

import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {

        int[] ints = new int[]{1,2,30,11,4,3,6,8,9,10};
        version2(ints);

        System.out.println(Arrays.toString(ints));
    }
    public static void version1(int[] ints){

        for (int i = 0; i < ints.length - 1; i++) {
            for (int j = 0; j < ints.length - 1 - i; j++) {
                if (ints[j] > ints[j + 1]){
                    int temp = ints[j];
                    ints[j] = ints[j+1];
                    ints[j+1] = temp;
                }
            }
        }
    }
    public static void version2(int[] ints){

        for (int i = 0; i < ints.length - 1; i++) {
            int pos = 0;
            int k = ints.length - 1 - i;
            for (int j = 0; j < k; j++) {
                if (ints[j] > ints[j + 1]){
                    int temp = ints[j];
                    ints[j] = ints[j+1];
                    ints[j+1] = temp;
                    pos = j;
                }
            }
            if (pos == 0) return;
            k = pos;
        }
    }
}
