package com.GS.Perspective.WorkBench;

import com.GS.SWTBot.Helper.Utils.ContextMenuBot;
import com.GS.SWTBot.Helper.Utils.SWTBotCommonActionBot;
import com.GS.SWTBot.Helper.Utils.StudioBot;
import com.GS.Utility.EnvironmentValues;
import com.GS.WorkBench.Application.AppServerConnection;
import com.GS.WorkBench.Application.Engines;
import com.GS.WorkBench.Application.Queries;
import com.GS.WorkBench.Application.Resources;
import com.GS.WorkBench.Application.WorkFlow;
import com.GS.WorkBench.Application.Dialogs.RunWorkFlow;

/**
 * Class used to perform the Actions on the Configure Orchestrator view.
 * 
 * @author Pawan garia
 * 
 */
public class ConfigureOrchestratorView {

	private StudioBot studio = new StudioBot();

	private AppServerConnection appserver = new AppServerConnection();
	private String CONFIGURE_ORCHESTRATOR = "Configure Orchestrator";
	private String CONFIGURE_ORCHESTRATOR_EXPLORER = "Orchestrator Configuration Explorer";

	/**
	 * open the ConfigureOrchestratorPrespective Perspective
	 */
	public void openConfigureOrchestratorPrespective() {
		studio.ActivatePrespective(CONFIGURE_ORCHESTRATOR);
		studio.SetFouseOnView(CONFIGURE_ORCHESTRATOR_EXPLORER);
	}

	/**
	 * Create New Application server Connection from the Configure Orchestrator
	 * View
	 * 
	 * @throws Exception
	 */
	public void getConnection() throws Exception {

		appserver.getConnection(EnvironmentValues.getApplicationServerTYPE(),
				CONFIGURE_ORCHESTRATOR_EXPLORER);

	}

	/**
	 * Create New Application server Connection from the Configure Orchestrator
	 * Using the PRoperty File Provided by the User. View
	 * 
	 * @throws Exception
	 */
	public void getConnectionWithCustomPropertyFile(String PropertyFilePath)
			throws Exception {

		appserver.getConnection(EnvironmentValues.getApplicationServerTYPE(),
				CONFIGURE_ORCHESTRATOR_EXPLORER, PropertyFilePath);

	}

	public void deleteConnectionProfile() throws Exception {
		appserver.deleteConnectionProfile(EnvironmentValues
				.getApplicationServerTYPE(), CONFIGURE_ORCHESTRATOR_EXPLORER);
	}

	/**
	 * Get the Workflow class object.
	 */
	public WorkFlow getWorkFlow() {
		return new WorkFlow(CONFIGURE_ORCHESTRATOR_EXPLORER);
	}
    /**
     * get the Resources Class Object for Config Orchestrator.
     * @return
     */
	public Resources getResources() {
		return new Resources(CONFIGURE_ORCHESTRATOR_EXPLORER);
	}
	/**
	 * get the Queries Class Object for the Queries Tree item in the ConfigOrchestarator.
	 * @return
	 */
	public Queries getQueries() {
		return new Queries(CONFIGURE_ORCHESTRATOR_EXPLORER);
	}
	/**
	 * Disconnect Connection
	 * 
	 * @throws Exception
	 */
	public void disconnectConnection() throws Exception {
		appserver.disconnectConnectionProfile(EnvironmentValues
				.getApplicationServerTYPE(), CONFIGURE_ORCHESTRATOR_EXPLORER);
	}

	/**
	 * Get the context menu class object.
	 * 
	 * @return
	 */
	public ContextMenuBot getContextManuItem() {
		return new ContextMenuBot(CONFIGURE_ORCHESTRATOR_EXPLORER);
	}
	
	/**
	 * Get the SWTbot CommonAction  class object.
	 * 
	 * @return
	 */
	public SWTBotCommonActionBot getCommonActionSWTbot() {
		return new SWTBotCommonActionBot();
	}
	
	/**
	 * Get the Engines  class object for Config Orchestrator View Tree.
	 * 
	 * @return
	 */
	public Engines getEngines() {
		return new Engines(CONFIGURE_ORCHESTRATOR_EXPLORER);
	}
}
