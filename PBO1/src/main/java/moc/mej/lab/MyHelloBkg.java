package moc.mej.lab;

import ej.wadapps.app.BackgroundService;

public class MyHelloBkg implements BackgroundService {

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		System.out.println("Hello World !");
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		System.out.println("Bye");
	}

}
