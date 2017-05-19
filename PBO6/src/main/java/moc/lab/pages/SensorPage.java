package moc.lab.pages;

import java.util.Timer;
import java.util.TimerTask;

import ej.widget.basic.Label;
import ej.widget.composed.Switch;
import ej.widget.container.Split;
import ej.widget.listener.OnStateChangeListener;
import ej.widget.navigation.page.Page;
import moc.lab.SensorModel;

public class SensorPage extends Page {
	boolean onoff = false;
	
	public SensorPage() {
		Split mySplitMain = new Split(false, (float)0.20);
		
		Label lblTitle = new Label("IoT - Digital");
		
		Split mySplitContent = new Split(true, (float)0.20);
		
		mySplitMain.setFirst(lblTitle);
		mySplitMain.setLast(mySplitContent);
		

		Switch theSwitch = new Switch("OFF");
		
		theSwitch.addOnStateChangeListener(new OnStateChangeListener() {
			
			@Override
			public void onStateChange(boolean newState) {
				// TODO Auto-generated method stub
				if (theSwitch.isChecked()) {
					theSwitch.setText("ON");
					onoff = newState;
				} else {
					theSwitch.setText("OFF");
					onoff = newState;
				}
				
				System.out.println(theSwitch.isChecked());
			}
		});
		
		SensorModel s = new SensorModel();
		s.setValueSensor(onoff);
		
		mySplitContent.setFirst(theSwitch);
		
		Label valueSensor = new Label();
		SensorModel sensor = new SensorModel();
		// SensorModel setSensor = new SensorModel();

		Timer t = new Timer();
		t.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				boolean val = sensor.getValueSensor();
				valueSensor.setText(String.valueOf(val));
				sensor.setValueSensor(val);
				repaint();
			}
			
		}, 0,50);
		
		mySplitContent.setLast(valueSensor);
		
		this.setWidget(mySplitMain);
	}
}
