package test04_yuedeerren;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String in = input.nextLine();
        String stand = input.nextLine();
        int count = 0;
        for (int i = 0; i < in.length(); i++) {
            if (Character.isLetterOrDigit(in.charAt(i)) &&  '1' == stand.charAt(i) ){
                count++;
            }else if (!Character.isLetterOrDigit(in.charAt(i)) && '0' == stand.charAt(i)){
                count++;
            }
        }
        System.out.printf("%.2f",(double)count*100/in.length());
        System.out.printf("%%",count/in.length());

    }
}
