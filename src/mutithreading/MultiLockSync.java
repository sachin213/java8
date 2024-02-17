package mutithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MultiLockSync {

    /**
     * common method(dowork1,dowork2) which is shared by  common thread process t1,t2 , if it's doing manipulation on different object rather then making method
     * synchronized we should make object synchronized to make performace better
     */
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();

    private Object lock1 = new Object();
    private Object lock2 = new Object();
    public void process() throws InterruptedException {
        Long startTime = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            try {
                for(int i = 0;i <1000; i++){
                    doWork1();
                    doWork2();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                doWork1();
                doWork2();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        Long endTime = System.currentTimeMillis();

        System.out.println("total time :"+(endTime-startTime));

        System.out.println("list1 size"+list1.size());
        System.out.println("list1 size"+list2.size());


    }
    //public synchronized void doWork() throws InterruptedException { // it will work but will impact performance
        public  void doWork1() throws InterruptedException { // it will work but will impact performance
            synchronized (list1) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    list1.add(1);
                }
            }

    public  void doWork2() throws InterruptedException { // it will work but will impact performance
        synchronized (list2) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                list2.add(1);
        }
    }
    public static void main(String[] args) throws InterruptedException {

        MultiLockSync multiLockSync = new MultiLockSync();
            multiLockSync.process();

    }
}
