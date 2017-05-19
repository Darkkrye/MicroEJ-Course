package moc.lab;

import java.util.Timer;
import java.util.TimerTask;

import ej.hal.gpio.GPIO;
import ej.hal.gpio.GPIO.Mode;
import ej.wadapps.app.BackgroundService;

public class MainActivity implements BackgroundService {
	
	int DIGITAL_PORT = 30;
	int PIN_DIGITAL_LEDR = 13;
	int PIN_DIGITAL_LEDG = 12;
	int PIN_DIGITAL_LEDB = 11;
	int PIN_DIGITAL_BTN1 = 10;
	boolean red = true;

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		GPIO.setMode(DIGITAL_PORT, PIN_DIGITAL_LEDR, Mode.DIGITAL_OUTPUT);
		GPIO.setMode(DIGITAL_PORT, PIN_DIGITAL_LEDG, Mode.DIGITAL_OUTPUT);
		GPIO.setMode(DIGITAL_PORT, PIN_DIGITAL_LEDB, Mode.DIGITAL_OUTPUT);
		GPIO.setMode(DIGITAL_PORT, PIN_DIGITAL_LEDB, Mode.DIGITAL_INPUT);
		
		Timer t = new Timer();
		TimerTask tt = new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if (red == true) {
					setColors(true, false, false);
				} else {
					setColors(false, false, false);
				}
			}
		};
		
		t.schedule(tt, 1);
	}
	
	public void setColors(boolean R, boolean G, boolean B)
	{
		GPIO.setDigitalValue(DIGITAL_PORT, PIN_DIGITAL_LEDR, R);
		GPIO.setDigitalValue(DIGITAL_PORT, PIN_DIGITAL_LEDG, G);
		GPIO.setDigitalValue(DIGITAL_PORT, PIN_DIGITAL_LEDB, B);
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		
	}

}
