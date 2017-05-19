package moc.lab;

import ej.hal.gpio.GPIO;
import ej.hal.gpio.GPIO.Mode;

public class SensorModelAnalog {
	int DIGITAL_PORT = 30;
	int ANALOG_PORT = 31;
	
	int PIN__PWM1 = 3;
	int PIN_2_SENSOR = 1;
	
	public SensorModelAnalog() {
		GPIO.setMode(DIGITAL_PORT, PIN__PWM1, Mode.ANALOG_OUTPUT);
		GPIO.setMode(ANALOG_PORT, PIN_2_SENSOR, Mode.ANALOG_INPUT);
	}
	
	public int getValue() {
		int val = GPIO.getAnalogValue(ANALOG_PORT, PIN_2_SENSOR);
		return val;
	}
	
	public void setValue(int val) {
		GPIO.setAnalogValue(DIGITAL_PORT, PIN__PWM1, val);
	}
}
