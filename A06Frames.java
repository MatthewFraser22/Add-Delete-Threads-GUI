package cp213;

import javax.swing.JFrame;

public class A06Frames extends JFrame{
	
	public A06Frames() {
		this.setSize(1080,500);
		this.setTitle("Multi-Threading");
		this.setLocation(0,0);
		final A06FrameView view = new A06FrameView();
		this.setContentPane(view);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}

}
