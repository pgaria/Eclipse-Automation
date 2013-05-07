package com.GS.WorkBench.Application;

import com.GS.SWTBot.Helper.Utils.ContextMenuBot;
import com.GS.SWTBot.Helper.Utils.TreeViewWidgetBot;
import com.GS.Utility.EnvironmentValues;
import com.GS.WorkBench.Application.Common.QueriesEditorTAB;

public class Queries {
	private TreeViewWidgetBot treeViewBot = null;
	private String ViewName = null;
	private String ApplicationJNDIParentTreeNode = null;
	private String EnvironmentName = null;
  private String QUERIES="Queries";
	public Queries(String ViewName) {

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
	 * Select the Queries Folder in the Tree.
	 * @return
	 * @throws Exception
	 */
	public ContextMenuBot selectQueriesPackage() throws Exception {
		
		treeViewBot.selectEntry(ViewName, ApplicationJNDIParentTreeNode,
				EnvironmentName, QUERIES);
		return new ContextMenuBot(ViewName);
	}
	/**
	 * Select the File inside the Queries Folder.
	 * Example:-configView.getQueries().selectQueriesFileInsideQueriesPackage("JobStatus");
	 * @param QueryFile
	 * @return
	 * @throws Exception
	 */
    public ContextMenuBot selectQueriesFileInsideQueriesPackage(String QueryFile) throws Exception {
		
		treeViewBot.selectEntry(ViewName, ApplicationJNDIParentTreeNode,
				EnvironmentName, QUERIES,QueryFile);
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
