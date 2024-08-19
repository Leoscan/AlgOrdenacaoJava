package algoritmos;

import interfaces.Ordenador;
import threadManager.ThreadManager;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSortMultiThreads implements Ordenador {
    private final int MAX_THREADS = 4;

    @Override
    public int[] Ordena(int[] array) {
        Integer[] boxedArray = Arrays.stream(array).boxed().toArray(Integer[]::new);
        threadedSort(boxedArray);
        return Arrays.stream(boxedArray).mapToInt(Integer::intValue).toArray();
    }

    public void threadedSort(Integer[] array) {
        long time = System.currentTimeMillis();
        final int length = array.length;
        boolean exact = length % MAX_THREADS == 0;
        int maxlim = exact ? length / MAX_THREADS : length / (MAX_THREADS - 1);
        maxlim = maxlim < MAX_THREADS ? MAX_THREADS : maxlim;
        final ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < length; i += maxlim) {
            int beg = i;
            int remain = length - i;
            int end = remain < maxlim ? i + (remain - 1) : i + (maxlim - 1);
            ThreadManager t = new ThreadManager(array, beg, end, this);
            Thread thread = new Thread(t);
            threads.add(thread);
            thread.start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException ignored) {}
        }

        // Merging the sorted segments
        for (int i = 0; i < length; i += maxlim) {
            int mid = i == 0 ? 0 : i - 1;
            int remain = length - i;
            int end = remain < maxlim ? i + (remain - 1) : i + (maxlim - 1);
            merge(array, 0, mid, end);
        }

        time = System.currentTimeMillis() - time;
        System.out.println("Time spent for custom multi-threaded merge_sort(): " + time + "ms");
    }

    public void mergeSort(Integer[] array, int begin, int end) {
        if (begin < end) {
            int mid = (begin + end) / 2;
            mergeSort(array, begin, mid);
            mergeSort(array, mid + 1, end);
            merge(array, begin, mid, end);
        }
    }

    public void merge(Integer[] array, int begin, int mid, int end) {
        Integer[] temp = new Integer[(end - begin) + 1];
        int i = begin, j = mid + 1;
        int k = 0;

        while (i <= mid && j <= end) {
            if (array[i] <= array[j]) {
                temp[k] = array[i];
                i += 1;
            } else {
                temp[k] = array[j];
                j += 1;
            }
            k += 1;
        }

        while (i <= mid) {
            temp[k] = array[i];
            i += 1;
            k += 1;
        }

        while (j <= end) {
            temp[k] = array[j];
            j += 1;
            k += 1;
        }

        for (i = begin, k = 0; i <= end; i++, k++) {
            array[i] = temp[k];
        }
    }
}
