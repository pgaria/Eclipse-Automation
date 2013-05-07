package com.GS.SWTBot.Helper.Utils;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;

import com.GS.WorkBench.Application.Common.QueriesEditorTAB;
import com.GS.WorkBench.Application.Dialogs.CreateNewResourceDialog;
import com.GS.WorkBench.Application.Dialogs.RunQueryDialog;
import com.GS.WorkBench.Application.Dialogs.RunWorkFlow;
/**
 * ContextMenu class contains all the options of the context menu and used to click on them.
 * @author Pawan garia
 *
 */
public class ContextMenuBot extends WizardBot{
	String ViewName = null;

	public ContextMenuBot(String ViewName) {
       
		this.ViewName = ViewName;
	}

	private SWTBotTree Currenttree = null;;
	protected SWTWorkbenchBot bot = new SWTWorkbenchBot();
	private static final String RUN_WORKFLOW_LABEL = "Run Workflow";
	private static final String DELETE_WORKFLOW = "Delete workflow";
	private static final String IMPORT_WIZARD = "Import Wizard...";
	private static final String IMPORT_WORKFLOW = "Import workflow";
	private static final String EXPORT_WIZARD = "Export Wizard...";
	private static final String EXPORT_WORKFLOW_WIZARD = "Export workflow";
	private static final String NEW = "New";
	private static final String WORKFLOW_DEFINITION = "Workflow Definition";
	private static final String WORKFLOW_GROUP = "Workflow Group";
	private static final String RENAME = "Rename";
	private static final String DELETE_GROUP = "Delete group";
	private static final String NEW_APPLICATION_SERVER_CONNECTION = "New Application Server Connection";
	private static final String DELETE_CONNECTION_PROFILE = "Delete connection profile";
	private static final String DISCONNECT_CONNECTION_PROFILE = "Disconnect";
	private static final String CONNECT_CONNECTION_PROFILE = "Connect";
	private static final String NEW_RESOURCE = "Resource"; 
	private static final String NEW_QUERY_DEFINITION="Add new Query Definition";
	private static final String PROPERTIES="Properties";
	private static final String RUN_QUERY="Run Query";
	private static final String DELETE="Delete";
	// Engines
	private static final String OPEN_ENGINE_CONFIGURATIONS="Open Engine Configuration";
	private static final String RESTART_ENGINE="Restart Engine";
	
	public boolean isRunsTheLatestReleasedWorkflowDisplayed() {
		return bot.toolbarButtonWithTooltip(
				"Runs The Latest Released Workflow Version").isVisible();
	}
	/**
	 * Run the Latest Released WorkFlow, which is Selected, and Wait for the Run WorkFlow Dialog.
	 * @return
	 * @throws Exception
	 */
	public RunWorkFlow RunsTheLatestReleasedWorkflow() throws Exception {
		bot.toolbarButtonWithTooltip(
				"Runs The Latest Released Workflow Version").click();
		// Wait for the Dialog With TExt Run WorkFlow
		CustomWaitBot.waitForDialogWithLabelText(RUN_WORKFLOW_LABEL);
		return new RunWorkFlow();
	}
    
	
	
	public RunWorkFlow RunLatestReleasedWorkflow() throws Exception {
		//ClikContextMenuItem("View");
		// Wait for the Dialog With TExt Run WorkFlow
		CustomWaitBot.waitForDialogWithLabelText(RUN_WORKFLOW_LABEL);
		return new RunWorkFlow();
	}
	
	private void ClickMenuItems(String MenuItem) {
		bot.menu(MenuItem).click();
	}
    
	/**
	 * Click any context menu Item For by providing the Whole Path For the Element comma Seperated.
	 * Example:- ClikContextMenuItem(New,Resources,NewResource)
	 * @param PATH
	 * @throws Exception
	 */
	public void ClikContextMenuItem(String... PATH) throws Exception {
		SWTBotTree Currenttree = TreeViewWidgetBot.getTree(ViewName);
		
		ContextMenuHelper.clickContextMenu(Currenttree, PATH);
	}
    /**
     * Click New Application Server Connection.
     * @throws Exception
     */
	public void newApplicationServerConnection() throws Exception {
		ClikContextMenuItem(NEW_APPLICATION_SERVER_CONNECTION);
		CustomWaitBot.waitUntilShellIsActive(NEW_APPLICATION_SERVER_CONNECTION);

	}

	public void DeleteConnectionProfile() throws Exception {
		ClikContextMenuItem(DELETE_CONNECTION_PROFILE);

	}

	public void DisconnectConnectionProfile() throws Exception {
		ClickMenuItems(DISCONNECT_CONNECTION_PROFILE);
		// ClikContextMenuItem(ViewTitle,DISCONNECT_CONNECTION_PROFILE);
	}

	public void ConnectConnectionProfile() throws Exception {
		ClikContextMenuItem(CONNECT_CONNECTION_PROFILE);
	}

	public void NewWorkFlowDefinition() throws Exception {
		ClikContextMenuItem(NEW, WORKFLOW_DEFINITION);
	}

	public void NewWorkFlowGroup() throws Exception {
		ClikContextMenuItem(NEW, WORKFLOW_GROUP);
	}

	public void RenameWorkFlowGroup() throws Exception {
		ClikContextMenuItem(RENAME);
	}

	public void DeleteWorkFlowGroup() throws Exception {
		ClikContextMenuItem(DELETE_GROUP);
	}

	public void DeleteWorkFlow() throws Exception {
		ClikContextMenuItem(DELETE_WORKFLOW);

	}

	public void openImportWizard() throws Exception {
		ClikContextMenuItem(IMPORT_WIZARD);

	}

	public void openImportWorkflowWizard() throws Exception {
		ClikContextMenuItem(IMPORT_WORKFLOW);

	}

	public void openExportWorkFlowWizard() throws Exception {
		ClikContextMenuItem(EXPORT_WORKFLOW_WIZARD);

	}

	public void openExportWizard() throws Exception {
		ClikContextMenuItem(EXPORT_WIZARD);

	}
	/**
	 * Create New Resource in the Resource Folder in Tree.
	 * 
	 * @return
	 */
	public CreateNewResourceDialog NewDataBaseResource() throws Exception {
		ClikContextMenuItem(NEW, NEW_RESOURCE);
		return new CreateNewResourceDialog();  //To Do. Create NewResourceClass methods.
	}
	/**
	 * Create New Query Definition and which returns the Query Definition Editor.
	 * Example:-configView.getQueries().selectQueriesPackage().addNewQueryDefinition();
	 * @return
	 * @throws Exception 
	 */
	public QueriesEditorTAB addNewQueryDefinition() throws Exception
	{
		ClikContextMenuItem(NEW_QUERY_DEFINITION);
		return new QueriesEditorTAB();    //To Do. Create Query Editor Tab Class methods.
	}
	/**
	 * open the Property for the Query Definition file selected
	 * @return
	 * @throws Exception
	 */
	public QueriesEditorTAB openSelectedQueryDefinition() throws Exception
	{
		ClikContextMenuItem(PROPERTIES);
		return new QueriesEditorTAB();    //To Do. Create Query Editor Tab Class methods.
	}
	/**
	 * Run Query
	 * @return
	 * @throws Exception
	 */
	public RunQueryDialog runQuery() throws Exception
	{
		ClikContextMenuItem(RUN_QUERY);
		return new RunQueryDialog();    //To Do. Create Query Editor Tab Class methods.
	}
	/**
	 * Click Delete from the context Menu., You can use the getContextMenu method to click the Enter Button to Close the delete Confirmation.
	 * @throws Exception
	 */
	public void Delete() throws Exception
	{
		ClikContextMenuItem(DELETE);
		   //To Do. Create Query Editor Tab Class methods.
	}
	
	// Context Menu Items For the Engines
	public QueriesEditorTAB openEngineConfigurations() throws Exception
	{
		ClikContextMenuItem(OPEN_ENGINE_CONFIGURATIONS);
		return new QueriesEditorTAB();    //To Do. Create Query Editor Tab Class methods.
	}
	
	public void RestartEngine() throws Exception
	{
		ClikContextMenuItem(RESTART_ENGINE);
		    //To Do. logic to handle the Process after Engine Restart.
	}
	
}
