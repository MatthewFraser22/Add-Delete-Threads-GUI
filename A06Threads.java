package cp213;

import java.awt.Color;

public class A06Threads implements Runnable{
	private int tName;
	private int max = 200;
	private Thread t;
	private boolean status = true;
	private int runTime = 0;
	private int sleepTime = 0;
	private A06Panels.ThreadPanel p;
	private volatile boolean flag = true;
	public A06Threads(int thread) {
		this.tName = thread;
		System.out.println("Creating Thread");
	}
	private void RandomNum() {
		this.runTime = (int)(Math.random()*100)+100;
		this.sleepTime = (int)(Math.random()* 100)+100;
		
	}
	public void setThreadPanel(A06Panels.ThreadPanel panel) {
		this.p = panel;
	}
	public int getRunTime() {
		return runTime;
	}
	public int getSleepTime() {
		return sleepTime;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean value) {
		status = value;
	}
	public int getThread() {
		return tName;
	}

	@Override
	public void run() {
		this.RandomNum();
		System.out.println("Running "+tName);
		try {
			
			while(this.flag) {
				setStatus(true);
				Thread.sleep(this.getRunTime());
				for(int i = 100; i < max; i++) {
					System.out.println(": "+i);
				}
				this.p.setBackground(Color.GREEN);
				System.out.println("RunTime: "+this.runTime);
				setStatus(false);
				Thread.sleep(this.getSleepTime());
				this.p.setBackground(Color.RED);
				
				
			}
			
			
		}catch (InterruptedException e) {
			System.out.println("Thread "+this.tName+" has been interrupted");
		}
		System.out.println("Thread "+tName +" exiting");
		
		
	}
	public void stopThread() {
		System.out.println("Stopping Thread: Please Wait");
		flag = false;
	}
	public void Start() {
		System.out.println("Starting Thread...");
		if(t == null) {
			t = new Thread(this);
			t.start();
		}
	}

}
