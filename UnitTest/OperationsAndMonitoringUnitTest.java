import junit.framework.Assert;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.GS.Perspective.WorkBench.ConfigureOrchestratorView;
import com.GS.Perspective.WorkBench.OperationsAndMonitoringView;
import com.GS.Window.Preferences.Preferences;
import com.GS.WorkBench.Application.AppServerConnection;
import com.GS.WorkBench.Application.WorkFlow;
import com.GS.WorkBench.Application.Dialogs.RunWorkFlow;

@RunWith(SWTBotJunit4ClassRunner.class)
public class OperationsAndMonitoringUnitTest {
	public static OperationsAndMonitoringView operationView = null;
	public static ConfigureOrchestratorView configView = null;
	   	@BeforeClass
	public static void setPreValues() throws Exception
	{    
	   	
		// slow down tests
		SWTBotPreferences.PLAYBACK_DELAY =50;
		SWTBotPreferences.TIMEOUT = 50000;
		configView = new ConfigureOrchestratorView();
		// Open Perspective
		configView.openConfigureOrchestratorPrespective();
		//Open Preferences and Change the File Path for Weblogic and Oracle
		Preferences preferences = new Preferences();
		preferences.addApplicationServerJARfileinPreferences();
		preferences.addClientInstallationPathForDataBase();		
		configView.getConnection();
		//Start Opeartions and Monitring Testcases
		operationView = new OperationsAndMonitoringView();
		//Open Perspective 
		operationView.openOperationsAndMonitoringPrespective();
		
	
		
	}
	   	
		@SuppressWarnings("deprecation")
		@Test
		public void NewConnectionCreation() throws Exception
		{
		operationView.getConnection();
		}
		
		@Test
		public void SelectStandardFileWorkFlowTest() throws Exception
		{    
			
			//new WorkFlow().runWK();
			operationView.getWorkFlow().selectWorkFlow("Standard","Standard File Load");
			
		}
		@Test
		public void SelectBloomBergBackOfficeWorkFlowTest() throws Exception
		{   
		
			//new WorkFlow().runWK();
			operationView.getWorkFlow().selectWorkFlow("Batch Connections","Bloomberg","Bloomberg Back Office");
			
		}
	    @Test
		public void openRunWorkFlowForStandardFileWorkFlowTest() throws Exception
		{   
	    	// TO do .....Unable to click on the Run Latest Released Version Context manu item of Opeartion and monitoring
			
			
			//RunWorkFlow runWorkflow = operationView.getWorkFlow().selectWorkFlow("Standard","Standard File Load").RunLatestReleasedWorkflow();
			
			//Assert.assertTrue(runWorkflow.isCancelButtonEnabled());
			//runWorkflow.clickCancelButton();
		}
	    @Test
	    public void EnterValuesStandardFileWorkFlowInRunWorkFlowDialogTest() throws Exception
		{// TO do..... Unable to click on the Run Latest Released Version Context manu item of Opeartion and monitoring
	    
			//new WorkFlow().runWK();
	    	//RunWorkFlow runWorkflow =  operationView.getWorkFlow().selectWorkFlow("Standard","Standard File Load").RunLatestReleasedWorkflow();
			
			//Enter Values
			//runWorkflow.EnterFileName("db://resource/QA/StandardMessageFile.txt");
		//	runWorkflow.EnterMessageType("BBGlobalEquity");
		//	Assert.assertTrue(runWorkflow.isOKButtonEnabled());
		//	/Assert.assertTrue(runWorkflow.isCancelButtonEnabled());
		//	runWorkflow.clickCancelButton();
		}
}