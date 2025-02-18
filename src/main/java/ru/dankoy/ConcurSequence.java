package ru.dankoy;

import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurSequence {

    private static volatile boolean first = true;
    private static Lock lock = new ReentrantLock();

    public static void main(String... args) {

        Runnable firstSeq = () -> {

            int i = 0;

            while (i <= 100) {

                if (first) {
                    lock.lock();

                    System.out.println(Thread.currentThread().getName() + " " + i);
                    first = false;
                    i++;

                    lock.unlock();

                }

            }

        };

        Runnable secondSeq = () -> {

            int i = 0;

            while (i <= 100) {

                if (!first) {

                    lock.lock();

                    var current = str(i);
                    System.out.println(Thread.currentThread().getName() + " " + current);
                    first = true;
                    i++;
                    lock.unlock();
                }

            }

        };

        try (var executor = Executors.newFixedThreadPool(2);) {

            executor.execute(firstSeq);

            executor.execute(secondSeq);

        }

    }

    static String str(int i) {
        return i < 0 ? "" : str((i / 26) - 1) + (char) (65 + i % 26);
    }

}
