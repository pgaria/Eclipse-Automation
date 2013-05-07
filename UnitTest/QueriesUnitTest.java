import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.GS.Perspective.WorkBench.ConfigureOrchestratorView;
import com.GS.Window.Preferences.Preferences;
import com.GS.WorkBench.Application.Common.QueriesEditorTAB;

@RunWith(SWTBotJunit4ClassRunner.class)
public class QueriesUnitTest {
	public static ConfigureOrchestratorView configView=null;
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
		//preferences.addApplicationServerJARfileinPreferences("WEBLOGIC","C:/Users/pgaria/Documents/weblogic.jar");
		//preferences.addClientInstallationPathForDataBase("C:/oracle/product/11.2.0/client_1");
		configView.getConnection();
	}

	public void selectQueriesFolder() throws Exception
	{
		configView.getQueries().selectQueriesPackage();
	}
	@Test
	public void selectJobStatusQuerieFileInsideQueriesFolder() throws Exception
	{
		configView.getQueries().selectQueriesFileInsideQueriesPackage("JobStatus");
	}
	
	@Test
	public void CreateNewQuerieFileInsideQueriesFolder() throws Exception
	{
		configView.getQueries().selectQueriesPackage().addNewQueryDefinition().closeTABwithOutSavingFile("*New Query Definition");
	}
	
	@Test
	public void EditNameOfNewQueryDefinition() throws Exception
	{
		QueriesEditorTAB queryTab = configView.getQueries().selectQueriesPackage().addNewQueryDefinition();
		queryTab.clickQueryTextCTab();
		
		queryTab.EnterQueryText("Select * from");
		queryTab.closeTABwithOutSavingFile("*New Query Definition");
		
		//queryTab.EnterText();
	}
	
	@Test
	public void openSelectedQueryDefinition() throws Exception
	{
		QueriesEditorTAB queryTab = configView.getQueries().selectQueriesFileInsideQueriesPackage("JobStatus").openSelectedQueryDefinition();
		
		queryTab.closeTABwithOutSavingQueryFile("JobStatus");
	}
	@Test
	public void cretaeNEwDefinitionAndSaveQueryDefinition() throws Exception
	{
		QueriesEditorTAB queryTab = configView.getQueries().selectQueriesPackage().addNewQueryDefinition();
		queryTab.clickQueryTextCTab();
		
		queryTab.EnterQueryText("Select * from");
		queryTab.closeTABwithSavingQueryFile("*New Query Definition").selectDatbaseConnection("jdbc/GSDM-1");
		queryTab.clickOKButton();
	}
	@Test
	public void DeleteQueryDefinition() throws Exception
	{
		configView.getQueries().selectQueriesFileInsideQueriesPackage("New Query Definition").Delete();
		configView.getContextManuItem().clickEnterButton();
	}
	@Test
	public void RunSelectedQueryDefinition() throws Exception
	{   
		System.out.println("Last");
		configView.getQueries().selectQueriesFileInsideQueriesPackage("JobStatus").runQuery();
		
	}
}
