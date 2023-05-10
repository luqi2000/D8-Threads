package exercise2;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class SumMain {
	

	public static void main(String[] args) throws InterruptedException {
		//Array di interi con un metodo a cui passo 3000 come numero(vedi giu il metodo)
		int[] values = generateRandomArray(3000);

        AtomicInteger result1 = new AtomicInteger();
        AtomicInteger result2 = new AtomicInteger();
        AtomicInteger result3 = new AtomicInteger();
        
        
        //crea tre thread figli, ciascuno con una partizione dell'array 
        //da sommare.

        Thread thread1 = new Thread(new SumRunnable(values, 0, 1000, result1));
        Thread thread2 = new Thread(new SumRunnable(values, 1000, 2000, result2));
        Thread thread3 = new Thread(new SumRunnable(values, 2000, 3000, result3));

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        int sum = result1.get() + result2.get() + result3.get();
        System.out.println("Somma totale: " + sum);
	}
	// Metodo per generare un array di numeri casuali
	private static int[] generateRandomArray(int size) {
        Random random = new Random();
        //istanzio un array con 3000 elementi
        int[] array = new int[size];
        
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);// da 0 a 3000 all'interno ad array pero
            //poi con random.nexInt diventano numeri da 0 a 100 casuali.
        }
        return array;
	}
}
