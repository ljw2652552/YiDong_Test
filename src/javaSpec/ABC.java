package javaSpec;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ABC {
    private static final Lock lock = new ReentrantLock();
    private static final Condition conditionA = lock.newCondition();
    private static final Condition conditionB = lock.newCondition();
    private static final Condition conditionC = lock.newCondition();
    private static int count = 0;

    static class A implements Runnable {

        @Override
        public void run() {

          /*  ArrayBlockingQueue<String> strings = new ArrayBlockingQueue<String>();
            strings.put("a");*/
            try{
            lock.lock();
            if (count %3 != 0) conditionA.await();
            System.out.println("A:=========" + Thread.currentThread().getName());
            count++;
            conditionB.signal();
            }
            catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
    static class B implements Runnable {
        @Override
        public void run() {
            try{
                lock.lock();
                if (count %3 != 1) conditionB.await();
                System.out.println("B:=========" + Thread.currentThread().getName());
                count++;
                conditionC.signal();
            }
            catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

    static class C implements Runnable {
        @Override
        public void run() {
            try{
                lock.lock();
                if (count %3 != 2) conditionC.await();
                System.out.println("C:=========" + Thread.currentThread().getName());
                count++;
                conditionA.signal();
            }
            catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }


    public static void main(String[] args) {
        new Thread(new A()).start();
        new Thread(new B()).start();
        new Thread(new C()).start();
    }
}
