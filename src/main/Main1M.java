package main;

import algoritmos.MergeSort;
import algoritmos.QuickSort;
import interfaces.Ordenador;
import util.FuncoesUteis;

public class Main1M {

	public static void main(String[] args) {
		int tamanhoVetor1M = 1000000;

		int[] ArrayAleatorio = FuncoesUteis.geraArrayAleatorio(tamanhoVetor1M, 1, tamanhoVetor1M);
		System.out.println("Array Gerado 100k: ");
		System.out.println(FuncoesUteis.ApresentaArray(ArrayAleatorio));

		Ordenador mergoSort = new MergeSort();
		Ordenador quickSort = new QuickSort();
		
		long inicio, fim;
		int[] Ordenado;
		
		// Ordenação Merge Sort 100k
		inicio = System.nanoTime();
		Ordenado = mergoSort.Ordena(ArrayAleatorio);
		fim = System.nanoTime();
		double tempo100kMerge = (fim - inicio)/1000000.0;
		
		// Ordenação Quick Sort 100k
		inicio = System.nanoTime();
		Ordenado = quickSort.Ordena(ArrayAleatorio);
		fim = System.nanoTime();
		double tempo100kQuick = (fim - inicio)/1000000.0;
		
		System.out.println("Tempo Ordenação (1M) Merge Sort: " + tempo100kMerge);
		System.out.println("Tempo Ordenação (1M) Quick Sort: " + tempo100kQuick);

	}

}
