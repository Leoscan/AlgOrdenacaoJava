package util;
import java.util.Random;

public class FuncoesUteis {
	public static String ApresentaArray(int[] array) {
        StringBuilder sb = new StringBuilder();
        
        int length = Math.min(array.length, 10); // Limita o número de elementos a serem formatados em 10
        
        for (int i = 0; i < length; i++) {
            sb.append(array[i]);
            if (i < length - 1) {
                sb.append(", ");
            }
        }
        
        if (array.length > 10) {
            sb.append(", ...");
        }
        
        return sb.toString();
    }
	
	public static int[] geraArrayAleatorio(int size, int minValue, int maxValue) {
        int[] array = new int[size];
        Random random = new Random();
        
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(maxValue - minValue + 1) + minValue;
        }
        
        return array;
    } 
}
