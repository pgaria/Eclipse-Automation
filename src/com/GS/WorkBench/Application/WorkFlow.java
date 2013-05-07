package com.GS.WorkBench.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.swtbot.swt.finder.utils.StringUtils;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;

import com.GS.SWTBot.Helper.Utils.ContextMenuBot;
import com.GS.SWTBot.Helper.Utils.ContextMenuHelper;
import com.GS.SWTBot.Helper.Utils.TreeViewWidgetBot;
import com.GS.Utility.EnvironmentValues;

/**
 * WorkFlow class contains all the methods related to the WorkFlow Folder.
 * 
 * @author pawan garia
 * 
 */
public class WorkFlow {
	private String ApplicationJNDIParentTreeNode = null;
	private String EnvironmentName = null;
	private TreeViewWidgetBot treeViewBot = null;
	private String ViewName = null;

	public WorkFlow(String ViewName) {

		this.ViewName = ViewName;
	}

	private void getRunTimeEnvironmentValues() {
		treeViewBot = new TreeViewWidgetBot();
		ApplicationJNDIParentTreeNode = EnvironmentValues
				.getApplicationJNDIParentTreeNode();
		EnvironmentName = EnvironmentValues.getEnvironmentName();
	}

	/**
	 * Select the WorkFlows Folder From the Tree.
	 * 
	 * @param ViewName
	 * @return
	 * @throws Exception
	 */
	public ContextMenuBot selectWorkFlowsPackage() throws Exception {
		getRunTimeEnvironmentValues();
		treeViewBot.selectEntry(ViewName, ApplicationJNDIParentTreeNode,
				EnvironmentName, "Workflows");
		return new ContextMenuBot(ViewName);
	}

	/**
	 * Select WorkFlow Based on the PackageName and the WorkFlowName
	 * 
	 * @param PackageName
	 * @param WorkFlowName
	 * @return
	 * @throws Exception
	 */
	public ContextMenuBot selectWorkFlow(String PackageName, String WorkFlowName)
			throws Exception {
		getRunTimeEnvironmentValues();
		treeViewBot.selectEntry(ViewName, ApplicationJNDIParentTreeNode,
				EnvironmentName, "Workflows", PackageName, WorkFlowName);
		return new ContextMenuBot(ViewName);
	}

	/**
	 * Select the WorkFlow BAsed on the package it is. PAckageName-.Subpackage
	 * and then The WorkFlow
	 * 
	 * @param PackageName
	 * @param SubPackage
	 * @param WorkFlowName
	 * @return
	 * @throws Exception
	 */
	public ContextMenuBot selectWorkFlow(String PackageName, String SubPackage,
			String WorkFlowName) throws Exception {
		getRunTimeEnvironmentValues();
		treeViewBot.selectEntry(ViewName, ApplicationJNDIParentTreeNode,
				EnvironmentName, "Workflows", PackageName, SubPackage,
				WorkFlowName);
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

	/*
	 * public void selectWorkFlow(String ViewName,String... path ) throws
	 * Exception { TreeViewWidgetBot treeViewBot = new TreeViewWidgetBot();
	 * String ApplicationJNDIParentTreeNode=
	 * EnvironmentValues.getApplicationJNDIParentTreeNode(); String
	 * EnvironmentName= EnvironmentValues.getEnvironmentName();
	 * ArrayList<String> pathList = new ArrayList<String>( Arrays.asList( path )
	 * ); String Path=StringUtils.join(pathList,","); System.out.println(Path);
	 * treeViewBot
	 * .selectEntry(ViewName,ApplicationJNDIParentTreeNode,EnvironmentName
	 * ,"Workflows",Path);
	 * 
	 * }
	 */

	public void runWK() throws Exception {
		SWTBotTree Currenttree = TreeViewWidgetBot
				.getTree("Orchestrator Configuration Explorer");

		System.out.println("Clicked");
		SWTBotTreeItem[] AllItems = Currenttree.getAllItems();
		search: for (SWTBotTreeItem EnvName : AllItems) {
			EnvName.expand();
			System.out.println(EnvName.getText());
			// Getting Environemnts in the APP server
			SWTBotTreeItem[] AllEnvironmentNames = EnvName.getItems();
			System.out.println("Size" + AllEnvironmentNames.length);
			for (SWTBotTreeItem EnvItem : AllEnvironmentNames) {
				EnvItem.expand();
				System.out.println(EnvName.getText());
				EnvItem.expand();
				System.out.println("--Env NAmes--" + EnvItem.getText());
				// Getting all the Folders inside the Env like Workflow
				SWTBotTreeItem[] AllFoldersInside = EnvItem.getItems();
				System.out.println(AllFoldersInside.length);
				for (SWTBotTreeItem folder : AllFoldersInside) { // TRaversing
																	// to all
																	// the
																	// Folders
																	// one by
																	// one
					folder.expand();
					System.out.println("----Folder--" + folder.getText());
					SWTBotTreeItem[] InsideFoldersInside = folder.getItems();
					for (SWTBotTreeItem Insidefolder : InsideFoldersInside) {
						Insidefolder.expand();
						System.out.println("---------Inside---"
								+ Insidefolder.getText());
						SWTBotTreeItem[] ChildFoldersInside = Insidefolder
								.getItems();
						// for(SWTBotTreeItem
						// childInsidefolder:ChildFoldersInside)
						// {
						// childInsidefolder.expand();
						// SWTBotTreeItem[] WorkFlow =
						// childInsidefolder.getItems();
						for (SWTBotTreeItem WorkflowItem : ChildFoldersInside) {
							if (WorkflowItem.getText().equalsIgnoreCase(
									"Standard File Load")) {
								WorkflowItem.select().expand();
								Thread.sleep(5000);
								break search;
							}

						}

					}

				}

			}

		}

	}

	public void RunWorkFlow(String ViewName, String Feature,
			String workflowName, String WorkflowState, String ContextMenuItem)
			throws Exception {
		SWTBotTree Currenttree = TreeViewWidgetBot.getTree(ViewName);

		System.out.println("Clicked");
		SWTBotTreeItem[] OrchestratorConfiENV = Currenttree.getAllItems();
		search: for (SWTBotTreeItem EnvName : OrchestratorConfiENV) {
			EnvName.expand();
			System.out.println(EnvName.getText());
			// Getting Environemnts in the APP server
			SWTBotTreeItem[] AllEnvironmentNames = EnvName.getItems();
			System.out.println("Size" + AllEnvironmentNames.length);
			for (SWTBotTreeItem EnvItem : AllEnvironmentNames) {
				EnvItem.expand();
				System.out.println("--Env NAmes--" + EnvItem.getText());
				// Getting all the Folders inside the Env like Workflow
				SWTBotTreeItem[] AllFoldersInside = EnvItem.getItems();
				System.out.println(AllFoldersInside.length);
				for (SWTBotTreeItem folder : AllFoldersInside) { // TRaversing
																	// to all
																	// the
																	// Folders
																	// one by
																	// one
					folder.expand();
					System.out.println("----Folder--" + folder.getText());
					// opening the FOlders inside Main Folder like Workflow
					SWTBotTreeItem[] InsideFoldersInside = folder.getItems();
					for (SWTBotTreeItem Insidefolder : InsideFoldersInside) {
						Insidefolder.expand();
						System.out.println("---------Inside---"
								+ Insidefolder.getText());
						if (Insidefolder.getText().equalsIgnoreCase(Feature)) {
							Insidefolder.expand();
							// Getting the Workflows Inside Standard folder
							SWTBotTreeItem[] AllWorkFlows = Insidefolder
									.getItems();

							for (SWTBotTreeItem WorkflowItem : AllWorkFlows) {
								if (WorkflowItem.getText().equalsIgnoreCase(
										workflowName)) {
									WorkflowItem.select().expand();
									System.out.println("Clicking Workflow");
									// Below Line is to open the context menu
									// For the WorkFlow and click View
									// WorkflowContextMenu(WorkflowItem,OrchestratorConfiTree,"View");

									// Expanding the Workflow and Getting the
									// Development and Released Version and Its
									// Context Menu
									SWTBotTreeItem[] StatusOfWorkflowITEMS = WorkflowItem
											.getItems();
									for (SWTBotTreeItem WorkflowINState : StatusOfWorkflowITEMS) { // =------------
										System.out.println("WorkFlow state "
												+ WorkflowINState.getText());
										if (WorkflowINState
												.getText()
												.equalsIgnoreCase(WorkflowState)
												&& WorkflowState
														.equalsIgnoreCase("In Development")) {
											// Example :
											// DevelopmentVersionContextMenu("In Development",OrchestratorConfiTree,"View");
											DevelopmentVersionContextMenu(
													WorkflowINState,
													Currenttree,
													ContextMenuItem);
										} else if (WorkflowINState
												.getText()
												.equalsIgnoreCase(WorkflowState)
												&& WorkflowState
														.equalsIgnoreCase("Released")) {
											System.out.println("Released");
											break search;
											// Example :
											// ReleasedVersionContextMenu("Released",OrchestratorConfiTree,"View");
											// ReleasedVersionContextMenu(WorkflowINState,OrchestratorConfiTree,ContextMenuItem);
										}
									}// -----------------------------

									Thread.sleep(3000);
									// FoundItem=true;

								}
							}

						}
					}
				}

			}
		}

	}

	private void WorkflowContextMenu(SWTBotTreeItem WorkflowItem,
			SWTBotTree OrchestratorConfiTree, String ContextMenuOption) {
		WorkflowItem.select();
		ContextMenuHelper.clickContextMenu(OrchestratorConfiTree,
				ContextMenuOption);
	}

	// Select the Development Workflow and Click the Context menu option which
	// is passed
	// TO DO : We can Extend the Released Version for further use related to the
	// specific Version of the workflow
	/**
	 * Method Used to click In Development Context Menu options from the
	 * Workflow Context Menu if the Version is not present for the Development
	 * if the VErsion is present for the development it will open the context
	 * menu for the Version present.
	 */

	private void DevelopmentVersionContextMenu(SWTBotTreeItem WorkflowINState,
			SWTBotTree OrchestratorConfiTree, String ContextMenuOption) {
		SWTBotTreeItem[] InDevelopmentVersionITEMS = WorkflowINState.getItems();
		int RelVErsion = InDevelopmentVersionITEMS.length;

		if (RelVErsion != 0) // If Development Version is Present For the
								// WorkFlow
		{
			for (SWTBotTreeItem WorkflowVersion : InDevelopmentVersionITEMS) {

				WorkflowVersion.select();// Select the First Development Version
				ContextMenuHelper.clickContextMenu(OrchestratorConfiTree,
						ContextMenuOption);// Click the context MEnu OPtion
											// provided by user
			}
		} else {
			WorkflowINState.select();// If NO Development Version Present the
										// Workflow Context Menu Clicked
			ContextMenuHelper.clickContextMenu(OrchestratorConfiTree,
					ContextMenuOption);
		}
	}

	// Select the Released Workflow and Click the Context menu option which is
	// passed
	// TO DO : We can Extend the Released Version for further use related to the
	// specific Version of the workflow
	/**
	 * Method Used to click In In Released Context Menu options from the
	 * Workflow Context Menu if the Version is not present for the Released if
	 * the VErsion is present for the Released it will open the context menu for
	 * the Version present.
	 */
	private void ReleasedVersionContextMenu(SWTBotTreeItem WorkflowINState,
			SWTBotTree OrchestratorConfiTree, String ContextMenuOption) {
		System.out.println("Release MEthod");
		SWTBotTreeItem[] ReleasedVersionITEMS = WorkflowINState.getItems();
		System.out.println(ReleasedVersionITEMS.length);
		int RelVErsion = ReleasedVersionITEMS.length;

		if (RelVErsion != 0) // If Released Version is Present For the WorkFlow
		{
			for (SWTBotTreeItem WorkflowVersion : ReleasedVersionITEMS) {
				System.out.println("Selecting Released VErsion"
						+ WorkflowVersion.getText());
				WorkflowVersion.select();// Select the First Released Version
				// ContextMenuHelper.clickContextMenu(OrchestratorConfiTree,ContextMenuOption);//Click
				// the context MEnu OPtion provided by user
			}
		} else {
			System.out.println("NO Released");
			WorkflowINState.select();// If NO Released Version Present the
										// Workflow Context Menu Clicked
			ContextMenuHelper.clickContextMenu(OrchestratorConfiTree,
					ContextMenuOption);
		}

	}

}
