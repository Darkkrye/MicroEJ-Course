package moc.lab.pages;

import java.io.IOException;

import ej.components.dependencyinjection.ServiceLoaderFactory;
import ej.exit.ExitHandler;
import ej.microui.display.GraphicsContext;
import ej.microui.display.Image;
import ej.style.background.SimpleImageBackground;
import ej.widget.composed.Button;
import ej.widget.container.Split;
import ej.widget.listener.OnClickListener;
import ej.widget.navigation.page.Page;
import moc.lab.MyActivity;

public class SecondPage extends Page {
	Split mySplit;

	public SecondPage() {
		// TODO Auto-generated constructor stub
		mySplit = new Split(false, (float)0.75);
		
		Button bt1 = new Button("Return");
		bt1.addClassSelector("BUTTON1");
		Button bt2 = new Button("Exit");
		
		bt1.addOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				System.out.println("BUTTON 1-1");
				
				MyActivity.nav.show(MainPage.class.getName(), false);
			}
		});
		
		bt2.addOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				System.out.println("EXIT");
				ExitHandler eh = ServiceLoaderFactory.getServiceLoader().getService(ExitHandler.class);
				
				if (eh != null) {
					eh.exit();
				}
			}
		});
		
		mySplit.setFirst(bt1);
		mySplit.setLast(bt2);
		
		this.setWidget(mySplit); // Racine de l'arbre des widgets
	}
}
