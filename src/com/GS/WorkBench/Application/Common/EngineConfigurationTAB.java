package com.GS.WorkBench.Application.Common;

import com.GS.SWTBot.Helper.Utils.WizardBot;

public class EngineConfigurationTAB extends WizardBot{
	
	private String REFERENCE_ENGINE_CONFIGURATION="Reference Engine Configuration";
	private String OVERVIEW="Overview";
	private String POSITION_ENGINE_CONFIGURATION="Positions Engine Configuration";
	private String TASK_DIRECTOR_CONFIGURATION="Task Director Configuration";
	private String CUSTOM_CONFIGURATION_VALUE="Custom Configuration Values";
	/**
	 * Click the Reference Engine Configuration Tab in the Engine Configuration Page.
	 */
	public void clickReferenceEngineConfigurationCTab()
	{
		super.clicknewCTab(REFERENCE_ENGINE_CONFIGURATION);
	}
	/**
	 * Click the Overview Tab in the Engine Configuration Page.
	 */
	public void clickOverviewCTab()
	{
		super.clicknewCTab(OVERVIEW);
	}
	/**
	 * Click the Positions Engine Configuration Tab in the Engine Configuration Page.
	 */
	public void clickPositionsEngineConfigurationCTab()
	{
		super.clicknewCTab(POSITION_ENGINE_CONFIGURATION);
	}
	/**
	 * Click the Task Director Configuration Tab in the Engine Configuration Page.
	 */
	public void clickTaskDirectorConfigurationCTab()
	{
		super.clicknewCTab(TASK_DIRECTOR_CONFIGURATION);
	}
	/**
	 * Click the Custom Configuration Values Tab in the Engine Configuration Page.
	 */
	public void clickCustomConfigurationValuesCTab()
	{
		super.clicknewCTab(CUSTOM_CONFIGURATION_VALUE);
	}
	

}
