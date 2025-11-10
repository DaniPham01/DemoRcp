package editors;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

public class ParameterConfigurationsInput implements IEditorInput {

	public ParameterConfigurationsInput() {
	}

	@Override
	public Object getAdapter(Class adapter) {
		return null; 
	}

	@Override
	public boolean exists() {
		return false;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return null;
	}

	@Override
	public String getName() {
		return "Analysis Parameters";
	}

	@Override
	public IPersistableElement getPersistable() {
		return null;
	}

	@Override
	public String getToolTipText() {
		return "Analysis Parameters";
	}

}
