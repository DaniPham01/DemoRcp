package main;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;

public class Product extends Dialog {

	protected Object result;
	protected Shell shell;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public Product(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), getStyle());
		shell.setSize(450, 300);
		shell.setText(getText());
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(10, 127, 83, 23);
		lblNewLabel.setText("Product Code");
		
		Combo combo = new Combo(shell, SWT.READ_ONLY);
		combo.setItems(new String[] {"", "Product Code: 0", "Product Code: 1", "Product Code: 2", "Product Code: 3", "Product Code: 4", "Product Code: 5", "Product Code: 6", "Product Code: 7", "Product Code: 8", "Product Code: 9"});
		combo.setBounds(113, 127, 132, 23);
		combo.select(0);

	}

}
