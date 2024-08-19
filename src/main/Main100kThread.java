package main;

import algoritmos.MergeSortMultiThreads;
import algoritmos.QuickSortMultiThreads;
import util.FuncoesUteis;

public class Main100kThread {
	public static void main(String[] args) {
		int tamanhoVetor100k = 100000;
		
		int[] ArrayAleatorio = FuncoesUteis.geraArrayAleatorio(tamanhoVetor100k, 1, tamanhoVetor100k);
		System.out.println("Array Gerado 100k: ");
		System.out.println(FuncoesUteis.ApresentaArray(ArrayAleatorio));

        MergeSortMultiThreads sorter = new MergeSortMultiThreads();
        QuickSortMultiThreads quickSort = new QuickSortMultiThreads(0, ArrayAleatorio.length - 1, ArrayAleatorio);

        int[] sortedArray = sorter.Ordena(ArrayAleatorio);
        int[] sortedArray2 = quickSort.Ordena(ArrayAleatorio);

	}
}
