package com.GS.Window.Preferences;

import java.awt.Robot;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;

import com.GS.SWTBot.Helper.Utils.PreferencesBot;
import com.GS.SWTBot.Helper.Utils.StudioBot;
import com.GS.SWTBot.Helper.Utils.TreeViewWidgetBot;
import com.GS.Utility.EnvironmentValues;

/**
 * preference page Setting
 * 
 * @author pawan garia
 * 
 */
public class Preferences {

	private StudioBot studioBot = null;
	private String ApplicationServerName = null;
	private String ApplicationServerJARfilePATH = null;
	private String ClientInstallationPath = null;
	private final String Environment_Values_PropertyFile = "/EnvironmentConfiguration/EnvConfig.properties";
	public Preferences() throws Exception {
		this.studioBot = new StudioBot();
		new EnvironmentValues(System.getProperty("user.dir")+ Environment_Values_PropertyFile);
		getRunTimeEnvironmentValues();
	}

	private void getRunTimeEnvironmentValues() {

		this.ApplicationServerName = EnvironmentValues.getApplicationServerTYPE();
		this.ApplicationServerJARfilePATH = EnvironmentValues
				.getApplicationServerJarFilePath();
		this.ClientInstallationPath = EnvironmentValues
				.getDBClientInstallationPath();
	}

	private void applicationServerJarFilePathSet(String ApplicationServerName,
			String ApplicationServerJARfilePATH) throws Exception {
		// open preferences dialog
		PreferencesBot preferencesBot = studioBot.openPreferences();
		if (preferencesBot.isVisible()) {
			// Add the Application server Jar file
			preferencesBot.AddApplicationServerJarFile(ApplicationServerName,
					ApplicationServerJARfilePATH);
		} else
			System.out.println("Preference page is not Opened...");
	}

	/**
	 * Add Application server Jar File with the Specific Application name and
	 * Jar file path, which is passed by the user from the Test.
	 * Example:-preferences.addApplicationServerJARfileinPreferences("WEBLOGIC",
	 * "C:/Users/pgaria/Documents/weblogic.jar");
	 * 
	 * @param ApplicationServerName
	 * @param ApplicationServerJARfilePATH
	 * @throws Exception
	 */
	public void addApplicationServerJARfileinPreferences(
			String ApplicationServerName, String ApplicationServerJARfilePATH)
			throws Exception {
		applicationServerJarFilePathSet(ApplicationServerName,
				ApplicationServerJARfilePATH);

	}

	/**
	 * Add Application server Jar File with the Specific Application name and
	 * Jar file path, which is specified in the Property File. Example:-
	 * preferences.addApplicationServerJARfileinPreferences();
	 * 
	 * @throws Exception
	 */
	public void addApplicationServerJARfileinPreferences() throws Exception {
		applicationServerJarFilePathSet(ApplicationServerName,
				ApplicationServerJARfilePATH);
	}

	/**
	 * Add DataBase Client Installation Path , which is specified in the
	 * Property File. Example:-
	 * preferences.addClientInstallationPathForDataBase();
	 * 
	 * @throws Exception
	 */
	public void addClientInstallationPathForDataBase() throws Exception {
		setClientInstallationPathForDataBase(ClientInstallationPath);
	}

	/**
	 * Add DataBase Client Installation Path, which is passed by the user from
	 * the Test. Example :- preferences.addClientInstallationPathForDataBase(
	 * "C:/oracle/product/11.2.0/client_1");
	 * 
	 * @param ClientInstallationPath
	 * @throws Exception
	 */
	public void addClientInstallationPathForDataBase(
			String ClientInstallationPath) throws Exception {
		setClientInstallationPathForDataBase(ClientInstallationPath);
	}

	private void setClientInstallationPathForDataBase(
			String ClientInstallationPath) throws Exception {
		// open preferences dialog
		PreferencesBot preferencesBot = studioBot.openPreferences();
		if (preferencesBot.isVisible()) {
			// Add the DB Client Installation Path
			preferencesBot.AddDataBaseSettingPreference(ClientInstallationPath);
		} else
			System.out.println("Preference page is not Opened...");
	}

}
