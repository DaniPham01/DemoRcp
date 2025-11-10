package main;

import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.jface.preference.PreferenceManager;
import org.eclipse.swt.widgets.Shell;

public class Preference extends PreferenceDialog
{
    public Preference(Shell parentShell, PreferenceManager manager) {
        super(parentShell, manager);
    }

    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText(" Configurations"); 
    }
}