package moc.lab.pages;

import ej.widget.basic.Label;
import ej.widget.composed.Button;
import ej.widget.container.List;
import ej.widget.container.Scroll;
import ej.widget.listener.OnClickListener;
import ej.widget.navigation.page.Page;
import moc.lab.Program;

public class ListPage extends Page {
	
	private static Scroll theScroll;
	private static List theList;
	
	public ListPage() {
		theList = new List(false);
		
		for (int i = 0; i <= 40; i++) {
			Label lbl = new Label("Element: " + String.valueOf(i));
			lbl.addClassSelector("ITEM");
			theList.add(lbl);
		}

		Button buttonBack = new Button("BACK");
		buttonBack.addOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				Program.navigator.back();
			}
		});
		
		theList.add(buttonBack);

		theScroll = new Scroll(false, true);
		theScroll.setWidget(theList);
		this.setWidget(theScroll);
	}
}
