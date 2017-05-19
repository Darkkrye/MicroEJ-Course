package moc.lab.pages;

import java.io.IOException;

import ej.microui.display.GraphicsContext;
import ej.microui.display.Image;
import ej.style.background.SimpleImageBackground;
import ej.style.util.EditableStyle;
import ej.widget.basic.Label;
import ej.widget.composed.Button;
import ej.widget.composed.ButtonImage;
import ej.widget.container.Grid;
import ej.widget.container.Split;
import ej.widget.listener.OnClickListener;
import ej.widget.navigation.page.Page;
import moc.lab.Program;

public class SplitPage extends Page {
	int count = 0;
	
	public SplitPage() {
		Split mySplit = new Split(false, (float)0.20);
		Split splitHeader = new Split(true, (float)0.20);
		
		Grid myGrid = new Grid();
		myGrid.setHorizontal(true);
		myGrid.setCount(3);

		
		for (int i = 0; i <= 8; i++) {
			Button myBtn = new Button("-");
			
			myBtn.addOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick() {
					if (myBtn.getText() == "X" || myBtn.getText() == "O") {
						return;
					} else {
						System.out.print("click ?");
						if ((count%2) == 0) {
							myBtn.setText("X");
						} else {
							myBtn.setText("O");
						}
						if (count == 8) {
							count = 0;
						}
						count++;
					}
					System.out.print(count);
					System.out.print(myBtn.getX());
				}
			});
			myGrid.add(myBtn);
		}
		
		Label labelTitle = new Label("Morpion");
		ButtonImage backImage = new ButtonImage("/images/back.png");
		backImage.addOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				System.out.println("Back plse ???!");
				Program.navigator.back();
			}
		});
		splitHeader.setFirst(backImage);
		splitHeader.setLast(labelTitle);
		mySplit.setFirst(splitHeader);
		// mySplit.setLast(btnBack);
		mySplit.setLast(myGrid);
		this.setWidget(mySplit);
	}
}
