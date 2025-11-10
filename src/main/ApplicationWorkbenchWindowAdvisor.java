package main;
/*sr no.  , reqId ,    Description ,      Author ,updatedDate

#2    , P3R119 , Add PT button, shital ,2-3-2022
#3    ,  P3R122,  auto manual ARM , Anil , 15-5-2022
#1    ,  P3R32-P3R31,  Line Wrap , Anil , 15-6-2022
#s    ,  P3R173,  Save and Create Perspective , Satyam , 01-08-2022
#S1   , HLTC267, licence pop up does not appear, Satyam, 20-12-2022
#Y2   , HLTC158, Dialoig in center , 16-01-2023
#jp1  , to handle stable scenario for T,P,TP and Wrap,Unwrap, Jayesh, 10-3-23
 */
import java.awt.Dimension;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.NotEnabledException;
import org.eclipse.core.commands.NotHandledException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IPerspectiveListener;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWindowListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPreferenceConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.internal.registry.EditorRegistry;

import common.Constant;
import editors.HWDescription;
import handler.AnalysisResultHandler;
import handler.CoverSheetHandler;
import handler.FITCharacteristicsHandler;
import handler.FaultCharacterisationsHandler;
import handler.HardwareAnalysisHandler;
import handler.HardwareDescriptionHandler;
import handler.OverviewHandler;
import handler.ParameterConfigurationHandler;
import handler.SafetyMechanismsHandler;
import handler.VariantsHandler;
import views.AuditLogs;
import views.DocumentView;
import views.ErrorLogs;
import views.HardwareElement;

public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

	private Constant constant = Constant.getInstance();
	
	public static String viewID = "";
	public int count = 0;
	public ApplicationWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
		super(configurer);
	}

	public ActionBarAdvisor createActionBarAdvisor(IActionBarConfigurer configurer) {
		return new ApplicationActionBarAdvisor(configurer);
	}

	public static IWorkbenchWindowConfigurer configurer = null;
	// P3R21 end

	public void preWindowOpen() 
	{
		try
		{
			IWorkbenchWindowConfigurer configurer = getWindowConfigurer();

			PlatformUI.getPreferenceStore().setValue(IWorkbenchPreferenceConstants.SHOW_INTRO, true);


			Dimension dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
			configurer.setInitialSize(new Point((int)dim.getWidth(), (int)dim.getHeight()));

			configurer.setShowStatusLine(true);
				configurer.setShowPerspectiveBar(false);//#s
			configurer.setShowCoolBar(true);
			configurer.setShowProgressIndicator(true);


			ICommandService service = (ICommandService)PlatformUI.getWorkbench().getService(ICommandService.class);


		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	} 
	 
	@Override
	public void postWindowOpen() {
		final IWorkbenchPage activePage = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage();
		if (activePage.findView(constant.DOC_ID) != null) {}else{}
		
		
		getWindowConfigurer().getWindow().getWorkbench().addWindowListener(new IWindowListener() {
			
			@Override
			public void windowOpened(IWorkbenchWindow window) {
				HardwareElement myview = (HardwareElement) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(constant.DH_ID);
			}
			
			@Override
			public void windowDeactivated(IWorkbenchWindow window) {}
			
			@Override
			public void windowClosed(IWorkbenchWindow window) {
				}
			
			@Override
			public void windowActivated(IWorkbenchWindow window) {
				IHandlerService handlerService = (IHandlerService) PlatformUI
						.getWorkbench().getActiveWorkbenchWindow()
						.getService(IHandlerService.class);
				
				try {
					handlerService.executeCommand(
							showView.HardwareElement.ID,
							new Event());
				} catch (ExecutionException | NotDefinedException
						| NotEnabledException | NotHandledException e) {
					e.printStackTrace();
				}
				
				 HardwareElement myview = (HardwareElement) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(constant.DH_ID);
			}
			
			});
	}
	
	public void viewCheck(IWorkbenchPage page,
				IPerspectiveDescriptor perspective){
		try{

		boolean test = page.closeAllEditors(false);
		page.closeEditor((IEditorPart) new HWDescription(), true);
		if (viewID.isEmpty()) {
			
			IViewReference[] viewReferences = page.getViewReferences();
			
			for (IViewReference iViewReference : viewReferences) {
				String partID = "";
				
				try {
					partID = iViewReference.getPart(false).toString();
				}
				 catch (NullPointerException e) {
//						 
//						e.printStackTrace();
					}
				if (partID.contains(constant.HWPARTS_ID)) {
					viewID = constant.SM_ID;
					break;
				}
				else if (partID.contains(constant.ELF_ID)) {
					viewID = constant.HD_ID;
					break;
				}
				else if (partID.contains("FaultCharacterisation_FM")) {
					viewID = constant.FD_ID;
					break;
				}
				else if (partID.contains(constant.FC_ID)) {
					viewID = constant.FI_ID;
					break;
					
				}
				else if (partID.contains(constant.VN_ID)) {
					viewID = constant.VA_ID;
					break;
				}
			}
		}

		if (viewID.equalsIgnoreCase(constant.HD_ID) || viewID.equals(constant.HD_TITLE) || viewID.equals(constant.ELF_TITLE)) {

			Command command = ((ICommandService) page.getActivePart().getSite()
					.getService(ICommandService.class))
					.getCommand(HardwareDescriptionHandler.ID);
			final Event trigger = new Event();
			ExecutionEvent executionEvent = ((IHandlerService) page.getActivePart().getSite()
					.getService(IHandlerService.class))
					.createExecutionEvent(command, trigger);
			try {
				command.executeWithChecks(executionEvent);
			}
			catch (ExecutionException | NotHandledException | NotDefinedException | NotEnabledException e) {
				// 
//				e.printStackTrace();
			}
			if (viewID.equalsIgnoreCase(constant.HD_ID)) {
				try {
					page.showView(constant.ELF_ID);
				} catch (PartInitException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else if (viewID.equalsIgnoreCase(constant.SM_ID)|| viewID.equals(constant.SM_TITLE) || viewID.equals(constant.HWPARTS_TITLE)) {

			Command command = ((ICommandService) page.getActivePart().getSite()
					.getService(ICommandService.class))
					.getCommand(SafetyMechanismsHandler.ID);
			final Event trigger = new Event();
			ExecutionEvent executionEvent = ((IHandlerService) page.getActivePart().getSite()
					.getService(IHandlerService.class))
					.createExecutionEvent(command, trigger);
			try {
				command.executeWithChecks(executionEvent);
			}
			catch (ExecutionException | NotHandledException | NotDefinedException | NotEnabledException e) {
				// 
//				e.printStackTrace();
			}
			if (viewID.equalsIgnoreCase(constant.SM_ID)) {
				try {
					page.showView(constant.HWPARTS_ID);
				} catch (PartInitException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else if (viewID.equalsIgnoreCase(constant.FS_ID) || viewID.equalsIgnoreCase(constant.FS_TITLE)) {

			Command command = ((ICommandService) page.getActivePart().getSite()
					.getService(ICommandService.class))
					.getCommand(FITCharacteristicsHandler.ID);
			final Event trigger = new Event();
			ExecutionEvent executionEvent = ((IHandlerService) page.getActivePart().getSite()
					.getService(IHandlerService.class))
					.createExecutionEvent(command, trigger);
			try {
				command.executeWithChecks(executionEvent);
			}
			catch (ExecutionException | NotHandledException | NotDefinedException | NotEnabledException e) {
				// 
//				e.printStackTrace();
			}
		}
		else if (viewID.equalsIgnoreCase(constant.FD_ID)|| viewID.equals(constant.FD_TITLE) || viewID.equalsIgnoreCase(constant.FM_TITLE)) {

			Command command = ((ICommandService) page.getActivePart().getSite()
					.getService(ICommandService.class))
					.getCommand(FaultCharacterisationsHandler.ID);
			final Event trigger = new Event();
			ExecutionEvent executionEvent = ((IHandlerService) page.getActivePart().getSite()
					.getService(IHandlerService.class))
					.createExecutionEvent(command, trigger);
			try {
				command.executeWithChecks(executionEvent);
			}
			catch (ExecutionException | NotHandledException | NotDefinedException | NotEnabledException e) {
				// \
//				e.printStackTrace();
			}
			if (viewID.equalsIgnoreCase(constant.FD_ID)) {
				try {
					page.showView(constant.FM_ID);
				} catch (PartInitException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else if (viewID.equalsIgnoreCase(constant.FI_ID) || viewID.equals(constant.FI_TITLE) || viewID.equalsIgnoreCase(constant.FC_TITLE)) {

			Command command = ((ICommandService) page.getActivePart().getSite()
					.getService(ICommandService.class))
					.getCommand(HardwareAnalysisHandler.ID);
			final Event trigger = new Event();
			ExecutionEvent executionEvent = ((IHandlerService) page.getActivePart().getSite()
					.getService(IHandlerService.class))
					.createExecutionEvent(command, trigger);
			try {
				command.executeWithChecks(executionEvent);
			}
			catch (ExecutionException | NotHandledException | NotDefinedException | NotEnabledException e) {
				// 
//				e.printStackTrace();
			}
			if (viewID.equalsIgnoreCase(constant.FI_ID)) {
				try {
					page.showView(constant.FC_ID);
				} catch (PartInitException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		else if (viewID.equalsIgnoreCase(constant.AR_ID)|| viewID.equals(constant.AR_VIEW_ID)) {

			Command command = ((ICommandService) page.getActivePart().getSite()
					.getService(ICommandService.class))
					.getCommand(AnalysisResultHandler.ID);
			final Event trigger = new Event();
			ExecutionEvent executionEvent = ((IHandlerService) page.getActivePart().getSite()
					.getService(IHandlerService.class))
					.createExecutionEvent(command, trigger);
			try {
				command.executeWithChecks(executionEvent);
			}
			catch (ExecutionException | NotHandledException | NotDefinedException | NotEnabledException e) {
				// 
//				e.printStackTrace();
			}
			if (viewID.equalsIgnoreCase(constant.AR_ID)) {
				try {
					page.showView(constant.AR_VIEW_ID);
				} catch (PartInitException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else if (viewID.equalsIgnoreCase(constant.CS_ID)) {

			Command command = ((ICommandService) page.getActivePart().getSite()
					.getService(ICommandService.class))
					.getCommand(CoverSheetHandler.ID);
			final Event trigger = new Event();
			ExecutionEvent executionEvent = ((IHandlerService) page.getActivePart().getSite()
					.getService(IHandlerService.class))
					.createExecutionEvent(command, trigger);
			
			try {
				command.executeWithChecks(executionEvent);
			}
			catch (ExecutionException | NotHandledException | NotDefinedException | NotEnabledException e) {
				// 
				e.printStackTrace();
			}
		}
		else if (viewID.equalsIgnoreCase(constant.PA_ID)) {

			Command command = ((ICommandService) page.getActivePart().getSite()
					.getService(ICommandService.class))
					.getCommand(ParameterConfigurationHandler.ID);
			final Event trigger = new Event();
			ExecutionEvent executionEvent = ((IHandlerService) page.getActivePart().getSite()
					.getService(IHandlerService.class))
					.createExecutionEvent(command, trigger);
			try {
				command.executeWithChecks(executionEvent);
			}
			catch (ExecutionException | NotHandledException | NotDefinedException | NotEnabledException e) {
				// 
				e.printStackTrace();
			}
		}
		else if (viewID.equalsIgnoreCase(constant.VA_ID)) {

			Command command = ((ICommandService) page.getActivePart().getSite()
					.getService(ICommandService.class))
					.getCommand(VariantsHandler.ID);
			final Event trigger = new Event();
			ExecutionEvent executionEvent = ((IHandlerService) page.getActivePart().getSite()
					.getService(IHandlerService.class))
					.createExecutionEvent(command, trigger);
			try {
				command.executeWithChecks(executionEvent);
			}
			catch (ExecutionException | NotHandledException | NotDefinedException | NotEnabledException e) {
				// 
				e.printStackTrace();
			}
		}
		else if (viewID.equalsIgnoreCase(constant.OV_ID)) {

			Command command = ((ICommandService) page.getActivePart().getSite()
					.getService(ICommandService.class))
					.getCommand(OverviewHandler.ID);
			final Event trigger = new Event();
			ExecutionEvent executionEvent = ((IHandlerService) page.getActivePart().getSite()
					.getService(IHandlerService.class))
					.createExecutionEvent(command, trigger);
			try {
				command.executeWithChecks(executionEvent);
			}
			catch (ExecutionException | NotHandledException | NotDefinedException | NotEnabledException e) {
				// 
				e.printStackTrace();
			}
		}

	}catch (NullPointerException e) {
				// 
//				e.printStackTrace();
			}
	}
		
	public void perspectiveListener() {

		PlatformUI.getWorkbench().getActiveWorkbenchWindow().addPerspectiveListener(new IPerspectiveListener() {
		

		@Override
		public void perspectiveChanged(IWorkbenchPage page,
				IPerspectiveDescriptor perspective, String changeId) {

			if (changeId == "resetComplete") {
				viewID = "";
				viewCheck(page, perspective);
				page.closeAllEditors(false);
				if (count == 0) {
					page.closeAllEditors(true);
					//					System.out.println("Change " + changeId + " " + page.getActiveEditor() + " " + Constant.SAVEID);
				}
			}else if (changeId == "reset") {
				viewID = "r";
			}
		}

		
		@Override
		public void perspectiveActivated(IWorkbenchPage page,
				IPerspectiveDescriptor perspective) {
			viewCheck(page, perspective);
			page.closeAllEditors(false);
			page.resetPerspective();
			

			if (page
						.findView(constant.CH_ID) != null) {
				
			}
			else {
				try {
					page.showView(constant.CH_ID);
				
				AuditLogs view = (AuditLogs) page
						.findView(constant.CH_ID);
				view.setFocus();
				} catch (PartInitException e) {}
			}
			ErrorLogs errordata = null;
			if (page
						.findView(constant.EL_ID) != null) {
				errordata = (ErrorLogs) page
						.findView(constant.EL_ID);
			}else {
				try {
					page.showView(constant.EL_ID);
				} catch (PartInitException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (page
						.findView(constant.DOC_ID) != null) {
				DocumentView docview = (DocumentView) page
						.findView(constant.DOC_ID);
			}else {
				try {
					page.showView(constant.DOC_ID);
				} catch (PartInitException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				DocumentView docview = (DocumentView) page
						.findView(constant.DOC_ID);
			}
		
		}
		});
	}
	
	public void postWindowCreate(){

		final IWorkbenchWindow window = getWindowConfigurer().getWindow();
		window.getShell().setMaximized(true);

		ErrorLogs myview = (ErrorLogs) window.getActivePage().findView(constant.EL_ID);

		perspectiveListener();
		IWorkbenchPage activePage = window.getActivePage();
		IEditorReference[] editorsreferences = activePage.getEditorReferences();
		for (IEditorReference editorsreference : editorsreferences)
		{
			if (EditorRegistry.EMPTY_EDITOR_ID.equals(editorsreference.getId()))
			{
				activePage.closeEditors(new IEditorReference[] { editorsreference }, false);
			}
		}

		count = 1;
	}

	public void postWindowClose(){
		
	}


	@Override
	public boolean preWindowShellClose() 
	{
		return true;
	}
}
