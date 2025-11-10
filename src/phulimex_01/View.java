package phulimex_01;

import java.util.*;

import jakarta.inject.Inject;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.part.ViewPart;

public class View extends ViewPart {
	public static final String ID = "Phulimex_01.view";
	public Tree tree;

	@Inject IWorkbench workbench;
	
	private TableViewer viewer;
	
	private class StringLabelProvider extends ColumnLabelProvider {
		
		// getText method is used from super class ColumnLabelProvider

		@Override
		public Image getImage(Object obj) {
			return workbench.getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT);
		}

	}

	@Override
	public void createPartControl(Composite parent) {

		
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
        

	
	}


	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}
	
	private List<String> createInitialDataModel() {
		return Arrays.asList("One", "Two", "Three");
	}
}