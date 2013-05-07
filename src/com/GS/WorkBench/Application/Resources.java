package com.GS.WorkBench.Application;

import com.GS.SWTBot.Helper.Utils.ContextMenuBot;
import com.GS.SWTBot.Helper.Utils.TreeViewWidgetBot;
import com.GS.Utility.EnvironmentValues;
/**
 * Resource Class is the Class Which contains all the methods related to the Resource folder inside the Tree.
 * @author Pawan garia
 *
 */
public class Resources {
	private String ApplicationJNDIParentTreeNode = null;
	private String EnvironmentName = null;
	private TreeViewWidgetBot treeViewBot = null;
	private String ViewName = null;
	private String RESOURCES="Resources";
	private String DATABASE_RESOURCES="Database resources";
	private String PACKAGED_RESOURCES="Packaged resources";

	public Resources(String ViewName) {

		this.ViewName = ViewName;
		getRunTimeEnvironmentValues();
	}

	private void getRunTimeEnvironmentValues() {
		treeViewBot = new TreeViewWidgetBot();
		this.ApplicationJNDIParentTreeNode = EnvironmentValues
				.getApplicationJNDIParentTreeNode();
		this.EnvironmentName = EnvironmentValues.getEnvironmentName();
	}
	
	/**
	 * Select the Resources Package Folder in the Tree and the Selection Depends upon the View.
	 * Example. configView.getResources().selecResourcesPackage();
	 * @return
	 * @throws Exception
	 */
	public ContextMenuBot selecResourcesPackage() throws Exception {
		
		treeViewBot.selectEntry(ViewName, ApplicationJNDIParentTreeNode,
				EnvironmentName, RESOURCES);
		return new ContextMenuBot(ViewName);
	}
	/**
	 * Select the DateBase Resource Package in side Resources Folder.The Selection Depends upon the View.
	 * Ex.configView.getResources().selectDateBaseResourcePackage(); 
	 * @return
	 * @throws Exception
	 */
	public ContextMenuBot selectDateBaseResourcePackage() throws Exception
	{
		
		treeViewBot.selectEntry(ViewName, ApplicationJNDIParentTreeNode,
				EnvironmentName, RESOURCES,DATABASE_RESOURCES);
		return new ContextMenuBot(ViewName);
	}
	/**
	 * Select the Packaged Resources Package in side Resources Folder.The Selection Depends upon the View.
	 * Ex.configView.getResources().selectPackagedResourcesPackage(); 
	 * @return
	 * @throws Exception
	 */
	public ContextMenuBot selectPackagedResourcesPackage() throws Exception
	{
		
		treeViewBot.selectEntry(ViewName, ApplicationJNDIParentTreeNode,
				EnvironmentName, RESOURCES,PACKAGED_RESOURCES);
		return new ContextMenuBot(ViewName);
	}
	
	
	/**
	 * Select the SubPackage Inside the Database Resources Package.
	 * Ex. configView.getResources().selectPackageInsideDataBaseResourcePackage("QA");
	 * @param SubPackage
	 * @return
	 * @throws Exception
	 */
	public ContextMenuBot selectPackageInsideDataBaseResourcePackage(String SubPackage) throws Exception
	{   
		
		treeViewBot.selectEntry(ViewName, ApplicationJNDIParentTreeNode,
				EnvironmentName, RESOURCES,DATABASE_RESOURCES,SubPackage);
		return new ContextMenuBot(ViewName);
	}
	/**
	 * get the Context menu object
	 * 
	 * @return
	 */
	public ContextMenuBot getContextManuItem() {
		return new ContextMenuBot(ViewName);
	}
}
