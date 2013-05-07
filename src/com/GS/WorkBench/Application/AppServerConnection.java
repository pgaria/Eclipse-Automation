package com.GS.WorkBench.Application;

import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;

import com.GS.SWTBot.Helper.Utils.BotUtils;
import com.GS.SWTBot.Helper.Utils.ContextMenuBot;
import com.GS.SWTBot.Helper.Utils.ContextMenuHelper;
import com.GS.SWTBot.Helper.Utils.CustomWaitBot;
import com.GS.SWTBot.Helper.Utils.SWTBotCommonActionBot;
import com.GS.SWTBot.Helper.Utils.TreeViewWidgetBot;
import com.GS.SWTBot.Helper.Utils.WizardBot;
import com.GS.Utility.EnvironmentValues;

/**
 * Application server Class Contains all the Methods related to the connection
 * to the Environment, creating new application server.
 * 
 * @author pawan garia
 * 
 */
public class AppServerConnection extends WizardBot {

	private SWTBotCommonActionBot CommonActionBot = new SWTBotCommonActionBot();
	private EnvironmentValues environmentValues;
	private SWTBotTree Currenttree;
	private final String Environment_Values_PropertyFile = "/EnvironmentConfiguration/EnvConfig.properties";
	private static final String APPLICATION_SERVER_TYPE = "Application Server type:";
	private static final String JNDI_PROVIDER_URL = "JNDI Service Provider URL:";
	private static final String CONNECTION_NAME = "Connection Name:";
	private static final String INITIAL_CONTEXT_FACTORY = "Initial Context Factory:";
	private static final String USERNAME = "Username:";
	private static final String PASSWORD = "Password:";
	private static final String CHECK_ADDITIONAL_ENVIRONMENTAL_PROPERTY = "Additional Environment properties(name=value;)";
	private static final String CHECK_SAVE_PASSWORD = "Save username";
	private static final String CHECK_SAVE_USERNAME = "Save password";

	// private TreeViewWidgetBot treeViewWidgetbot= new TreeViewWidgetBot();
	/**
	 * Check method to is the application server is connected or not.
	 */
	private boolean isApplicationServerConnected(String AppServerName,
			String ViewName) throws Exception {
		boolean isConnected = false;
		SWTBotTree Currenttree = FindAppServerConnection(AppServerName,
				ViewName);
		SWTBotTreeItem[] AllItems = Currenttree.getAllItems();
		for (SWTBotTreeItem EnvName : AllItems) {
			SWTBotTreeItem[] ChildNodes = EnvName.getItems();
			if (ChildNodes.length != 0) {
				// return True if connected.And Return False if not Connected.
				isConnected = true;
			}

		}
		return isConnected;

	}

	/**
	 * Get connection method With the Custom property file is used to get the
	 * connection. this method checks for the Connection is present or nor. if
	 * not present Create NEw Connection. If the connection is present and not
	 * connected connect the application.
	 * 
	 * @param AppServerName
	 * @param ViewName
	 * @throws Exception
	 */
	public void getConnection(String AppServerName, String ViewName)
			throws Exception {
		SWTBotTree CurrentTreeInView = FindAppServerConnection(AppServerName,
				ViewName);
		SWTBotTreeItem[] Items = CurrentTreeInView.getAllItems();

		if (Items.length == 0) {
			NewApplicationServerConnection(ViewName, CurrentTreeInView, "");
		} else {

			// For False values Connect the Application Server
			if (!isApplicationServerConnected(AppServerName, ViewName)) {
				// If False Connect Again
				getContextManuItem(ViewName).ConnectConnectionProfile();
				loginPageForReconnect(ViewName);

			}
		}

	}

	/**
	 * Get connection method With the Custom property file is used to get the
	 * connection. this method checks for the Connection is present or nor. if
	 * not present Create NEw Connection. If the connection is present and not
	 * connected connect the application.
	 * 
	 * @param AppServerName
	 * @param ViewName
	 * @param propertyFilePath
	 * @throws Exception
	 */
	public void getConnection(String AppServerName, String ViewName,
			String propertyFilePath) throws Exception {
		SWTBotTree CurrentTreeInView = FindAppServerConnection(AppServerName,
				ViewName);
		if (!CurrentTreeInView.equals(null)) {
			NewApplicationServerConnection(ViewName, CurrentTreeInView,
					propertyFilePath);
		} else {

			// For False values Connect the Application Server
			if (!isApplicationServerConnected(AppServerName, ViewName)) {
				// If False Connect Again
				getContextManuItem(ViewName).ConnectConnectionProfile();
				loginPageForReconnect(ViewName);

			}
		}

	}

	/**
	 * Find the App server connection is present or not in the View.
	 * 
	 * @param AppServerName
	 * @param ViewName
	 * @return
	 * @throws Exception
	 */
	private SWTBotTree FindAppServerConnection(String AppServerName,
			String ViewName) throws Exception {

		SWTBotTree Currenttree = TreeViewWidgetBot.getTree(ViewName);
		return Currenttree;
	}

	/**
	 * Delete the connection Profile.
	 * 
	 * @param AppServerName
	 * @param ViewName
	 * @throws Exception
	 */
	public void deleteConnectionProfile(String AppServerName, String ViewName)
			throws Exception {
		SWTBotTree CurrentTreeInView = FindAppServerConnection(AppServerName,
				ViewName);
		if (!CurrentTreeInView.equals(null)) {
			TreeViewWidgetBot.setectTreeNode(CurrentTreeInView);
			getContextManuItem(ViewName).DeleteConnectionProfile();
			Thread.sleep(3000);

			super.clickEnterButton();
		}
	}

	/**
	 * Disconnect the Application server if not connected do nothing.
	 * 
	 * @param AppServerName
	 * @param ViewName
	 * @throws Exception
	 */
	public void disconnectConnectionProfile(String AppServerName,
			String ViewName) throws Exception {
		SWTBotTree CurrentTreeInView = FindAppServerConnection(AppServerName,
				ViewName);
		if (!CurrentTreeInView.equals(null)) {
			TreeViewWidgetBot.setectTreeNode(CurrentTreeInView);
			getContextManuItem(ViewName).DisconnectConnectionProfile();
		}
	}

	/**
	 * New application server Connection method is used to Enter all the
	 * details.
	 * 
	 * @param ViewName
	 * @param CurrentTreeInView
	 * @param propertyFilePath
	 * @throws Exception
	 */
	private void NewApplicationServerConnection(String ViewName,
			SWTBotTree CurrentTreeInView, String propertyFilePath)
			throws Exception {
		// Click New Application Server Connection
		getContextManuItem(ViewName).newApplicationServerConnection();
		// Custom Wait
		CustomWaitBot.waitForDialogWithLabelText(APPLICATION_SERVER_TYPE);
		// Load Property File
		if (propertyFilePath.length() != 0) {

			environmentValues = new EnvironmentValues(propertyFilePath);
		} else
			environmentValues = new EnvironmentValues(System
					.getProperty("user.dir")
					+ Environment_Values_PropertyFile);

		// Application Server Type
		SelectApplicationServerType(EnvironmentValues
				.getApplicationServerTYPE());
		// Set JNDI URL for application server
		SetJNDIServerPRoviderURL(EnvironmentValues
				.getApplicationServerJNDIURL());
		// Set UserName
		SetUserName(EnvironmentValues.getApplicationServerUserName());
		// Set Password
		SetPassword(EnvironmentValues.getApplicationServerPassword());
		super.clickFinishButton();

		// Wait for the New Connection to be made in View.
		Currenttree = TreeViewWidgetBot.getTree(ViewName);
		BotUtils.waitForConnection(
				EnvironmentValues.getApplicationServerTYPE(), Currenttree);

	}

	private void loginPageForReconnect(String ViewName) throws Exception {
		String ConnectingShellTitle="Connecting to "
			+ EnvironmentValues.getApplicationServerJNDIURL() + " ...";
		CustomWaitBot.waitForDialogWithLabelText(USERNAME);
		// Set UserName
		SetUserName(EnvironmentValues.getApplicationServerUserName());
		// Set Password
		SetPassword(EnvironmentValues.getApplicationServerPassword());
		super.clickOKButton();
		// Wait for the Connection Shell to be closed.
		CustomWaitBot.waitUntilShellCloses(ConnectingShellTitle);
		// Wait for the New Connection to be made in View.
		Currenttree = TreeViewWidgetBot.getTree(ViewName);
		BotUtils.waitForConnection(
				EnvironmentValues.getApplicationServerTYPE(), Currenttree);
	}

	private void SelectApplicationServerType(String ApplicationServerName) {

		CommonActionBot.selectValueInComboBox(APPLICATION_SERVER_TYPE,
				ApplicationServerName);

	}

	private void SelectConnectionNname(String connectionName) {
		CommonActionBot.EnterText(CONNECTION_NAME, connectionName);
	}

	private void SelectInitialContextFactory(String ConnectionFactory) {
		CommonActionBot.selectValueInComboBox(INITIAL_CONTEXT_FACTORY,
				ConnectionFactory);
	}

	private void SetJNDIServerPRoviderURL(String JNDIServerProviderURL) {
		// CommonActionBot.ClearText();
		CommonActionBot.EnterText(JNDI_PROVIDER_URL, JNDIServerProviderURL);

	}

	public void SetUserName(String username) {
		// CommonActionBot.ClearText();
		CommonActionBot.EnterText(USERNAME, username);
	}

	public void SetPassword(String password) {
		// CommonActionBot.ClearText();
		CommonActionBot.EnterText(PASSWORD, password);
	}

	public void CheckAdditionalEnvironmentPropertiesCheckBox() {
		CommonActionBot.selectCheckBox(CHECK_ADDITIONAL_ENVIRONMENTAL_PROPERTY);

	}

	public void CheckSavePassword() {
		CommonActionBot.selectCheckBox(CHECK_SAVE_PASSWORD);

	}

	public void UncheckSavePassword() {
		CommonActionBot.selectCheckBox(CHECK_SAVE_PASSWORD);
	}

	public void CheckSaveUserName() {
		CommonActionBot.selectCheckBox(CHECK_SAVE_USERNAME);
	}

	public void UncheckSaveUserName() {
		CommonActionBot.selectCheckBox(CHECK_SAVE_USERNAME);
	}

	public ContextMenuBot getContextManuItem(String ViewName) {
		return new ContextMenuBot(ViewName);
	}

}
