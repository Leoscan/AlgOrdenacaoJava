package main;

import util.FuncoesUteis;
import interfaces.*;
import algoritmos.*;

public class Main100k {
	public static void main(String[] args) {
		int tamanhoVetor100k = 100000;
		
		int[] ArrayAleatorio = FuncoesUteis.geraArrayAleatorio(tamanhoVetor100k, 1, tamanhoVetor100k);
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
		
		System.out.println("Tempo Ordenação (100k) Merge Sort: " + tempo100kMerge);
		System.out.println("Tempo Ordenação (100k) Quick Sort: " + tempo100kQuick);
	}
}
