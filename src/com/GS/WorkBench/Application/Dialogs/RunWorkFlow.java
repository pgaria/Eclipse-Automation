package com.GS.WorkBench.Application.Dialogs;

import com.GS.SWTBot.Helper.Utils.SWTBotCommonActionBot;
import com.GS.SWTBot.Wizard.RunWorkFlowDialogBot;

/**
 * Run WorkFlow Class To do all the actions on the Runworkflow dialog.
 * 
 * @author Pawan garia
 * 
 */
public class RunWorkFlow extends RunWorkFlowDialogBot {
	SWTBotCommonActionBot commonAction = new SWTBotCommonActionBot();
	private String FILE = "File";
	private String MESSAGE_TYPE = "MessageType";
	private String EXECUTE_ASYNCHRONOUSLY = "Execute Asynchronously?";
	private String PERSIST_ALL_VARIABLES = "Persist All Variables?";
	private String DEVELOPMENT_MODE = "Development Mode?";
	private String SWITCH_TO_ORCHESTRATOR_TRACING = "Switch to Orchestrator Tracing Perspective";
    
	/**
	 * Enter File Name for the Standard File Load, or Any File load.
	 * Example -: runWorkflow.EnterFileName("db://resource/QA/StandardMessageFile.txt");
	 * @param Value
	 */
	public void EnterFileName(String Value) {
		EnterValusInCell(FILE, Value);
	}
	/**
	 * Enter Message Type for the Standard File Load, or Any File load.
	 * Example -: runWorkflow.EnterMessageType("BBGlobalEquity");
	 * @param Value
	 */
	public void EnterMessageType(String Value) {
		EnterValusInCell(MESSAGE_TYPE, Value);
	}
    /**
     * Enter Values for Any parameter with the Name in the Run WorkFlow Dialog.Provide NAme and Value Both.
     * Example-: runWorkflow.EnterValueForName("File","db://resource/QA/StandardMessageFile.txt");
     * @param Name
     * @param Value
     */
	public void EnterValueForName(String Name, String Value) {
		EnterValusInCell(Name, Value);
	}

	public void ClickExecuteAsynchronously() {
		commonAction.selectCheckBox(EXECUTE_ASYNCHRONOUSLY);
	}

	public void ClickPersistAllVariables() {
		commonAction.selectCheckBox(PERSIST_ALL_VARIABLES);
	}

	public void ClickDevelopmentMode() {
		commonAction.selectCheckBox(DEVELOPMENT_MODE);
	}

	public void ClickSwitchToOrchestratorTracing() {
		commonAction.selectCheckBox(SWITCH_TO_ORCHESTRATOR_TRACING);
	}
}
