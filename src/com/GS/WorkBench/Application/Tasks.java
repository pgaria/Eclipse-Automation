package com.GS.WorkBench.Application;

import com.GS.SWTBot.Helper.Utils.ContextMenuBot;
import com.GS.SWTBot.Helper.Utils.TreeViewWidgetBot;
import com.GS.Utility.EnvironmentValues;
/**
 *  Tasks Class object have all the Api related to the Task Node in the Tree Item
 * @author Pawan garia
 *
 */
public class Tasks {
	private String ApplicationJNDIParentTreeNode = null;
	private String EnvironmentName = null;
	private TreeViewWidgetBot treeViewBot = null;
	private String ViewName = null;
	

	public Tasks(String ViewName) {

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
	 * get the Context menu object
	 * 
	 * @return
	 */
	public ContextMenuBot getContextManuItem() {
		return new ContextMenuBot(ViewName);
	}
}
