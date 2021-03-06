package moc.lab;

import java.util.Timer;
import java.util.TimerTask;

import ej.microui.display.Colors;
import ej.microui.display.Display;
import ej.microui.display.Displayable;
import ej.microui.display.GraphicsContext;
import ej.microui.event.Event;
import ej.microui.event.generator.Pointer;
import ej.microui.util.EventHandler;

public class Program extends Displayable implements EventHandler {
	
	int pX, pY;
	boolean dragg, rubber, inverseX, inverseY = false;

	public Program(Display display) {
		super(display);
		// TODO Auto-generated constructor stub
		Timer t = new Timer();
		t.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(".");
				if (inverseX)
					pX--;
				else
					pX++;
				
				if (inverseY)
					pY--;
				else
					pY++;
				
				if (pX >= Display.getDefaultDisplay().getWidth() || pX < 1)
					inverseX = !inverseX;
				
				if (pY >= Display.getDefaultDisplay().getHeight() || pY < 1)
					inverseY = !inverseY;
				
				dragg = true;
				repaint();
			}
			
		}, 0, 10);
	}

	@Override
	public boolean handleEvent(int event) {
		// TODO Auto-generated method stub
		if (Event.getType(event) == Event.POINTER) {
			if (Pointer.isDragged(event)) {
				Pointer p = (Pointer)Event.getGenerator(event);
				pX = p.getX();
				pY = p.getY();
				dragg = true;
				repaint();
			} else {
				if (Pointer.isDoubleClicked(event))
					rubber = !rubber;
			}
		} else {
			repaint();
		}
		
		return false;
	}

	@Override
	public void paint(GraphicsContext g) {
		// TODO Auto-generated method stub
		/*g.setColor(Colors.GRAY);
		g.fillRect(0, 0, Display.getDefaultDisplay().getWidth(), Display.getDefaultDisplay().getHeight());
		g.setColor(Colors.CYAN);
		g.fillCircle(10, 10, 200);*/
		if (dragg) {
			if (rubber)
				g.setColor(Colors.WHITE);
			else
				g.setColor(Colors.RED);
			g.fillCircle(pX, pY, 10);
			dragg = false;
		} else {
			g.setColor(Colors.GRAY);
			g.fillRect(0, 0, Display.getDefaultDisplay().getWidth(), Display.getDefaultDisplay().getHeight());
		}
	}

	@Override
	public EventHandler getController() {
		// TODO Auto-generated method stub
		return this;
	}

}
