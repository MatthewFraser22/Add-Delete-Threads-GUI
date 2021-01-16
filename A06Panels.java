package cp213;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class A06Panels extends JPanel{


public class ThreadPanel extends A06Panels{
	//instance of thread
	private A06Threads thread;
	//variable
	private Color color = Color.GREEN;
	//labels 
	private A06Labels status = new A06Labels("Status: ");
	
	public ThreadPanel(A06Threads thread) {
		this.setThread(thread);
		this.layoutView();
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	public void setThread(A06Threads thread) {
		this.thread = thread;
	}
	public A06Threads getThread() {
		return this.thread;
	}
	private class PropertyListener implements PropertyChangeListener{

		@Override
		public void propertyChange(PropertyChangeEvent arg0) {
			//updates running or paused status
			status.setText((thread.getStatus() == true) ? "Status: Running":"Status: Paused");
			ThreadPanel.this.repaint();
			
			
		}
		
	}
	private void layoutView() {
		this.setLayout(new GridLayout(2,8));
		this.setBackground(this.color);
		A06Labels threadLabel = new A06Labels("Thread #"+this.thread.getThread());
		A06Labels runTime = new A06Labels("RunTime: "+this.thread.getRunTime());
		A06Labels sleepTime = new A06Labels("SleepTime: "+this.thread.getSleepTime());
		
		this.addPropertyChangeListener(new PropertyListener());
		this.add(runTime);
		this.add(sleepTime);
		this.add(this.status);
		this.add(threadLabel);
		
	}
	
}

public class ButtonPanel extends A06Panels{
	//parent
	A06Listeners listener;
	//Buttons
	private A06Buttons addThread = new A06Buttons("Add a Thread");
	private A06Buttons deleteThread = new A06Buttons("Delete a Thread");
	//Labels
	private A06Labels threadNumber = new A06Labels("Number of threads: 0");
	
	public ButtonPanel(A06Listeners listener) {
		this.listener = listener;
		this.layoutView();
	}
	
	public void layoutView() {
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		//Add thread button
		this.addThread.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.addThread.setAlignmentY(Component.CENTER_ALIGNMENT);
		//Label layout
		this.threadNumber.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.threadNumber.setAlignmentY(Component.CENTER_ALIGNMENT);
		//Delete thread button allignment 
		this.deleteThread.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.deleteThread.setAlignmentY(Component.CENTER_ALIGNMENT);
		//Actionlisteners 
		this.addThread.addActionListener(listener.new AddThreadListener());
		this.deleteThread.addActionListener(listener.new DeleteThreadListener());
		
		this.add(addThread);
		this.add(deleteThread);
		this.add(threadNumber);
	}
	
	public void updateThreadNumber(int number) {
		//updates current running threads
		threadNumber.setText("Number of threads: "+ number);
	}
		
	
}

public class TContainer extends A06Panels{
	
	public TContainer() {
		this.layoutView();
	}
	private void layoutView() {
		//screen layout
		this.setLayout(new GridLayout(4,5,10,5));
	}
	
	public void addThread(A06Threads thread) {
		//Creates a new thread panel
		ThreadPanel np = new ThreadPanel(thread);
		thread.setThreadPanel(np);
		this.add(np);
	}
	
}

























}