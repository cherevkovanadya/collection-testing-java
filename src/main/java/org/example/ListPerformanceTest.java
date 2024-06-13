package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListPerformanceTest {

    public static void main(String[] args) {
        int iterations = 10000;

        List<Integer> arrayList = new ArrayList<>();
        long arrayListAddTime = testAddPerformance(arrayList, iterations);
        long arrayListGetTime = testGetPerformance(arrayList, iterations);
        long arrayListRemoveTime = testRemovePerformance(arrayList, iterations);

        List<Integer> linkedList = new LinkedList<>();
        long linkedListAddTime = testAddPerformance(linkedList, iterations);
        long linkedListGetTime = testGetPerformance(linkedList, iterations);
        long linkedListRemoveTime = testRemovePerformance(linkedList, iterations);

        System.out.printf("%-15s %-15s %-15s %-15s\n", "Method", "Iterations", "ArrayList Time", "LinkedList Time");
        System.out.printf("%-15s %-15d %-15d %-15d\n", "add", iterations, arrayListAddTime, linkedListAddTime);
        System.out.printf("%-15s %-15d %-15d %-15d\n", "get", iterations, arrayListGetTime, linkedListGetTime);
        System.out.printf("%-15s %-15d %-15d %-15d\n", "remove", iterations, arrayListRemoveTime, linkedListRemoveTime);
    }

    private static long testAddPerformance(List<Integer> list, int iterations) {
        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            list.add(i);
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000;
    }

    private static long testGetPerformance(List<Integer> list, int iterations) {
        if (list.isEmpty()) {
            for (int i = 0; i < iterations; i++) {
                list.add(i);
            }
        }
        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            list.get(i);
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000;
    }

    private static long testRemovePerformance(List<Integer> list, int iterations) {
        if (list.isEmpty()) {
            for (int i = 0; i < iterations; i++) {
                list.add(i);
            }
        }
        long startTime = System.nanoTime();
        if (iterations > 0) {
            list.subList(0, iterations).clear();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000;
    }
}