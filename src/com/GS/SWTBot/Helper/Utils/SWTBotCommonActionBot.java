
package com.GS.SWTBot.Helper.Utils;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotButton;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotCheckBox;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotCombo;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
/**
 * 
 * @author pawan garia
 * SWTBotCommonAction Class is having the Common Methods which are used by the SWtbot.
 * Like Entering text, clear text, select values from Combobox.
 *
 */
public class SWTBotCommonActionBot {
	
	SWTWorkbenchBot bot = new SWTWorkbenchBot();
	
	
	/**
	 * Enter Text in the Textbox.
	 * @param TextBoxName
	 * @param text
	 */
	public void EnterText(String TextBoxName,String text)
	{
		 final SWTBotText textbox = bot.textWithLabel(TextBoxName); 
		 textbox.setText(text);
	}
	/**
	 * Select a value from the comboBox.
	 * @param comboBoxName
	 * @param ValueToSelect
	 */
	public void selectValueInComboBox(String comboBoxName,String ValueToSelect)
	{   
		final SWTBotCombo combobox = bot.comboBoxWithLabel(comboBoxName);
		combobox.setSelection(ValueToSelect);
	}
	
	/**
	 * To Do --
	 * @param TextBoxName
	 */
	private void ClearText(String TextBoxName)
	{
		 final SWTBotText textbox = bot.text(TextBoxName);
		 
	}
	/**
	 * Select Check Box if the CheckBox is not selected, if already selected do nothing. 
	 * @param CheckBoxTitle
	 */
	public void selectCheckBox(String CheckBoxTitle)
	{
		final SWTBotCheckBox checkbox = bot.checkBox(CheckBoxTitle );
		if(!isCheckBoxSelected(checkbox))
		{
			checkbox.click();
		}
	}
	/**
	 * Uncheck Check Box if the CheckBox is Already Selected, if Not do nothing.
	 * @param CheckBoxTitle
	 */
	public void UncheckCheckBox(String CheckBoxTitle)
	{
		final SWTBotCheckBox checkbox = bot.checkBox(CheckBoxTitle );
		if(isCheckBoxSelected(checkbox))
		{
			checkbox.click();
		}
	}
	/**
	 * Get the Text of the TextBox.
	 * @param TextBox
	 * @return
	 */
	public String getTextFromTextBox(String TextBoxName)
	{
		 final SWTBotText textbox = bot.text(TextBoxName);
		 return textbox.getText();
	}
    /**
     * Check if the Check box is selected or Not ?
     * If CheckBox is not checked Return False and if checked Return True. 
     * @param CheckBoxTitle
     * @return
     */
	public boolean isCheckBoxSelected(SWTBotCheckBox checkbox)
	{   
		   if ( checkbox.isChecked())
		    return true;
	        else
	        	return false;
	}
}
