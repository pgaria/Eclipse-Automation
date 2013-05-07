import junit.framework.Assert;

import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.GS.Perspective.WorkBench.ConfigureOrchestratorView;
import com.GS.Perspective.WorkBench.OperationsAndMonitoringView;
import com.GS.SWTBot.Helper.Utils.ContextMenuHelper;
import com.GS.SWTBot.Helper.Utils.TreeViewWidgetBot;
import com.GS.Window.Preferences.Preferences;
import com.GS.WorkBench.Application.AppServerConnection;
import com.GS.WorkBench.Application.WorkFlow;
import com.GS.WorkBench.Application.Dialogs.RunWorkFlow;

@RunWith(SWTBotJunit4ClassRunner.class)
public class ConfigureOrchestratorUnitTest {
	public static ConfigureOrchestratorView configView = null;

	@BeforeClass
	public static void setPreValues() throws Exception {

		// slow down tests
		SWTBotPreferences.PLAYBACK_DELAY = 50;
		SWTBotPreferences.TIMEOUT = 50000;
		configView = new ConfigureOrchestratorView();
		// Open Perspective
		configView.openConfigureOrchestratorPrespective();
		Preferences preferences = new Preferences();
		preferences.addApplicationServerJARfileinPreferences();
		preferences.addClientInstallationPathForDataBase();
		// preferences.addApplicationServerJARfileinPreferences("WEBLOGIC","C:/Users/pgaria/Documents/weblogic.jar");
		// preferences.addClientInstallationPathForDataBase("C:/oracle/product/11.2.0/client_1");
		configView.getConnection();
	}

	@Test
	public void ApplicationConnectedandDisconnectAndConnectAgainTest()
			throws Exception {

		
		Thread.sleep(1000);
		// configView.getConnection();

		configView.disconnectConnection();

		configView.getConnection();
		Thread.sleep(1000);

	}

	@SuppressWarnings("deprecation")
	// @Test
	public void CreteNewApplicationServerAfterProvidingPreferencesValues()
			throws Exception {

		// delete Connection
		configView.deleteConnectionProfile();
		configView.getConnection();
		System.out.println("DONe");

	}

	public void CreateNewApplicationConnectionWithCustomPropertyFile()
			throws Exception {

		// Create New Connection
		configView.deleteConnectionProfile();
		configView
				.getConnectionWithCustomPropertyFile("E:\\CEN_Framework\\workbench8.4.1\\workspace\\com.GoldenSource.CEN.Automation_Ver2\\TestData\\TestEnvConfig.properties");

		System.out.println("DONe");

	}

	// @Test
	public void SelectStandardFileWorkFlowTest() throws Exception {
		// new WorkFlow().runWK();

		configView.getWorkFlow().selectWorkFlow("Standard",
				"Standard File Load");

	}

	// @Test
	public void SelectBloomBergBackOfficeWorkFlowTest() throws Exception {
		// new WorkFlow().runWK();

		configView.getWorkFlow().selectWorkFlow("Batch Connections",
				"Bloomberg", "Bloomberg Back Office");

	}

	// @Test
	public void openRunWorkFlowForStandardFileWorkFlowTest() throws Exception {
		// TO Do...
		// We can put this code inside the ConfigureOrchestrator.java

		RunWorkFlow runWorkflow = configView.getWorkFlow().selectWorkFlow(
				"Standard", "Standard File Load")
				.RunsTheLatestReleasedWorkflow();
		Assert.assertTrue(runWorkflow.isCancelButtonEnabled());
		runWorkflow.clickCancelButton();
	}

	// @Test
	public void EnterValuesStandardFileWorkFlowInRunWorkFlowDialogTest()
			throws Exception {

		RunWorkFlow runWorkflow = configView.getWorkFlow().selectWorkFlow(
				"Standard", "Standard File Load")
				.RunsTheLatestReleasedWorkflow();
		runWorkflow.EnterFileName("db://resource/QA/StandardMessageFile.txt");
		runWorkflow.EnterMessageType("BBGlobalEquity");
		Assert.assertTrue(runWorkflow.isOKButtonEnabled());
		Assert.assertTrue(runWorkflow.isCancelButtonEnabled());
		runWorkflow.clickCancelButton();
	}

	public void SelectValueOfComboBoxInRunWorkFlowDialogTest() throws Exception {
		/*
		 * ConfigureOrchestratorView configView = new
		 * ConfigureOrchestratorView(); WorkFlow workflow=
		 * configView.getWorkFlow
		 * ().selectWorkFlow("Standard","Standard File Load"); RunWorkFlow
		 * runWorkflow =
		 * workflow.getContextManuItem().RunsTheLatestReleasedWorkflow();
		 * runWorkflow
		 * .EnterFileName("db://resource/QA/StandardMessageFile.txt");
		 * runWorkflow.EnterMessageType("BBGlobalEquity");
		 * runWorkflow.SelectValusInCellFromDropDown("SuccessAction","DELETE");
		 * Assert.assertTrue(runWorkflow.isOKButtonEnabled());
		 * Assert.assertTrue(runWorkflow.isCancelButtonEnabled());
		 * runWorkflow.clickCancelButton();
		 */
	}

	public void CreateNewWorkFlow() throws Exception {

		configView.getWorkFlow().selectWorkFlowsPackage()
				.NewWorkFlowDefinition();

	}

	@Test
	public void ConnectinConfigOrchestratorandSelectWorkFlowinMonitoringPrespective()
			throws Exception {

		OperationsAndMonitoringView operationView = new OperationsAndMonitoringView();
		// Open Perspective
		operationView.openOperationsAndMonitoringPrespective();

		operationView.getConnection();

		operationView.getWorkFlow().selectWorkFlow("Standard",
				"Standard File Load");

	}
}
