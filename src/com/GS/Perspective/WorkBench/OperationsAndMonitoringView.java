package com.GS.Perspective.WorkBench;

import com.GS.SWTBot.Helper.Utils.ContextMenuBot;
import com.GS.SWTBot.Helper.Utils.SWTBotCommonActionBot;
import com.GS.SWTBot.Helper.Utils.StudioBot;
import com.GS.Utility.EnvironmentValues;
import com.GS.WorkBench.Application.AppServerConnection;
import com.GS.WorkBench.Application.WorkFlow;
import com.GS.WorkBench.Application.Dialogs.RunWorkFlow;

/**
 * 
 * @author pawan garia
 * 
 */
public class OperationsAndMonitoringView {

	private StudioBot studio = new StudioBot();
	private AppServerConnection appserver = new AppServerConnection();
	private String OPERATIONS_AND_MONITORING = "Operations and Monitoring";
	private String OPERATIONS_AND_MONITORING_EXPLORER = "Operations and Monitoring Explorer";

	/**
	 * open the OperationsAndMonitoring Perspective
	 */
	public void openOperationsAndMonitoringPrespective() {
		studio.ActivatePrespective(OPERATIONS_AND_MONITORING);
		studio.SetFouseOnView(OPERATIONS_AND_MONITORING_EXPLORER);
	}

	/**
	 * Create New Application server Connection from the Operations And
	 * Monitoring View
	 * 
	 * @throws Exception
	 */
	public WorkFlow getConnection() throws Exception {

		// appserver.FindAppServerConnection("WEBLOGIC","Orchestrator Configuration Explorer");
		appserver.getConnection(EnvironmentValues.getApplicationServerTYPE(),
				OPERATIONS_AND_MONITORING_EXPLORER);
		return new WorkFlow(OPERATIONS_AND_MONITORING_EXPLORER);
	}

	/**
	 * Create New Application server Connection from the Operations And
	 * Monitoring. Using the PRoperty File Provided by the User. View
	 * 
	 * @throws Exception
	 */
	public WorkFlow getConnectionWithCustomPropertyFile(String PropertyFilePath)
			throws Exception {

		// appserver.FindAppServerConnection("WEBLOGIC","Orchestrator Configuration Explorer");
		appserver.getConnection(EnvironmentValues.getApplicationServerTYPE(),
				OPERATIONS_AND_MONITORING_EXPLORER, PropertyFilePath);
		return new WorkFlow(OPERATIONS_AND_MONITORING_EXPLORER);

	}

	/**
	 * Delete the Connection PRofile From the View.
	 * 
	 * @throws Exception
	 */
	public void deleteConnectionProfile() throws Exception {
		appserver
				.deleteConnectionProfile(EnvironmentValues
						.getApplicationServerTYPE(),
						OPERATIONS_AND_MONITORING_EXPLORER);
	}

	/**
	 * Get Workflow Class object.
	 * 
	 * @return
	 */
	public WorkFlow getWorkFlow() {
		return new WorkFlow(OPERATIONS_AND_MONITORING_EXPLORER);
	}

	/**
	 * get context menu class Object.
	 * 
	 * @return
	 */
	public ContextMenuBot getContextManuItem() {
		return new ContextMenuBot(OPERATIONS_AND_MONITORING_EXPLORER);
	}
	/**
	 * Get the SWTbot CommonAction  class object.
	 * 
	 * @return
	 */
	public SWTBotCommonActionBot getCommonActionSWTbot() {
		return new SWTBotCommonActionBot();
	}
}
