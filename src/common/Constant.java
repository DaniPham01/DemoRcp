package common;

public class Constant {
	private static Constant single_instance = null;

	
	public static Constant getInstance() {
		if (single_instance == null) {
			single_instance = new Constant();
		}

		return single_instance;
	}
	
	/*=============  MODULE ID  ===============*/
	public final String PA_ID = "editor.ParameterConfiguration";
	public final String FS_ID = "editor.FitCharacteristic";
	public final String FD_ID = "editor.FaultCharacterisations";
	public final String FM_ID = "view.FaultCharacterisation_FM";
	public final String HD_ID = "editors.HardwareDescription";
	public final String ELF_ID = "views.HardwareElementFuctionality";
	public final String SM_ID = "com.editor.SafetyMechanisms";
	public final String HWPARTS_ID = "views.HardwareParts";
	public final String FI_ID = "editor.HardwareAnalysis";
	public final String FC_ID = "view.faultcoverage";
	public final String VA_ID = "ree.editors.Variants";
	public final String VN_ID = "ree.views.Variant_TypeView";
	public final String DH_ID = "view.HardwareElements";
	public final String AR_ID = "CAR Tool.Analysis_result";
	public final String EL_ID = "view.ErrorLogs";
	public final String CH_ID = "view.AuditLogs";
	public final String AR_VIEW_ID = "com.view.lambdacontri";
	public final String CS_ID = "com.editor.CoverSheet";
	public final String DOC_ID = "ree.views.DocumentView";
	public final String OV_ID = "CAR Tool.overview";
	public final String SAVED_FILTER_ID = "view.SaveSearchView";
	public final String ADMIN_ACCESS_ID = "ree.AdminAccess";
	public final String METRIC_HORIZONTAL_ID = "CAR Tool.AnalysisResult_metricschart_Horizantal";
	public final String PMHF_HORIZONTAL_CHART_ID = "CAR Tool.barcharts_Horizantal";
	public final String PMHF_VERTICAL_CHART_ID = "CAR Tool.barcharts";
	public final String LAMBDA_VERTICAL_CHART_ID = "CAR Tool.lambdachart";
	public final String LAMBDA_HORIZONTAL_CHART_ID = "CAR Tool.lambdachart_Horizantal";
	public final String METRIC_VERTICAL_CHART_ID = "CAR Tool.AnalysisResult_metricschart";
	public final String LICENCE_VIEW_ID = "CAR Tool.UsersInformationView";
	
	
	/*=============  MODULE TITLE  ===============*/
	public final String AR_TITLE = "Analysis Results";
	public final String ARN_TITLE = "Numerical Results";
	public final String PA_TITLE = "Analysis Parameters";
	public final String FS_TITLE = "FIT Characteristics";
	public final String FD_TITLE = "Fault Characterisations";
	public final String FM_TITLE = "FM List";
	public final String HD_TITLE = "HW Description";
	public final String ELF_TITLE = "Hardware Element Functionality";
	public final String SM_TITLE = "Safety Mechanisms";
	public final String HWPARTS_TITLE = "Hardware Parts";
	public final String FI_TITLE = "HW Analysis Fault Impact";
	public final String FC_TITLE = "HW Analysis Fault Coverage";
	public final String VA_TITLE = "Variants";
	public final String VN_TITLE = "Element List";
	public final String DH_TITLE = "Design Hierarchy";
	public final String OV_TITLE = "Overview";
	public final String CH_TITLE = "Change History";
	public final String EL_TITLE = "Error Logs";
	public final String CS_TITLE = "Coversheet";
	public final String DOC_TITLE = "Documents";
	public final String SAVED_FILTER_TITLE = "Saved Filters";
	public final String COMPARE_VARIANT_TITLE = "Compare Variants"; // #2
	public final String PA_FIXED_FIELD_TITLE = "Fixed Fields";
	public final String SG_TITLE = "Safety Goal";

}
