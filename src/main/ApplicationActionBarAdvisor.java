package main;
/*sr no.  , reqId ,    Description ,      Author ,updatedDate

#1    , GIPPHULIMEXTSRC-75, Get system UUID, Satyam,	13-4-2022
#4	  ,	P3R207, Opening library files through PHULIMEX ,Satyam, 21-06-2022
#5    , FTTC48, Licence Handler is accessible in Reviewer,Yash,11-12-2022
#J9   ,HLTC275,configuration disable in secondary window,Jayesh,05-03-2023
#Y4   ,Retrive product code disable in secondary window ,Yash,07-03-2023
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.NotEnabledException;
import org.eclipse.core.commands.NotHandledException;
import org.eclipse.core.commands.State;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.StatusLineContributionItem;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import common.Constant;


public class ApplicationActionBarAdvisor extends ActionBarAdvisor
{

	private IWorkbenchAction resetPerspectiveAction;
	private StatusLineContributionItem statusItem;

	public Action newProjectAction;
	public Action openProjectAction;
	public Action renameProjectAction;
	public Action saveasProjectAction;
	public Action deleteProjectAction;
	public Action openLibraryAction;
	public Action uploadLibraryAction;
	public Action updateLibraryAction;
	public Action exortLibraryAction;
	public Action importDataAction;
	public Action exportdataAction;
	public Action exportBlankTemplateAction;
	public Action exportactivepartonlyAction;
	public Action configurationAction;
	public Action exitAction;
	public Action changeusercreditial;

	public Action exportDFASubAction;
	
	public Action exportSystematicFaultAnalysis;

	public Action exportExcelSubAction;
	public Action exportHTMLSubAction;
	public Action exportCSVSubAction;
	public Action exportTSVSubAction;
	public IWorkbenchAction aboutAction;
	public Action exportPermissionEditorAction;
	public Action helpAction;
//	public Action overviewEditorAction;
	public Action userlistAction;
	public Action getUUID;
	public Action productcodeAction; 
	public Action retriveProductCode, retriveLibraryVersion;
	public Action updateBackupFile;
	
	// Convert library to excel file
	public Action convertLibrary2Excel;
	public Action convertExcel2Library;
	public Action restartTool;
	
	public IWorkbenchAction showHelpAction; // NEW
	IActionBarConfigurer configurer;
	private StatusLineContributionItem invalidmessage;
	private Constant constant = Constant.getInstance();
	
	@Override
	protected void fillStatusLine(final IStatusLineManager statusLine) {

		invalidmessage = new StatusLineContributionItem("");
		statusLine.add(invalidmessage);

		statusItem = new StatusLineContributionItem("LoggedInStatus");
		statusItem.setText("Logged in as :");
		statusLine.add(statusItem);
	}

	protected StatusLineManager createStatusLineManager() {
		StatusLineManager statusLineManager = new StatusLineManager();
		statusLineManager.setMessage(null, "YOUR_MESSAGE");
		return statusLineManager;
	}

	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) 
	{
		super(configurer);
	}

	//#4
	public void openLib() {
		
	}
	//#4
	
	protected void makeActions(final IWorkbenchWindow window)
	{
		
	}

	protected void readAndDuplicateProject() {
		
	}

	protected void exitPHULIMEXTool() {
		
	}

	protected void fillMenuBar(IMenuManager menuBar)
	{
		
	}

	protected void fillCoolBar(ICoolBarManager coolBar)
	{

	}

	public void getActionBarDisable()
	{
		
	}
	


}
