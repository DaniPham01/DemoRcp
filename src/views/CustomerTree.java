package views;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.part.ViewPart;


public class CustomerTree extends ViewPart implements Listener{
	public Tree tree;

	public CustomerTree() {
		
	}

	@Override
	public void createPartControl(final Composite parent) {
		try {
			
			parent.addDisposeListener(new DisposeListener() {

				@Override
				public void widgetDisposed(DisposeEvent e) {
					
				}
			});


			tree = new Tree(parent, SWT.CHECK | SWT.FULL_SELECTION);
			tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
			
	        for (int i = 1; i <= 10; i++) {
	            TreeItem item = new TreeItem(tree, SWT.NONE);
	            item.setText("Tree Item " + i);

	            // Optional: add child items
	            for (int j = 1; j <= 3; j++) {
	                TreeItem subItem = new TreeItem(item, SWT.NONE);
	                subItem.setText("Sub Item " + i + "." + j);
	            }
	        }
	        
	        for (TreeItem item : tree.getItems()) {
	            item.setExpanded(true);
	        }
	        

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public void checkItems(TreeItem item, boolean checked) {}

	public void checkPath(TreeItem item, boolean checked, boolean grayed) {}

	@Override
	public void setFocus() {

		if (tree != null)
			tree.setFocus();
	}

	@Override
	public void handleEvent(Event arg0) {
		// TODO Auto-generated method stub
		
	}


}
