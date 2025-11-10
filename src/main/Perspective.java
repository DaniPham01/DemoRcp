package main;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {
	
	

	public void createInitialLayout(IPageLayout page) {
		
        page.setEditorAreaVisible(true);
        page.setFixed(false);
	}
}
