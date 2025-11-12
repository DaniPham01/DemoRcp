package handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent; 
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.swt.widgets.Display;


import common.Constant;
import editors.HWDescriptionInput;
import views.SaveSearchView;


public class HardwareDescriptionHandler extends AbstractHandler  {
	
	public static String ID = "PHULIMEX Tool.HWDescriptioncommand";
	private Constant constant = Constant.getInstance();

	@Override
	public Object execute(ExecutionEvent arg0) throws ExecutionException {
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		IWorkbenchPage page = window.getActivePage();
		openHdm(page);
		openEfm(page);	
		refreshOtherEditors(page);
		return null;
	}

	private void openHdm(final IWorkbenchPage page) {

		Display.getDefault().syncExec(new Runnable() {
		    @Override
		    public void run() {
				HWDescriptionInput input = new HWDescriptionInput();
				page.closeAllEditors(true);
				try {
					page.openEditor(input, constant.HD_ID);
				} catch (PartInitException e) {
					e.printStackTrace();
				}	
		    }
		});

	
	}

	private void openEfm(final IWorkbenchPage page) {
		Display.getDefault().syncExec(new Runnable() {
		    @Override
		    public void run() {
		    	try {
					page.showView(constant.ELF_ID);
					
				} catch (NullPointerException e) {
						
				} catch (PartInitException e) {
					e.printStackTrace();
				}
		    }
		});

	}

	private void refreshOtherEditors(final IWorkbenchPage page) {
		Display.getDefault().asyncExec(new Runnable() {
		    @Override
		    public void run() {
		        page.hideView(page.findView(constant.FM_ID));
		        page.hideView(page.findView(constant.HWPARTS_ID));
		        page.hideView(page.findView(constant.FC_ID));
		        page.hideView(page.findView(constant.AR_VIEW_ID));
		        page.hideView(page.findView(constant.VN_ID));
		        page.hideView(page.findView(constant.LICENCE_VIEW_ID));

		        IEditorReference[] editorsreferences = page.getEditorReferences();
		        for (IEditorReference editorsreference : editorsreferences) {
		            page.activate(editorsreference.getEditor(true));
		        }

		        SaveSearchView myview = (SaveSearchView) PlatformUI.getWorkbench()
		                .getActiveWorkbenchWindow()
		                .getActivePage()
		                .findView(constant.SAVED_FILTER_ID);
		        if (myview != null) {
		            
		        }
		    }
		});

	}


	

}
