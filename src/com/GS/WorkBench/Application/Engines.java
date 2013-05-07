package com.GS.WorkBench.Application;

import com.GS.SWTBot.Helper.Utils.ContextMenuBot;
import com.GS.SWTBot.Helper.Utils.TreeViewWidgetBot;
import com.GS.Utility.EnvironmentValues;
/**
 * Engine Class Object Contains all the API related to the Engine Node in the Tree.
 * @author pawan garia
 *
 */
public class Engines {
	private String ApplicationJNDIParentTreeNode = null;
	private String EnvironmentName = null;
	private TreeViewWidgetBot treeViewBot = null;
	private String ViewName = null;
	private String ENGINES="Engines";
	private String TPS_1="TPS-1";
	private String TPS_UI="TPS-UI";
	private String TPS_VDDB="TPS-VDDB";

	public Engines(String ViewName) {

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
	 * Select the Engines Node in the Tree. 
	 * Example:- configView.getEngines().selectEnginesNode();
	 * @return
	 * @throws Exception
	 */
	public ContextMenuBot selectEnginesNode() throws Exception
	{
		treeViewBot.selectEntry(ViewName, ApplicationJNDIParentTreeNode,
				EnvironmentName, ENGINES);
		return new ContextMenuBot(ViewName);
	}
	/**
	 * Select the TPS_1 Engine in side the Engines Node.
	 * Example :- configView.getEngines().selectEnginesTPS_1();
	 * @return
	 * @throws Exception
	 */
	public ContextMenuBot selectEnginesTPS_1() throws Exception
	{
		treeViewBot.selectEntry(ViewName, ApplicationJNDIParentTreeNode,
				EnvironmentName, ENGINES,TPS_1);
		return new ContextMenuBot(ViewName);
	}
	/**
	 * Select the TPS_UI Engine in side the Engines Node.
	 * Example: - configView.getEngines().selectEnginesTPS_UI();
	 * @return
	 * @throws Exception
	 */
	public ContextMenuBot selectEnginesTPS_UI() throws Exception
	{
		treeViewBot.selectEntry(ViewName, ApplicationJNDIParentTreeNode,
				EnvironmentName, ENGINES,TPS_UI);
		return new ContextMenuBot(ViewName);
	}
	/**
	 * Select the TPS_VDDB Engine in side the Engines Node.
	 * Example: - configView.getEngines().selectEnginesTPS_VDDB();
	 * @return
	 * @throws Exception
	 */
	public ContextMenuBot selectEnginesTPS_VDDB() throws Exception
	{
		treeViewBot.selectEntry(ViewName, ApplicationJNDIParentTreeNode,
				EnvironmentName, ENGINES,TPS_VDDB);
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
