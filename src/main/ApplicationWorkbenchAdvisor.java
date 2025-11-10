package main;

import org.eclipse.jface.preference.PreferenceManager;
import org.eclipse.ui.IWorkbenchPreferenceConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {

	public static final String PERSPECTIVE_ID = "CAR.perspective"; //$NON-NLS-1$


    public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {

    	return new ApplicationWorkbenchWindowAdvisor(configurer); 
        
    }

    
	public String getInitialWindowPerspectiveId() {
	
		PlatformUI.getPreferenceStore().setValue( IWorkbenchPreferenceConstants.SHOW_TRADITIONAL_STYLE_TABS, false);
		return PERSPECTIVE_ID;
		
		
	}

	
	public void postStartup() 
	{
	    PreferenceManager pm = PlatformUI.getWorkbench().getPreferenceManager( );
	    
//	    IPreferenceNode[] arr = pm.getRootSubNodes();
        
//	    for(IPreferenceNode pn:arr)
//	    {
//	        if(pn.getId().equals("org.eclipse.ui.preferencePages.Workbench"))
//	        {
//	        	IPreferenceNode[] arr1 = pn.getSubNodes();
//	        	for(IPreferenceNode pn1:arr1)
//	    	    {
//        			pn.remove(pn1.getId());
//	    	    }
//	        }
//	    }
	    
	    
	    pm.remove( "org.eclipse.help.ui.browsersPreferencePage" );
	    pm.remove("org.eclipse.ui.preferencePages.Workbench");
	    pm.remove("org.eclipse.m2e.core.preferences.Maven2PreferencePage");
	}
	
	public boolean preWindowShellClose(){
//		connectToServer();
		return true;
		

		}
	
}
