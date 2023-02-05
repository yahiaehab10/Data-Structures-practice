package Sorting;

import java.util.Random;

public class Sorting {

    public static void bubbleSort(int[] a) {
        int n = a.length - 1, temp;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (n - i); j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[index]) {
                    index = j;
                }
            }
            int smallerNumber = a[index];
            a[index] = a[i];
            a[i] = smallerNumber;
        }
    }

    public static void insertionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int val = a[i];
            int c = i - 1;
            while (c >= 0 && val < a[c]) {
                a[c + 1] = a[c];
                c--;
            }
            a[c + 1] = val;
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static int[] indexSort(int[] a, int x) {
        int[] res = new int[a.length];
        int c = a.length - 1;
        for (int i = 0; i < res.length; i++) {
            if (a[i] > x)
                c--;
        }
        res[c] = x;
        return res;
    }

    // MIDTERM EXAM 2015
    public static void bogoSort(int[] a) {
        int c=0;
        while (!isSorted(a)){
            shuffleArray(a);
            c++;
            System.out.println(c);
        }
    }

    private static boolean isSorted(int[] a) {
        boolean flag = false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < a[i + 1] && i > a.length)
                flag = true;
            else
                return false;
        }
        return flag;
    }

    private static void shuffleArray(int[] a) {
        int n = a.length;
        Random random = new Random();
        random.nextInt();
        for (int i = 0; i < n; i++) {
            int change = i + random.nextInt(n - i);
            swap(a, i, change);
        }
    }

    private static void swap(int[] a, int i, int change) {
        int helper = a[i];
        a[i] = a[change];
        a[change] = helper;
    }

    ///////////////////

    public static void main(String[] args) {
        int[] x = { 4, 3, 8, 2 };

        bogoSort(x);
    }
}
