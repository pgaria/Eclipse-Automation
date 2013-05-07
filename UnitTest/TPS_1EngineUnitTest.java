import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.GS.Perspective.WorkBench.ConfigureOrchestratorView;
import com.GS.Window.Preferences.Preferences;

@RunWith(SWTBotJunit4ClassRunner.class)
public class TPS_1EngineUnitTest {
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
	@Test
	public void selectEnginesNodeinTree() throws Exception
	{
		configView.getEngines().selectEnginesNode();
   
	}
	@Test
	public void selectTPS_1_EnginesNodeinTree() throws Exception
	{
		configView.getEngines().selectEnginesTPS_1();
   
	}
	@Test
	public void selectTPS_UI_NodeinTree() throws Exception
	{
		configView.getEngines().selectEnginesTPS_UI();
   
	}
	@Test
	public void selectTPS_VDDB_NodeinTree() throws Exception
	{
		configView.getEngines().selectEnginesTPS_VDDB();
   
	}
	
}
