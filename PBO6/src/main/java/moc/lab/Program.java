package moc.lab;

import ej.microui.MicroUI;
import ej.microui.display.Colors;
import ej.microui.display.GraphicsContext;
import ej.mwt.Desktop;
import ej.mwt.Panel;
import ej.style.Stylesheet;
import ej.style.border.SimpleRectangularBorder;
import ej.style.outline.SimpleOutline;
import ej.style.selector.ClassSelector;
import ej.style.selector.EvenChildSelector;
import ej.style.selector.OddChildSelector;
import ej.style.util.EditableStyle;
import ej.style.util.StyleHelper;
import ej.wadapps.app.Activity;
import ej.widget.navigation.navigator.HistorizedNavigator;
import ej.widget.navigation.transition.HorizontalTransitionManager;
import moc.lab.pages.MainPage;

public class Program implements Activity {
	public static HistorizedNavigator navigator;

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRestart() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		MicroUI.start();
		navigator = new HistorizedNavigator();
		navigator.setTransitionManager(new HorizontalTransitionManager());
		navigator.show(new MainPage());
		Desktop desktop = new Desktop();
		Panel mainPanel = new Panel();
		mainPanel.setWidget(navigator);
		
		//set specific style
		Stylesheet sts = StyleHelper.getStylesheet();
		EditableStyle myS = new EditableStyle();	
		
		// style for a label
		EditableStyle mySLabel = new EditableStyle();
		mySLabel.setAlignment(GraphicsContext.HCENTER | GraphicsContext.VCENTER);
		mySLabel.setBackgroundColor(Colors.PURPLE);
		mySLabel.setForegroundColor(Colors.WHITE);
		
		//styles
		myS.setAlignment(GraphicsContext.HCENTER | GraphicsContext.VCENTER);
		myS.setForegroundColor(Colors.WHITE);
		myS.setBackgroundColor(Colors.BLUE);
		
		SimpleRectangularBorder bdr = new SimpleRectangularBorder(2);
		myS.setBorder(bdr);
		myS.setBorderColor(Colors.LIME);
		
		SimpleOutline marg = new SimpleOutline(5);
		myS.setMargin(marg);
		
		
		// odd
		EditableStyle itemStyleOdd = new EditableStyle();
		itemStyleOdd.setForegroundColor(Colors.BLUE);
		itemStyleOdd.setBackgroundColor(Colors.GREEN);
		itemStyleOdd.setAlignment(GraphicsContext.HCENTER | GraphicsContext.VCENTER);
		
		// even
		EditableStyle itemStyleEven = new EditableStyle();
		itemStyleEven.setForegroundColor(Colors.BLUE);
		itemStyleEven.setBackgroundColor(Colors.LIME);
		itemStyleEven.setAlignment(GraphicsContext.HCENTER | GraphicsContext.VCENTER);
		
		ClassSelector lbSelector = new ClassSelector("LABEL");
		ClassSelector btnSelector = new ClassSelector("BTN");
		// ClassSelector itemSelector = new ClassSelector("ITEM");
		
		OddChildSelector oddColor = new OddChildSelector();
		EvenChildSelector evenColor = new EvenChildSelector();
		
		
		// sts.addRule(new TypeSelector(Button.class), myS);
		sts.addRule(oddColor, itemStyleOdd);
		sts.addRule(evenColor, itemStyleEven);
		sts.addRule(btnSelector, myS);
		sts.addRule(lbSelector, mySLabel);
		
		mainPanel.show(desktop, true);
		desktop.show();
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
