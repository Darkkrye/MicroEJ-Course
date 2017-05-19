package moc.lab.pages;

import java.util.Timer;
import java.util.TimerTask;

import ej.widget.basic.Label;
import ej.widget.container.Split;
import ej.widget.navigation.page.Page;
import moc.lab.SensorModelAnalog;

public class Sensor2Page extends Page {
	int valueSensor;
	public Sensor2Page() {
		Split mySplitMain = new Split(false, (float)0.20);
		
		Label lblTitle = new Label("IoT - Analog");
		
		Split mySplitContent = new Split(true, (float)0.20);
		
		mySplitMain.setFirst(lblTitle);
		mySplitMain.setLast(mySplitContent);
		

		Label lblValue = new Label("null");
		lblValue.setText(String.valueOf(valueSensor + 1));
		
		SensorModelAnalog analog = new SensorModelAnalog();
	
		Timer t = new Timer();
		t.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				int value = analog.getValue();
				lblValue.setText(String.valueOf(value));
				// remove 300 and divide by 40
				int valToPut = (value - 300) / 40;
				analog.setValue(valToPut);
				repaint();
			}
			
		}, 0,150);
		
		mySplitContent.setLast(lblValue);
		
		this.setWidget(mySplitMain);
	}
}
