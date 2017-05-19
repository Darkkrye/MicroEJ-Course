package moc.lab.pages;

import ej.components.dependencyinjection.ServiceLoaderFactory;
import ej.exit.ExitHandler;
import ej.widget.basic.Label;
import ej.widget.composed.Button;
import ej.widget.container.List;
import ej.widget.container.Split;
import ej.widget.listener.OnClickListener;
import ej.widget.navigation.page.Page;
import moc.lab.Program;

public class MainPage extends Page {

	public MainPage() {
		// TODO Auto-generated constructor stub
		// Button bt1 = new Button("Morpion");
		// ButtonImage bt1 = new ButtonImage("/images/play.png");
		// Button buttonList = new Button("Go to list");
		// buttonList.getLabel().addClassSelector("BTN");
		
		Button btnExit = new Button("EXIT");
		btnExit.getLabel().addClassSelector("BTN");
		
		Button btnToPage = new Button("Digital");
		btnToPage.getLabel().addClassSelector("BTN");
		
		Button btnToAnalog = new Button("Analog");
		btnToAnalog.getLabel().addClassSelector("BTN");
		// bt1.getLabel().addClassSelector("BTN");
		

		// Label lb1 = new Label("LABELLL");
		// lb1.addClassSelector("LABEL");
		
		Label labelTitle = new Label("App IoT");
		
		Split mySplit = new Split(false, (float)0.20);
		
		List myList = new List(false);
		
		/*
		bt1.addOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				System.out.println("Clicked 1111 !");
				Program.navigator.show(new SplitPage());
			}
		});
		*/
		/*
		buttonList.addOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				System.out.println("Go to list !");
				Program.navigator.show(new ListPage());
			}
		});
		*/
		btnToPage.addOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				Program.navigator.show(new SensorPage());
			}
		});
		
		btnToAnalog.addOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				Program.navigator.show(new Sensor2Page());
			}
		});
		
		btnExit.addOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				System.out.println("Click on exit button");
				ExitHandler eH = ServiceLoaderFactory.getServiceLoader().getService(ExitHandler.class);
				if (eH != null) {
					System.out.println("EXIT !");
					eH.exit();
				}
			}
		});
		// myList.add(lb1);
		// myList.add(bt1);
		// myList.add(buttonList);
		myList.add(btnToPage);
		myList.add(btnToAnalog);
		myList.add(btnExit);
		
		
		mySplit.setFirst(labelTitle);
		mySplit.setLast(myList);
		// this.setWidget(mySplit);

		this.setWidget(mySplit);
	}

}
