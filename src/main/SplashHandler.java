package main;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.splash.AbstractSplashHandler;

//import fable.framework.toolbox.SplashScreen;

public class SplashHandler extends AbstractSplashHandler {

	/**
	 * 
	 */
	public SplashHandler() {
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.splash.AbstractSplashHandler#init(org.eclipse.swt.widgets
	 * .Shell)
	 */
	public void init(final Shell splash) {
		// Store the shell
		super.init(splash);
		FillLayout layout = new FillLayout();
		getSplash().setLayout(layout);
		getSplash().setBackgroundMode(SWT.INHERIT_DEFAULT);
		splash.layout(true);
	}
}