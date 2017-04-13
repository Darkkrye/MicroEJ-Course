package moc.mej.lab;

import ej.microui.display.Colors;
import ej.microui.display.Display;
import ej.microui.display.Displayable;
import ej.microui.display.GraphicsContext;
import ej.microui.util.EventHandler;

public class MyProgram extends Displayable implements EventHandler {
	
	int H;
	int L;

	public MyProgram(Display display) {
		super(display);
		// TODO Auto-generated constructor stub
		H = Display.getDefaultDisplay().getHeight();
		L = Display.getDefaultDisplay().getWidth();
	}

	@Override
	public boolean handleEvent(int event) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void paint(GraphicsContext g) {
		// TODO Auto-generated method stub
		g.setColor(Colors.LIME);
		g.fillCircle(0, 0, H/2);
	}

	@Override
	public EventHandler getController() {
		// TODO Auto-generated method stub
		return this;
	}

}
