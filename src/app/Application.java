package app;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {
	public static Logger logger = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new MyFirstRunnable("*"));
		Thread t2 = new Thread(new MyFirstRunnable("#"));
		
		t1.start();
		t2.start();
	}

}
