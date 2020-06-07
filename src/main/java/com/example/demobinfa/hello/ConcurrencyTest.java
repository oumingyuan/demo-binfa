package com.example.demobinfa.hello;

public class ConcurrencyTest {


    private static final long count = 10000L;

    public static void main(String[] args) {
        concurrency();
        serial();
    }

    private static void serial() {
    }

    private static void concurrency() {
        long start = System.currentTimeMillis();
        new Thread(() -> {
            int a = 0;
            for (long i = 0; i < count; i++) {
                a += 5;
            }
        }).start();


        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println();

    }

}
