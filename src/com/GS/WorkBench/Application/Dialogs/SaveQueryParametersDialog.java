package com.GS.WorkBench.Application.Dialogs;

import com.GS.SWTBot.Helper.Utils.DialogBot;
import com.GS.SWTBot.Helper.Utils.SWTBotCommonActionBot;

public class SaveQueryParametersDialog {
	
	private static String DATABASE_CONNECTION="Database connection";
	
	
	/**
	 * Save Query Parameters Dialog for the Query Definition and we can change parameters here.
	 * Example:-queryTab.closeTABwithSavingQueryFile("*New Query Definition").selectDatbaseConnection("jdbc/GSDM-1");
		        queryTab.clickOKButton();
	 * @param Connection
	 */
	public void selectDatbaseConnection(String Connection)
	{
		new SWTBotCommonActionBot().selectValueInComboBox(DATABASE_CONNECTION, Connection);
	}
    
}
