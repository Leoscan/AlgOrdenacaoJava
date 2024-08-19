package algoritmos;

import interfaces.Ordenador;

public class QuickSort implements Ordenador {
	
	public int[] Ordena(int[] array) {
        quicksort(array, 0, array.length - 1);
        return array;
    }
	
    private void quicksort(int[] array, int low, int high) {
        if (low < high) {
            if (isSorted(array, low, high))
                return;

            int pivotIndex = partition(array, low, high);
            quicksort(array, low, pivotIndex - 1);
            quicksort(array, pivotIndex + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int mid = low + (high - low) / 2;
        swap(array, mid, high);

        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);

        return i + 1;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private boolean isSorted(int[] array, int low, int high) {
        for (int i = low; i < high; i++) {
            if (array[i] > array[i + 1])
                return false;
        }
        return true;
    }
	 
}
