package com.GS.SWTBot.Wizard;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotCombo;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.widgetOfType;
import org.eclipse.jface.bindings.keys.KeyStroke;

import com.GS.SWTBot.Helper.Utils.WizardBot;

/**
 * Run workflow dialog class.
 * 
 * @author Pawan garia
 * 
 */
public class RunWorkFlowDialogBot extends WizardBot {
	private SWTWorkbenchBot bot = new SWTWorkbenchBot();
	private int Column_NAME = 1;
	private int COLUMN_DATATYPE = 2;
	private int COLUMN_TYPE = 3;
	private int COLUMN_INFO = 4;
	private int Column_Value = 5;
	private int COLUMN_DESCRIPTION = 6;

	/**
	 * Enter the Value for the Particular name in the Run Workflow Dialog
	 * 
	 * @param Name
	 * @param Value
	 */
	protected void EnterValusInCell(String Name, String Value) {
		SWTBotTreeItem[] items = bot.tree().getAllItems();
		for (SWTBotTreeItem item : items) {
			if (item.select().cell(Column_NAME).toString().equals(Name)) {

				item.click(Column_Value);

				Text widget = bot.widget(widgetOfType(Text.class));
				SWTBotText text = new SWTBotText(widget, null);
				text.setText(Value); // set the text
				text.pressShortcut(KeyStroke.getInstance(SWT.LF));
				break;
			}
		}
	}

	public void SelectValusInCellFromDropDown(String Name, String Value) {
		SWTBotTreeItem[] items = bot.tree().getAllItems();
		for (SWTBotTreeItem item : items) {
			if (item.select().cell(Column_NAME).toString().equals(Name)) {
				item.click(Column_Value).widget.setText(1, "DELETE");
				System.out.println("NAMEEEE"
						+ item.click(Column_Value).getText());
				item.click(Column_Value).select("DELETE");

				// Combo combo = bot.widget(widgetOfType(Combo.class));
				// SWTBotCombo combobox = new SWTBotCombo(combo, null);
				// combobox.setSelection(Value); // set the text
				// combobox.pressShortcut(KeyStroke.getInstance(SWT.LF));
				break;
			}
		}
	}
}
