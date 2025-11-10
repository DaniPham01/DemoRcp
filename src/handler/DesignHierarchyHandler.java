package handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import common.Constant;

public class DesignHierarchyHandler extends AbstractHandler {
	public static final String ID = "CAR Tool.DesignHierarchy";
	private Constant constant = Constant.getInstance();

	@Override
	public Object execute(ExecutionEvent arg0) throws ExecutionException {
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		IWorkbenchPage page = window.getActivePage();
		try { 
			page.hideView(page.findView(constant.DH_ID));
			 page.showView(constant.DH_ID);
		} catch (PartInitException e) {
			e.printStackTrace();
		}
		return null;
	}

}
