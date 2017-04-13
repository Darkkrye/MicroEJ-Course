package moc.mej.lab;

import ej.microui.MicroUI;
import ej.microui.display.Display;
import ej.wadapps.app.Activity;

public class MyActivity implements Activity {
	
	MyProgram myP;

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		MicroUI.start();
		myP = new MyProgram(Display.getDefaultDisplay());
		myP.show();
	}

	@Override
	public void onRestart() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub

	}

}
