package app;

public class MyFirstRunnable implements Runnable{
	private String symbol;

	public MyFirstRunnable(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public void run() {
		for(int i = 0; i<=10; i++) {
	
			Application.logger.info(symbol);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
