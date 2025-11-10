package editors;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

public class SafetyMechanismsInput  implements IEditorInput{

	@Override
	public Object getAdapter(Class adapter) {
		return null;
	}

	@Override
	public String getToolTipText() {
		return "Safety Mechanisms";
	}

	@Override
	public IPersistableElement getPersistable() {
		return null;
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return null;
	}

	@Override
	public boolean exists() {
		return false;
	}

}
