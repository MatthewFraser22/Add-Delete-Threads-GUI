package cp213;
import java.awt.GridLayout;
public class A06FrameView extends A06Panels{
	
	public A06FrameView() {
	
		this.setLayout(new GridLayout(2,8));
		A06Listeners lis = new A06Listeners();
		ButtonPanel bp = new ButtonPanel(lis);
		TContainer tc = new TContainer();
		
		lis.setButtonPanel(bp);
		lis.setTC(tc);
		
		this.add(bp);
		this.add(tc);
		
	}

}
