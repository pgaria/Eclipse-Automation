package com.GS.Utility;

import java.io.File;
import java.util.Properties;

public class EnvironmentValues {
	// USe the getter and setter values to get the runtime config values
	Properties runtimevalue = null;
    private static boolean flag=false; 
	// Application Server Details
    private static String applicationVersion=null;
	private static String ApplicationServerTYPE = null;
	private static String ApplicationServerJNDIURL = null;
	private static String ApplicationServerUserName = null;
	private static String ApplicationServerPassword = null;
	private static String ApplicationName = null;
	private static String applicationServerPort = null;
	private static String applicationServerHostName = null;
	private static String WebLogicUserName = null;
	private static String WebLogicPassword = null;
	private static String JNDIName = null;
    private static String ApplicationServerJarFilePath=null;
	// Data Base parameters form RuntimeConfig File

	private static String DBSysUserName = null;
	private static String DBSysPwd = null;
	private static String DBService = null;
	private static String DBHostName = null;
	private static String DataBasePortNO = null;
	private static String DBSchemaName = null;
	private static String DBSchemaPwd = null;
	private static String jndiURL = null;
	private static String DBClientInstallationPath = null;
   
	private static String EnvironmentName=null;
	private static String  ApplicationJNDIParentTreeNode=null;
	public EnvironmentValues(String ConfigFilePath) throws Exception {
		
		if(!flag)
		{// reading from the config file
		LoadPropertiesFromConf(ConfigFilePath);
		}
	}
    
	public void LoadPropertiesFromConf(String ConfigFilePath) throws Exception {
		this.runtimevalue = PropertyFileUtil.loadProperties(ConfigFilePath);
		setApplicationVersion();
		setApplicationName();
		setApplicationServerJarFilePath();
		setApplicationServerTYPE();
		setApplicationServerJNDIURL();
		setApplicationServerUserName();
		setApplicationServerPassword();
		setApplicationServerPort();
		setApplicationServerHostName();
		setWebLogicUserName();
		setWebLogicPassword();
		setJNDIName();
		setDBSysUserName();
		setDBSysPwd();
		setDBService();
		setDBHostName();
		setDataBasePortNO();
		setDBSchemaName();
		setDBSchemaPwd();
		setDBClientInstallationPath();
		CreateRuntimeStrings();
		flag=true;
        
	}
    
	private static void CreateRuntimeStrings() {
		EnvironmentValues.ApplicationJNDIParentTreeNode = ApplicationServerTYPE + " ["
				+ ApplicationServerUserName + "@t3://"
				+ applicationServerHostName + ":" + applicationServerPort + "]";
		EnvironmentValues.EnvironmentName = EnvironmentValues.ApplicationName + " - (" + EnvironmentValues.applicationVersion + ")";

	}
	
	private void setApplicationServerJarFilePath() {
		EnvironmentValues.ApplicationServerJarFilePath = PropertyFileUtil.getPropertyValue(
				runtimevalue, "applicationServerJarFilePath");
	}

	public static String getApplicationServerJarFilePath() {
		return EnvironmentValues.ApplicationServerJarFilePath;
	}

	public static String getApplicationJNDIParentTreeNode() {
		return EnvironmentValues.ApplicationJNDIParentTreeNode;
	}
	
	
	public static String  getEnvironmentName() {
		return EnvironmentValues.EnvironmentName;
		 
		}
    
	private void setApplicationVersion() {
		this.applicationVersion = PropertyFileUtil.getPropertyValue(
				runtimevalue, "applicationVersion");
	}
	
	public static String getApplicationVersion() {
		return EnvironmentValues.applicationVersion;
	}
	
	
	private void setApplicationServerTYPE() {
		this.ApplicationServerTYPE = PropertyFileUtil.getPropertyValue(
				runtimevalue, "applicationServerType");
	}

	public static String getApplicationServerTYPE() {
		return EnvironmentValues.ApplicationServerTYPE;
	}

	private void setApplicationServerJNDIURL() {
		this.ApplicationServerJNDIURL = PropertyFileUtil.getPropertyValue(
				runtimevalue, "applicationServerJNDIURL");
	}

	public static String getApplicationServerJNDIURL() {
		return ApplicationServerJNDIURL;
	}

	private void setApplicationServerUserName() {
		this.ApplicationServerUserName = PropertyFileUtil.getPropertyValue(
				runtimevalue, "applicationServerUserName");
	}

	public static String getApplicationServerUserName() {
		return ApplicationServerUserName;
	}

	private void setApplicationServerPassword() {
		this.ApplicationServerPassword = PropertyFileUtil.getPropertyValue(
				runtimevalue, "applicationServerPassword");
	}

	public static String getApplicationServerPassword() {
		return ApplicationServerPassword;
	}

	public static String getApplicationName() {
		return ApplicationName;
	}

	private void setApplicationName() {
		ApplicationName = PropertyFileUtil.getPropertyValue(runtimevalue,
				"applicationName");
	}

	public static String getApplicationServerPort() {
		return applicationServerPort;
	}

	private void setApplicationServerPort() {
		applicationServerPort = PropertyFileUtil.getPropertyValue(runtimevalue,
				"applicationServerPort");
	}

	public static String getApplicationServerHostName() {
		return applicationServerHostName;
	}

	private void setApplicationServerHostName() {
		applicationServerHostName = PropertyFileUtil.getPropertyValue(
				runtimevalue, "applicationServerHostName");
	}

	public static String getWebLogicUserName() {
		return WebLogicUserName;
	}

	private void setWebLogicUserName() {
		WebLogicUserName = PropertyFileUtil.getPropertyValue(runtimevalue,
				"applicationServerAdminUserName");
	}

	public static String getWebLogicPassword() {
		return WebLogicPassword;
	}

	private void setWebLogicPassword() {
		WebLogicPassword = PropertyFileUtil.getPropertyValue(runtimevalue,
				"applicationServerAdminPassword");
	}

	public static String getJNDIName() {
		return JNDIName;
	}

	private void setJNDIName() {

		this.JNDIName = PropertyFileUtil.getPropertyValue(runtimevalue,
				"jndiName");
	}

	public static String getDBSysUserName() {
		return DBSysUserName;
	}

	private void setDBSysUserName() {
		System.out.println(PropertyFileUtil.getPropertyValue(runtimevalue,
				"DBSysUserName"));
		DBSysUserName = PropertyFileUtil.getPropertyValue(runtimevalue,
				"DBSysUserName");
	}

	public static String getDBSysPwd() {
		return DBSysPwd;
	}

	private void setDBSysPwd() {
		DBSysPwd = PropertyFileUtil.getPropertyValue(runtimevalue, "DBSysPwd");
	}

	public static String getDBService() {
		return DBService;
	}

	private void setDBService() {
		DBService = PropertyFileUtil
				.getPropertyValue(runtimevalue, "DBService");
	}

	public static String getDBHostName() {
		return DBHostName;
	}

	private void setDBHostName() {
		DBHostName = PropertyFileUtil.getPropertyValue(runtimevalue,
				"DBHostName");
	}

	public static String getDataBasePortNO() {
		return DataBasePortNO;
	}

	private void setDataBasePortNO() {
		DataBasePortNO = PropertyFileUtil.getPropertyValue(runtimevalue,
				"DataBasePortNO");
	}

	public static String getDBSchemaName() {
		return DBSchemaName;
	}

	private void setDBSchemaName() {
		DBSchemaName = PropertyFileUtil.getPropertyValue(runtimevalue,
				"DBSchemaName");
	}

	public static String getDBSchemaPwd() {
		return DBSchemaPwd;
	}

	private void setDBSchemaPwd() {
		DBSchemaPwd = PropertyFileUtil.getPropertyValue(runtimevalue,
				"DBSchemaPwd");
	}

	public static String getDBClientInstallationPath() {
		return DBClientInstallationPath;
	}

	private void setDBClientInstallationPath() {
		DBClientInstallationPath = PropertyFileUtil.getPropertyValue(
				runtimevalue, "DBClientInstallationPath");
	}
}
