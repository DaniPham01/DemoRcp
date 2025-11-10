package handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;


import common.Constant;
import editors.VariantsInput;


public class VariantsHandler extends AbstractHandler  {
	  public static String ID = "CAR Tool.Variants";
	  private Constant constant = Constant.getInstance();

	@Override
	public Object execute(ExecutionEvent arg0) throws ExecutionException{
		
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		IWorkbenchPage page = window.getActivePage();
		VariantsInput input = new VariantsInput();
		try {
			page.closeAllEditors(true);
			page.openEditor(input, constant.VA_ID);
			try {
				page.showView(constant.VN_ID);
				
			} catch (NullPointerException e) {
				
			}//#Multiple
			page.hideView(page.findView(constant.FM_ID));
			page.hideView(page.findView(constant.ELF_ID));
			page.hideView(page.findView(constant.HWPARTS_ID));
			page.hideView(page.findView(constant.FC_ID));
			page.hideView(page.findView(constant.AR_VIEW_ID));
			page.hideView(page.findView(constant.LICENCE_VIEW_ID));
			
			IEditorReference[] editorsreferences = page.getEditorReferences();
			for(IEditorReference editorsreference : editorsreferences)
			{
				page.activate(editorsreference.getEditor(true));
			}
		} catch (PartInitException e) {
			e.printStackTrace();
		}
		return null;
	}

	

}
