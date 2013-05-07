import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.GS.Perspective.WorkBench.ConfigureOrchestratorView;
import com.GS.Window.Preferences.Preferences;

@RunWith(SWTBotJunit4ClassRunner.class)
public class ResourcesUnitTest {
        
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
		public void selectResourcesPackage() throws Exception
		{
			configView.getResources().selecResourcesPackage();
       
		}
		@Test
		public void selectDataBaseResourcesPackage() throws Exception
		{
			configView.getResources().selectDateBaseResourcePackage();
       
		}
		
		@Test
		public void selectPackagedResourcesPackage() throws Exception
		{
			configView.getResources().selectPackagedResourcesPackage();
       
		}
		@Test
		public void selectSubPackagedInsideDatabaseResourcesPackage() throws Exception
		{
			configView.getResources().selectPackageInsideDataBaseResourcePackage("QA");
       
		}
		@Test
		public void CteateNewPackageInDataBaseResources() throws Exception
		{
			configView.getResources().selectDateBaseResourcePackage().NewDataBaseResource();
       
		}
}
