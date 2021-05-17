import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

public class Test {


    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
//        reflect();
//        xipai(10);
//        bublleSort(new int[]{1,2,3});
        System.out.println("hello git!!");
        System.out.println("hello git222!!");
        System.out.println("hello git333!!");
        System.out.println("hello git444!!");
        System.out.println("master test!!");
        System.out.println("hot-fix test!!");
        System.out.println("push test!!!!!!");

    }

    private static void bublleSort(int[] ints) {
    }

    /**
     *  问题：编写一段代码，实现通用的洗牌功能，具体是：输入整数n，终端输出0～n-1这个范围的顺序随机的n个数。
     * @param i
     */
    private static void xipai(int i) {

        HashSet<Integer> curr = new HashSet<Integer>();
        int[] ints = new int[i];
        ThreadLocalRandom ra = ThreadLocalRandom.current();

        for (int j = 0;j<ints.length;) {
            int k = ra.nextInt(i);
            if (curr.contains(k)){
                continue;
            }else {
                curr.add(k);
                ints[j] = k;
                j++;
            }
        }
        System.out.println(Arrays.toString(ints));
    }

    private static void reflect() throws InvocationTargetException, IllegalAccessException {
        TestReflect test = new TestReflect();
        Method[] methods = test.getClass().getMethods();

        for (int i = 0; i < methods.length; i++) {
            methods[i].setAccessible(true);
            System.out.println(methods[i].getName());
//            if (methods[i].getName().equals("wait")|methods[i].getName().equals("equals"))continue;
            methods[i].invoke(test);
        }
    }
}
