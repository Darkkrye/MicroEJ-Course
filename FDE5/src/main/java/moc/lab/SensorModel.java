package moc.lab;

import ej.hal.gpio.GPIO;
import ej.hal.gpio.GPIO.Mode;

public class SensorModel {
	int DIGITAL_PORT = 30;
	
	int PIN_1_LED = 11;
	int PIN_2_SENSOR = 12;
	
	public SensorModel() {
		GPIO.setMode(DIGITAL_PORT, PIN_2_SENSOR, Mode.DIGITAL_INPUT);
		GPIO.setMode(DIGITAL_PORT, PIN_1_LED, Mode.DIGITAL_OUTPUT);
	}
	
	public boolean getValueSensor() {
		boolean value = GPIO.getDigitalValue(DIGITAL_PORT, PIN_2_SENSOR);
		return value;
	}
	
	public void setValueSensor(boolean val) {
		GPIO.setDigitalValue(DIGITAL_PORT, PIN_1_LED, val);
	}
}
