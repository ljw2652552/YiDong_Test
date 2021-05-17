package test02_gushen;



/**
 * 题目描述
 * 有股神吗？
 * 有，小赛就是！
 * 经过严密的计算，小赛买了一支股票，他知道从他买股票的那天开始，股票会有以下变化：
 * 第一天不变，以后涨一天，跌一天，涨两天，跌一天，涨三天，跌一天...依此类推。
 * 为方便计算，假设每次涨和跌皆为1，股票初始单价也为1，请计算买股票的第n天每股股票值多少钱？
 * 输入
 * 输入包括多组数据；
 * 每行输入一个n，1<=n<=10^9 。
 * 样例输入
 * 1
 * 2
 * 3
 * 4
 * 5
 * 输出
 * 请输出他每股股票多少钱，对于每组数据，输出一行。
 * 样例输出
 * 1
 * 2
 * 1
 * 2
 * 3
 *
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int totalDay;
        while (input.hasNextInt()){
            totalDay = input.nextInt();
            boolean isRising = true;
            int curDay = 1;
            int baseRisingDays = 1;
            int sum = 1;
            while (curDay < totalDay){

                if (!isRising){
                    sum--;
                    curDay++;
                    isRising = true;
                    continue;
                }

                for (int i = 0; i < baseRisingDays; i++) {
                    if (curDay >= totalDay) break;
                    sum++;
                    curDay++;
                }
                isRising = false;
                baseRisingDays++;
            }
            System.out.println(sum);

        }

    }

    public static void method01(){

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        boolean isRising = true;
        int base = 1;
        int last = 1;
        for (int i = 1; i < n; i++) {
            if (!isRising) {
                isRising = true;
                last = last - 1;
                continue;
            }
            if (isRising) {
                for (int j = 0; j < base; j++) {
                    if(i>=n){
                        break;
                    }
                    last = last + 1;
                    i++;
                }
                isRising = false;
                i--;
                base++;
            }
        }
        System.out.println(last);
    }
}
