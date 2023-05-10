package exercise2;
import java.util.concurrent.atomic.AtomicInteger;

public class SumRunnable implements Runnable{
	
	private final int[] values;// array di valori
    private final int start; // indice di partenza
    private final int end; //fine 
    private final AtomicInteger result; //oggetto per memorizzare il risultato parziale

    public SumRunnable(int[] values, int start, int end, AtomicInteger result) {
        this.values = values;
        this.start = start;
        this.end = end;
        this.result = result;
    }

	@Override
	public void run() {
		 int sum = 0;
         for (int i = start; i < end; i++) {
             sum += values[i];
         }
         result.set(sum);
	}
}
