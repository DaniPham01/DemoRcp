package main;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "PHULIMEX"; //$NON-NLS-1$
	
	// The shared instance
	private static Activator plugin;

	public Activator() { 
	}

	public void start(BundleContext context){
		try {
			super.start(context);
			plugin = this;
		} catch (Exception e) {
			e.printStackTrace();
		}


	}


	public void stop(BundleContext context) {

		try 
		{
			plugin = null;
			super.stop(context);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	public static Activator getDefault() {
		return plugin;
	}


	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}

}
