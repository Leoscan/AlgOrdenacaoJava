package algoritmos;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

import interfaces.Ordenador;

public class QuickSortMultiThreads implements Ordenador {
    private static final int MAX_THREADS = 4; // Defina o número máximo de threads
    private int start, end;
    private int[] arr;

    public QuickSortMultiThreads(int start, int end, int[] arr) {
        this.start = start;
        this.end = end;
        this.arr = arr;
    }

    @Override
    public int[] Ordena(int[] array) {
        long startTime = System.currentTimeMillis(); // Start timing

        ForkJoinPool pool = new ForkJoinPool(MAX_THREADS);
        pool.invoke(new QuickSortTask(0, array.length - 1, array));

        long endTime = System.currentTimeMillis(); // End timing
        System.out.println("Time spent for custom multi-threaded QuickSort: " + (endTime - startTime) + "ms");

        return array;
    }

    private class QuickSortTask extends RecursiveTask<Void> {
        private int start, end;
        private int[] arr;

        public QuickSortTask(int start, int end, int[] arr) {
            this.start = start;
            this.end = end;
            this.arr = arr;
        }

        private int partition(int start, int end, int[] arr) {
            int i = start, j = end;
            int pivote = new Random().nextInt(j - i + 1) + i;

            // Swap the pivoted with end element of array
            int t = arr[end];
            arr[end] = arr[pivote];
            arr[pivote] = t;
            j--;

            // Start partitioning
            while (i <= j) {
                if (arr[i] <= arr[end]) {
                    i++;
                } else if (arr[j] >= arr[end]) {
                    j--;
                } else {
                    t = arr[j];
                    arr[j] = arr[i];
                    arr[i] = t;
                    j--;
                    i++;
                }
            }

            // Swap pivoted to its correct position
            t = arr[j + 1];
            arr[j + 1] = arr[end];
            arr[end] = t;
            return j + 1;
        }

        @Override
        protected Void compute() {
            // Base case
            if (start >= end) {
                return null;
            }

            // Find partition
            int p = partition(start, end, arr);

            // Create subtasks
            QuickSortTask left = new QuickSortTask(start, p - 1, arr);
            QuickSortTask right = new QuickSortTask(p + 1, end, arr);

            // Fork the left task
            left.fork();

            // Compute the right task and wait for the left task
            right.compute();
            left.join();

            return null;
        }
    }
}
