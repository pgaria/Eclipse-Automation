package com.GS.SWTBot.Helper.Utils;

import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;

/**
 * Bot util class have method which are used by teh swtbot as util.
 * 
 * @author pgaria
 * 
 */
public class BotUtils {
	private static SWTBot bot = new SWTBot();

	/**
	 * Wait for the Shell with the Label of the Shell Name.
	 * 
	 * @param runnable
	 * @param labels
	 * @return
	 */
	public static SWTBotShell shell(final Runnable runnable,
			final String... labels) {
		// we expect the error dialog here, so set flag to false
		boolean errorDialogAutomatedMode = ErrorDialog.AUTOMATED_MODE;
		ErrorDialog.AUTOMATED_MODE = false;

		try {
			runnable.run();
			bot.waitUntil(new DefaultCondition() {
				public boolean test() throws Exception {
					String shellText = bot.activeShell().getText();
					System.out.println("Shelll Text" + shellText);
					for (String label : labels) {
						if (shellText.equals(label)
								&& bot.button("Cancel") != null) {
							return true;
						}
					}
					return false;
				}

				public String getFailureMessage() {
					List<String> asList = Arrays.asList(labels);
					return "Expected a dialog with any label " + asList
							+ " with an 'OK' button.";
				}
			});
		} finally {
			// reset flag
			ErrorDialog.AUTOMATED_MODE = errorDialogAutomatedMode;
		}

		return bot.activeShell();
	}

	/**
	 * Waits for a shell with any of the given labels and the Cancel Button in
	 * the Shell.
	 * 
	 * @param labels
	 * @return
	 */
	public static SWTBotShell shellWithLabelText(final Runnable runnable,
			final String labels) {
		// we expect the error dialog here, so set flag to false
		boolean errorDialogAutomatedMode = ErrorDialog.AUTOMATED_MODE;
		ErrorDialog.AUTOMATED_MODE = false;

		try {
			runnable.run();
			bot.waitUntil(new DefaultCondition() {
				public boolean test() throws Exception {
					boolean shellText = bot.label(labels).isVisible();

					if (shellText && bot.button("Cancel") != null) {
						return true;
					}

					return false;
				}

				public String getFailureMessage() {
					List<String> asList = Arrays.asList(labels);
					return "Expected a dialog with any label " + asList
							+ " with an 'Cancel' button.";
				}
			});
		} finally {
			// reset flag
			ErrorDialog.AUTOMATED_MODE = errorDialogAutomatedMode;
		}

		return bot.activeShell();
	}

	public static void sleep(long millis) {
		bot.sleep(millis);
	}

	public static void waitForConnection(final String connectionName,
			final SWTBotTree Currenttree) {
		bot.waitUntil(new DefaultCondition() {
			public boolean test() throws Exception {
				SWTBotTreeItem[] TreeItems = Currenttree.getAllItems();
				for (SWTBotTreeItem item : TreeItems) {

					String text = item.getText();
					if (text.contains(connectionName)) {
						return true;
					}
				}
				return false;
			}

			public String getFailureMessage() {
				return "Connection with" + connectionName
						+ " not visible in view.";
			}
		});
	}
}