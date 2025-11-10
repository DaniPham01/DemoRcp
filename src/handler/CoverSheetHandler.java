package handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import common.Constant;
import editors.CoverSheetInput;

public class CoverSheetHandler extends AbstractHandler {
	  public static String ID = "CAR Tool.CoverSheetcommand";
		 private Constant constant = Constant.getInstance();

	@Override
	public Object execute(ExecutionEvent arg0) throws ExecutionException {
		
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		IWorkbenchPage page = window.getActivePage();
		CoverSheetInput input = new CoverSheetInput();
		try {
			page.closeAllEditors(true);
			page.openEditor(input, constant.CS_ID);
			page.hideView(page.findView(constant.FM_ID));
			page.hideView(page.findView(constant.ELF_ID));
			page.hideView(page.findView(constant.HWPARTS_ID));
			page.hideView(page.findView(constant.FC_ID));
			page.hideView(page.findView(constant.AR_VIEW_ID));
			page.hideView(page.findView(constant.SAVED_FILTER_ID));
			page.hideView(page.findView(constant.VN_ID));
			page.hideView(page.findView(constant.LICENCE_VIEW_ID));
			
		} catch (PartInitException e) {
			e.printStackTrace();
		}
		return null;
	}
}
