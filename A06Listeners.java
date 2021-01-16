package cp213;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JOptionPane;


public class A06Listeners {
	private int threadName = 1;
	//Number of running threads
	private int threadNumber = 0;
	//number of threads created
	private int clicked = 0;
	private A06Panels.ButtonPanel p;
	private A06Panels.TContainer c;
	private A06Panels.ThreadPanel t;
	private A06Threads one;
	private A06Threads two;
	private A06Threads three;
	private A06Threads four;
	private A06Threads five;
	
	public void setTC(A06Panels.TContainer container) {
		this.c = container; 
	}
	public void setButtonPanel(A06Panels.ButtonPanel button) {
		this.p = button;
	}
	
	public class AddThreadListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			if (threadNumber < 5) {
				clicked += 1;
				
				if (clicked == 1) {
					A06Threads t1 = new A06Threads(threadName);
					one = t1;
					t1.Start();
					c.addThread(t1);
				}else if(clicked == 2) {
					A06Threads t2 = new A06Threads(threadName);
					two = t2;
					t2.Start();
					c.addThread(t2);
				}
				else if(clicked == 3) {
					A06Threads t3 = new A06Threads(threadName);
					three = t3;
					
					t3.Start();
					c.addThread(t3);
				}
				else if(clicked == 4) {
					A06Threads t4 = new A06Threads(threadName);
					four = t4;
					t4.Start();
					c.addThread(t4);
				}
				else if(clicked == 5) {
					A06Threads t5 = new A06Threads(threadName);
					five = t5;
					t5.Start();
					c.addThread(t5);
				}
				
				if (clicked <= 5) {
					threadNumber += 1;
					threadName += 1;
					p.updateThreadNumber(threadNumber);
					p.revalidate();
				}
			}else {
				JOptionPane.showMessageDialog(null, "Error you can only have 5 threads at most");
			}
			
			
		}
		
	}
	
	public class DeleteThreadListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			//threads.getThread();
			if(threadNumber != 0) {
				Component panelThread = c.getComponent(0);
				
				
				if(panelThread instanceof A06Panels.ThreadPanel){
					
					A06Threads thread = ((A06Panels.ThreadPanel) panelThread).getThread();
					thread.stopThread();
					
					threadNumber = threadNumber - 1; 
					clicked -= 1;
					
			        c.remove(panelThread); 
					p.updateThreadNumber(threadNumber);
			        c.repaint();
			    }
				
				
			}else {
				JOptionPane.showMessageDialog(null, "Error: No thread is current Running");
			}
			
		}
		
	}

}
