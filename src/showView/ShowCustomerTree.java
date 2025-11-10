package showView;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import common.Constant;
import views.CustomerTree;

public class ShowCustomerTree extends AbstractHandler {

    public static final String ID = "PHULIMEX.CustomerTree";
    private Constant constant = Constant.getInstance();

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        try {
            IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
            IWorkbenchPage page = window.getActivePage();
            IViewPart existingView = page.findView(constant.DH_ID);
            IViewPart newView = null;
            if (page.isPartVisible(page.findView(constant.DH_ID))) {
                page.hideView(page.findView(constant.DH_ID));
                newView = page.showView(constant.DH_ID);
            }
            
            if (existingView == newView) {
                CustomerTree myview = 
                    (CustomerTree) PlatformUI
                        .getWorkbench()
                        .getActiveWorkbenchWindow()
                        .getActivePage()
                        .findView(Constant.getInstance().DH_ID);

            }
        } catch (PartInitException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {}
        return null;
    }
}
