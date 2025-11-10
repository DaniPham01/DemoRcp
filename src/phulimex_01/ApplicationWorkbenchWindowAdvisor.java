package phulimex_01;

import java.awt.Dimension;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IPerspectiveListener;
import org.eclipse.ui.IWindowListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPreferenceConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.handlers.IHandlerService;

import common.Constant;
import views.CustomerTree;

public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {


	private Constant constant = Constant.getInstance();
	public static String viewID = "";
	public int count = 0;
	public ApplicationWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
		super(configurer);
	}

	public ActionBarAdvisor createActionBarAdvisor(IActionBarConfigurer configurer) {
		return new ApplicationActionBarAdvisor(configurer);
	}

	public static IWorkbenchWindowConfigurer configurer = null;

	public void preWindowOpen() 
	{
		try
		{
			IWorkbenchWindowConfigurer configurer = getWindowConfigurer();

			PlatformUI.getPreferenceStore().setValue(IWorkbenchPreferenceConstants.SHOW_INTRO, true);


			Dimension dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
			configurer.setInitialSize(new Point((int)dim.getWidth(), (int)dim.getHeight()));

			configurer.setShowStatusLine(true);
				configurer.setShowPerspectiveBar(false);//#s
			configurer.setShowCoolBar(true);
			configurer.setShowProgressIndicator(true);


			ICommandService service = (ICommandService)PlatformUI.getWorkbench().getService(ICommandService.class);

			ApplicationWorkbenchWindowAdvisor.configurer = configurer;
			if (count == 0) {
				perspectiveListener();
			}



		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	} 
	 
	@Override
	public void postWindowOpen() {
		final IWorkbenchPage activePage = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage();

		getWindowConfigurer().getWindow().getWorkbench().addWindowListener(new IWindowListener() {
			
			@Override
			public void windowOpened(IWorkbenchWindow window) {
				CustomerTree myview = (CustomerTree) PlatformUI.getWorkbench().getActiveWorkbenchWindow().
						getActivePage().findView(constant.DH_ID);

			}
			
			@Override
			public void windowDeactivated(IWorkbenchWindow window) {}
			
			@Override
			public void windowClosed(IWorkbenchWindow window) {

			}
			@Override
			public void windowActivated(IWorkbenchWindow window) {
				IHandlerService handlerService = (IHandlerService) PlatformUI
						.getWorkbench().getActiveWorkbenchWindow()
						.getService(IHandlerService.class);
				
				try {
					handlerService.executeCommand(
							showView.ShowCustomerTree.ID,
							new Event());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		
	public void viewCheck(IWorkbenchPage page,
				IPerspectiveDescriptor perspective){
		
	}
		
	public void perspectiveListener() {

		PlatformUI.getWorkbench().getActiveWorkbenchWindow().addPerspectiveListener(new IPerspectiveListener() {
		

		@Override
		public void perspectiveChanged(IWorkbenchPage page,
				IPerspectiveDescriptor perspective, String changeId) {
			
		}

		
		@Override
		public void perspectiveActivated(IWorkbenchPage page,
				IPerspectiveDescriptor perspective) {
			viewCheck(page, perspective);
			page.closeAllEditors(false);
			page.resetPerspective();
			
		}
		});
	}
//#s]	
	
	public void postWindowCreate(){
		
	}

	public void postWindowClose(){
		
	}

	@Override
	public boolean preWindowShellClose() 
	{
		return false;
	}

}
