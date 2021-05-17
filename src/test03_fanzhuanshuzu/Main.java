package test03_fanzhuanshuzu;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextInt()){
            int len = input.nextInt();
            int[] ints = new int[len];
            int[] copyInts = new int[len];
            for (int i = 0; i < len; i++) {
                ints[i] = input.nextInt();
                copyInts[i] = ints[i];
            }
            Arrays.sort(copyInts);

            int left = 0;
            int right = len - 1;
            while (ints[left] == copyInts[left] && left < len) left++;
            while (ints[right] == copyInts[right] && right > 0) right--;

            int i = 0;
            for (;i <= right - left;i++){
                if (ints[left + i] != copyInts[ right - i]) break;
            }
            if (i > right - left){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }

        }
    }

    public static void method01(){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt())
        {
            int len = scanner.nextInt();
            int[] array = new int[len];
            int[] copy = new int[len];
            for(int i=0;i<len;i++)
            {
                array[i] = scanner.nextInt();
                copy[i] = array[i];
            }
            Arrays.sort(copy);
            int left = 0,right = len-1;
            while(left<len && copy[left]==array[left]) left++;
            while(right>=0 && copy[right]==array[right]) right--;

            int i;
            for(i=0;i<=right-left;i++)
            {
                if(copy[left+i]!=array[right-i])
                    break;
            }
            if(i>right-left)
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
}
