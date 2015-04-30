package ui;

public class Monitor extends Thread {

	public static void startMonitor(){
		new Monitor().start();
	}
	
	public void run () {
		while (true) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Read r = new Read();
			r.readTxtFile("E:/test.txt");
		}		
	}
}
