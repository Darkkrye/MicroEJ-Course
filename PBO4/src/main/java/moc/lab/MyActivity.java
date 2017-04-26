package moc.lab;

import ej.microui.MicroUI;
import ej.microui.display.Colors;
import ej.microui.display.GraphicsContext;
import ej.mwt.Desktop;
import ej.mwt.Panel;
import ej.style.Stylesheet;
import ej.style.background.SimpleRoundedPlainBackground;
import ej.style.outline.SimpleOutline;
import ej.style.selector.ClassSelector;
import ej.style.selector.TypeSelector;
import ej.style.selector.combinator.ChildCombinator;
import ej.style.util.EditableStyle;
import ej.style.util.StyleHelper;
import ej.wadapps.app.Activity;
import ej.widget.basic.Label;
import ej.widget.composed.Button;
import ej.widget.navigation.navigator.SimpleNavigator;
import ej.widget.navigation.transition.HorizontalTransitionManager;
import moc.lab.pages.MainPage;
import moc.lab.pages.SecondPage;

public class MyActivity implements Activity {
	
	public static SimpleNavigator nav;

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
		Desktop desk = new Desktop();
		Panel pnl = new Panel();
		
		/*HistorizedNavigator nav = new HistorizedNavigator();
		nav.show(new MainPage());*/
		
		nav = new SimpleNavigator();
		nav.setTransitionManager(new HorizontalTransitionManager());
		nav.show(MainPage.class.getName(), true);
		
		/*// Set specific style
		Stylesheet sts = StyleHelper.getStylesheet();
		EditableStyle myStyle = new EditableStyle();
		// Centered Yellow text on Navy background
		myStyle.setAlignment(GraphicsContext.HCENTER | GraphicsContext.VCENTER);
		myStyle.setForegroundColor(Colors.YELLOW);
		myStyle.setBackgroundColor(Colors.TEAL);
		sts.addRule(new TypeSelector(Label.class), myStyle);*/
		
		Stylesheet sts = StyleHelper.getStylesheet();
		// BUTTON Style based on Label & Button classes
		EditableStyle btnStyle = new EditableStyle();
		SimpleOutline btnMargin = new SimpleOutline(5);
		btnStyle.setMargin(btnMargin);
		btnStyle.setPadding(btnMargin);
		
		SimpleOutline myOutline = new SimpleOutline(5);
		btnStyle.setMargin(myOutline);
		
		SimpleRoundedPlainBackground myBackground = new SimpleRoundedPlainBackground(20);
		
		btnStyle.setBackground(myBackground);
		btnStyle.setBackgroundColor(Colors.TEAL);
		btnStyle.setForegroundColor(Colors.YELLOW);
		btnStyle.setAlignment(GraphicsContext.HCENTER | GraphicsContext.VCENTER);
		
		// Rule for labels child of buttons
		TypeSelector labelSelector = new TypeSelector(Label.class);
		TypeSelector buttonSelector = new TypeSelector(Button.class);
		ChildCombinator parentButtonSelector = new ChildCombinator(buttonSelector, labelSelector);

		sts.addRule(parentButtonSelector, btnStyle);
		
		// AUTRE BOUTON
		EditableStyle btnStyle2 = new EditableStyle();
		btnStyle2.setMargin(btnMargin);
		btnStyle2.setPadding(btnMargin);
		btnStyle2.setMargin(myOutline);
		
		SimpleRoundedPlainBackground myBackground2 = new SimpleRoundedPlainBackground(20);
		
		btnStyle2.setBackground(myBackground2);
		btnStyle2.setBackgroundColor(Colors.BLACK);
		btnStyle2.setForegroundColor(Colors.GRAY);
		btnStyle2.setAlignment(GraphicsContext.HCENTER | GraphicsContext.VCENTER);
		
		ClassSelector firstButton = new ClassSelector("BUTTON1");
		ChildCombinator parent2 = new ChildCombinator(firstButton, labelSelector);
		sts.addRule(parent2, btnStyle2);
		
		pnl.setWidget(nav);
		pnl.show(desk, true);
		desk.show();
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
