package com.GS.WorkBench.Application.Common;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEclipseEditor;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotStyledText;

import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.widgetOfType;
import com.GS.SWTBot.Helper.Utils.WizardBot;
import com.GS.WorkBench.Application.Dialogs.SaveQueryParametersDialog;



public class QueriesEditorTAB extends WizardBot{
	private String QUERT_TEXT_TAB="Query text";
	private String PROPRTIES_TAB="Properties";
	/**
	 * Close the Tab Selected.
	 * Example;-  queryTab.closeTABwithOutSavingQueryFile("JobStatus");
	 */
	public void closeTABwithOutSavingQueryFile(String TABvalue)
	{   
		
		super.closeTABwithOutSavingFile(TABvalue);
	}
	/**
	 * Close the Tab Selected with Saving the Query and SaveQueryParameter Dialog opened.
	 * Example;-  queryTab. closeTABwithSavingQueryFile("JobStatus");
	 * @return
	 */
	public SaveQueryParametersDialog closeTABwithSavingQueryFile(String TABvalue)
	{   
		
		super.closeTABwithSavingFile(TABvalue);
		return new SaveQueryParametersDialog();
	}
	/**
	 * Click Query Text Tab for the Query File
	 */
	public void clickQueryTextCTab()
	{
		super.clicknewCTab(QUERT_TEXT_TAB);
	}
	/**
	 * Click Property TAB in the Query File
	 */
	public void clickPropertyCTab()
	{
		super.clicknewCTab(PROPRTIES_TAB);
	}
	
	/*public void EnterText() throws InterruptedException
	{
		bot.text(0).setText("TestQuery");
		Thread.sleep(4000);
	}*/
	/**
	 * Set The Text in the Query Editor
	 * @param QueryText
	 * @throws InterruptedException
	 */
	public void EnterQueryText(String QueryText)
	{
		super.EnterTextinStyledText(QueryText);
     	
	}
}
