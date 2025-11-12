package handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchPage; 
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import common.Constant;
import editors.ParameterConfigurationsInput;


public class ParameterConfigurationHandler extends AbstractHandler   {
	 public static String ID = "PHULIMEX Tool.ParameterConfigurationcommand";
	 private Constant constant = Constant.getInstance();
	@Override
	public Object execute(ExecutionEvent arg0) throws ExecutionException {

		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		IWorkbenchPage page = window.getActivePage();
		ParameterConfigurationsInput input = new ParameterConfigurationsInput();

		try {
			page.closeAllEditors(true);
			page.openEditor(input, constant.PA_ID);
			page.hideView(page.findView(constant.FM_ID));
			page.hideView(page.findView(constant.ELF_ID));
			page.hideView(page.findView(constant.HWPARTS_ID));
			page.hideView(page.findView(constant.FC_ID));
			page.hideView(page.findView(constant.AR_VIEW_ID));
			page.hideView(page.findView(constant.VN_ID));
			page.hideView(page.findView(constant.LICENCE_VIEW_ID));
			
		} catch (PartInitException e) {
			e.printStackTrace();
		}
		return null;
	}
}
