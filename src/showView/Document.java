package showView;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import common.Constant;

public class Document extends AbstractHandler{
	public static String ID = "CAR Tool.DocumentViewOpenCommand";
	private Constant constant = Constant.getInstance();
	@Override
	public Object execute(ExecutionEvent arg0) throws ExecutionException {

		try 
		{
			IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			IWorkbenchPage page = window.getActivePage();
			page.hideView(page.findView(constant.DOC_ID));
			page.showView(constant.DOC_ID);
		} 
		catch (PartInitException e) 
		{
			e.printStackTrace();
		}
		return null;
	}

}
