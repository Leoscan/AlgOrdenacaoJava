package threadManager;

import algoritmos.MergeSortMultiThreads;

public class ThreadManager implements Runnable {
	private Integer[] array;
    private int begin;
    private int end;
    private MergeSortMultiThreads mergeSort;

    public ThreadManager(Integer[] array, int begin, int end, MergeSortMultiThreads mergeSort) {
        this.array = array;
        this.begin = begin;
        this.end = end;
        this.mergeSort = mergeSort;
    }

    @Override
    public void run() {
        mergeSort.mergeSort(array, begin, end);
    }
}
