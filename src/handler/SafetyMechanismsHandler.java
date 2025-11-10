
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
import editors.SafetyMechanismsInput;
import views.SaveSearchView;

public class SafetyMechanismsHandler extends AbstractHandler {
	public final static String ID = "CAR Tool.SafetyMechanismscommand";
	private Constant constant = Constant.getInstance();

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		IWorkbenchPage page = window.getActivePage();
		SafetyMechanismsInput input = new SafetyMechanismsInput();
		try {
			page.closeAllEditors(true);
			page.openEditor(input, constant.SM_ID);
//#Multiple
			try {
				page.showView(constant.HWPARTS_ID);
				
			} catch (NullPointerException e) {
				
			}//#Multiple
			page.hideView(page.findView(constant.ELF_ID));
			page.hideView(page.findView(constant.FM_ID));
			page.hideView(page.findView(constant.FC_ID));
			page.hideView(page.findView(constant.AR_VIEW_ID));
			page.hideView(page.findView(constant.VN_ID));
			page.hideView(page.findView(constant.LICENCE_VIEW_ID));
			
			SaveSearchView myview = (SaveSearchView) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(constant.SAVED_FILTER_ID);
			
				  
				
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
