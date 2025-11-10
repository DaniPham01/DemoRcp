package main;
import org.eclipse.core.runtime.Platform;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;


/**
 * This class controls all aspects of the application's execution
 */
public class Application implements IApplication {

	public static Display display = PlatformUI.createDisplay();
	public static String  pathLibrary;//#4
//	private Thread serverThread = null;
//	private ServerSocket server = null;
	/* (non-Javadoc)
	 * @see org.eclipse.equinox.app.IApplication#start(org.eclipse.equinox.app.IApplicationContext)
	 */
	public Object start(IApplicationContext context) throws Exception {
		

		
		if (!ApplicationInstanceManager.registerInstance()) {
            MessageDialog.openInformation(new Shell(), "Information","CAR Tool cannot be launched as one instance of the CAR Tool is already running. \nKindly click OK to exit.");
            return IApplication.EXIT_OK;
		}
		
		try 
		{
			//[#4
			
			for(String a: Platform.getCommandLineArgs() ){
				if (a.endsWith("lib")) {
					pathLibrary = a;
				}
			}

			PlatformUI.createAndRunWorkbench(Application.display, new ApplicationWorkbenchAdvisor());

		}
		catch(Exception e){
			
		}
		finally {
			display.dispose();
		}		
		
		return IApplication.EXIT_OK;
		
	}


	public void stop() {
		if (!PlatformUI.isWorkbenchRunning()){
			return;
		}

		final IWorkbench workbench = PlatformUI.getWorkbench();
		final Display display = workbench.getDisplay();

		display.syncExec(new Runnable() {
			public void run() {
				if (!display.isDisposed()){
					workbench.close();
				}
			}
		});
	}
}
