package test06_fenghuo.shibingduilie;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        sovle();
    }

    private static void sovle() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int[] sds = new int[n];
        for (int i = 0; i < sds.length; i++) {
            sds[i] = scanner.nextInt();
        }
        Arrays.sort(sds);
        int catos = 0;
        int[] nums = new int[n];
        int cnt = 0, i = n - 1;
        while (i >= 0) {
            cnt = 1;
            while (i > 0 && sds[i] == sds[i - 1]) {
                i--;
                cnt++;
            }
            nums[catos++] = cnt;
            i--;
        }
        long[][] dp = new long[catos + 1][m + 1];
        dp[1][1] = getFac(nums[0]);
        int cntSd = nums[0];
        for (int j = 2; j <= catos; j++) {
            cntSd += nums[j - 1];
            for (int k = 1; k <= m; k++) {
                long a1 = 1, a2 = 1;
                for (int l = 0; l < nums[j - 1] - 1; l++) {
                    a2 = (a2 * (cntSd - 1 - l)) % 1000000007;
                }
                a1 = (a2 * (cntSd - nums[j - 1])) % 1000000007;
                a2 = (a2 * (nums[j - 1])) % 1000000007;
                dp[j][k] = ((a1) * dp[j - 1][k] + (a2) * dp[j - 1][k - 1]) % 1000000007;
            }
        }
        System.out.println(dp[catos][m]);

    }

    private static int getFac(int i) {
        if (i <= 1) {
            return 1;
        } else {
            return i * getFac(i - 1);
        }
    }

}
