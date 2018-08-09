package Game;

public class Test {
	private static Integer count = 0;
	public static void main(String[] args){
		final Object lock = new Object();
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized (lock) {
					for(int i = 0 ; i < 100000 ; i++){
						count++;
					}
				}
				
			}
		});
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized (lock) {
					for(int i = 0 ; i < 100000 ; i++){
						count++;
					}
				}
				
			}
		});
		
		t1.start();
		t2.start();
		try{
			t1.join();
			t2.join();
		} catch (InterruptedException ie) {
			
		}
		System.out.println(count);
	}
}
