package test05_ludeng;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * V先生有一天工作到很晚，回家的时候要穿过一条长l的笔直的街道，这条街道上有n个路灯。
 * 假设这条街起点为0，终点为l，第i个路灯坐标为ai。
 * 路灯发光能力以正数d来衡量，其中d表示路灯能够照亮的街道上的点与路灯的最远距离，所有路灯发光能力相同。
 * 为了让V先生看清回家的路，路灯必须照亮整条街道，又为了节省电力希望找到最小的d是多少？
 *
 * 思路:路灯的下标就是所在位置，相当于找最大间隔距离
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int lamp_count = input.nextInt();
        int street_length = input.nextInt();
        int[] lamps = new int[lamp_count];
        for (int i = 0; i < lamp_count; i++) {
            lamps[i] = input.nextInt();
        }
        Arrays.sort(lamps);

        double max_distance = 0;
        //计算街道开头是否路灯，不是的话记下距离
        if (lamps[0] != 0) max_distance = lamps[0];
        //计算街道结尾是否路灯
        if (lamps[lamp_count - 1] != street_length && lamps[lamp_count - 1] > lamps[0]) max_distance = lamps[lamp_count - 1];
        //计算中间路灯间隔
        for (int i = 0; i < lamp_count - 1; i++) {
           double distance = (double)(lamps[i + 1] - lamps[i]) / 2;
            if (distance > max_distance){
                max_distance = distance;
            }
        }
        System.out.printf("%.2f",max_distance);

    }
}
