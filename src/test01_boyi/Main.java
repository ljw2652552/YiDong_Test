package test01_boyi;


/**
 *小赛是一名聪明的程序员。
 *
 * 他的聪明确保他一定会应聘成功^_^~
 *
 * 在应聘会上，人事主管向小赛提出了这样一个问题——
 *
 *
 *
 * 这次招聘的规则是这样的。
 *
 * 一共有n个人（n>1）参加应聘。
 *
 * 人事主管事先选好了一个正整数x，他会把自己选的这个数x告诉前来应聘的每一个人。
 *
 * 每个人（包括小赛）都可以选择1~m中的任意一个实数（就不要问实数是怎么选的啦2333）。参加应聘的人都不会知道其他人选择了什么。
 *
 * 最后所有人都选完数后，我们会把所有数加起来，然后求个平均数(即除以(n+1))，再乘上p/q，设得到的结果为y(y也是个实数).
 *
 * 所有选择的数最接近y的应聘者会被企业选中。
 *
 *
 *
 * 这n个应聘者都同样足够聪明，这n个应聘者都知道其他人也足够聪明，这n个应聘者都想被企业选中。
 *
 * 请你告诉我们，小赛在这种情况下，需要选择1~m中的哪个数才会被企业选中呢？

 思路：
 首先明确：因为大家一样足够聪明，所以肯定会选一样的数
 假如没有p和q的调制，那么target=x。
 有p和q的调制后：((target*n+x)/(n+1))*(p/q) = target
 化简后：target= p*x/((n+1)*q-p*n)
 */

/**
 * 输入
 * 第一行三个正整数n,m,x，其中n表示参加应聘的人数，m表示应聘者选择数的范围是1~m，x表示人事主管选择的数x.
 *
 * 第二行两个正整数p,q，表示算出的平均数要乘上p/q.
 *
 *
 *
 * 数据保证——p<=q
 *
 * 数据保证——题目有解且有唯一解。
 *
 * 数据保证——
 *
 * 对于30%的测试点，2<=n<=5，1<=m,x<=5，1<=p<=q<=5
 *
 * 对于70%的测试点，2<=n<=100，1<=m,x<=100，1<=p<=q<=100
 *
 * 对于100%的测试点，2<=n<=10000，1<=m,x<=10000，1<=p<=q<=10000
 *
 * 样例输入
 * 2 4 9
 *
 * 2 3
 *
 * 输出
 * 输出一行，包含一个1~m范围内的实数，表示小蘑应当选择的数。（四舍五入保留2位小数）
 *
 * 样例输出
 * 3.60
 */


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while(input.hasNextInt()){
            int n = input.nextInt();
            int m = input.nextInt();
            int x = input.nextInt();
            int p = input.nextInt();
            int q = input.nextInt();
            if (n > 1 && m > 1 && x > 0 && p > 0 && q >= p){
                double answer = (double)(p * x) / ((n + 1) * q - p * n);
                if (answer > m) answer = m;
                if (answer < 1) answer = 1;
                System.out.printf("%.2f",answer);
                System.out.println();
            }
        }



    }
}
