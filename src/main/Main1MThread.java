package main;

import algoritmos.MergeSortMultiThreads;
import algoritmos.QuickSortMultiThreads;
import util.FuncoesUteis;

public class Main1MThread {
	public static void main(String[] args) {
		int tamanhoVetor1M = 1000000;
		
		int[] ArrayAleatorio = FuncoesUteis.geraArrayAleatorio(tamanhoVetor1M, 1, tamanhoVetor1M);
		System.out.println("Array Gerado 100k: ");
		System.out.println(FuncoesUteis.ApresentaArray(ArrayAleatorio));

        MergeSortMultiThreads sorter = new MergeSortMultiThreads();
        QuickSortMultiThreads quickSort = new QuickSortMultiThreads(0, ArrayAleatorio.length - 1, ArrayAleatorio);

        int[] sortedArray = sorter.Ordena(ArrayAleatorio);
        int[] sortedArray2 = quickSort.Ordena(ArrayAleatorio);

	}
}
