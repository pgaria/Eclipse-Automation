/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License. 
 *  
 */
package com.GS.SWTBot.Helper.Utils;

import java.awt.Robot;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;

/**
 * Class used to do all the works related to the Preferences page
 * @author Pawan garia
 *
 */
public class PreferencesBot extends WizardBot
{    
	private String APPLICATIONSERVER_NAME="Name";
	private String JAR_FILE_PATH="File";
	private String CLIENT_INSTALLATION_PATH = "Client Installation Path ";
	private SWTBotCommonActionBot CommonAction = new SWTBotCommonActionBot();	
    public boolean isVisible()
    {
        return super.isVisible( "Preferences" );
    }
    
    /**
     * open application server configuration page based on the Application server type
     * @param ApplicationServerName
     */
    private void openApplicationServerConfigurationPage(String ApplicationServerName)
    {   
    	if(ApplicationServerName.equalsIgnoreCase("WEBLOGIC"))
    	{
    		ApplicationServerName="WebLogic";
    	}if(ApplicationServerName.equalsIgnoreCase("WEBSPHERE"))
    	{
    		ApplicationServerName="WebSpheres";
    	}if(ApplicationServerName.equalsIgnoreCase("JBOSS"))
    	{
    		ApplicationServerName="JBoss";
    	}
        bot.tree().getTreeItem( "GoldenSource" ).select().expand().getNode( "Application Server Configuration" ).select()
            .expand().getNode( ApplicationServerName+" Installations" ).select();
       
    }
    
    private void openDataBaseSettingPage()
    {   
    	bot.tree().collapseNode("GoldenSource");
        bot.tree().getTreeItem( "GoldenSource" ).select().expand().getNode( "Database Settings" ).select();
          
    }
   
    
    private void enterName(String ApplicationServerName)
    {
    	 CommonAction.EnterText(APPLICATIONSERVER_NAME,ApplicationServerName);
    }
    private void enterJarFilePath(String ApplicationServerJARfilePATH)
    {
    	CommonAction.EnterText(JAR_FILE_PATH,ApplicationServerJARfilePATH);
    }
    
   /* private boolean isJarFileisAdded()
    {
    	
    }*/
    /**
     * Add Application server jar file path in the page.
     */
    public void AddApplicationServerJarFile(String ApplicationServerName,String ApplicationServerJARfilePATH) throws Exception
    {   
    	
    	openApplicationServerConfigurationPage(ApplicationServerName);
    	Robot key = new Robot(); 
    	super.clickAddButton();
    	enterName(ApplicationServerName);
    	enterJarFilePath(ApplicationServerJARfilePATH);
    	key.keyPress(java.awt.event.KeyEvent.VK_ENTER);
   	    key.keyPress(java.awt.event.KeyEvent.VK_ENTER);
   	    super.clickOKButton();
    }
    
    //DataBase Setting Part..
    private void enterClientInstallationPath(String ClientInstallationPath) {
		CommonAction
				.EnterText(CLIENT_INSTALLATION_PATH, ClientInstallationPath);
	}

	public void AddDataBaseSettingPreference(String ClientInstallationPath)
			throws Exception {
		openDataBaseSettingPage();
		enterClientInstallationPath(ClientInstallationPath);
		super.clickOKButton();
	}
    
    
    
    
}
