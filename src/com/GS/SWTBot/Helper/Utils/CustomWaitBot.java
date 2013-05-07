package com.GS.SWTBot.Helper.Utils;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.TimeoutException;

/**
 * Custom wait class waits for the Shell to be displayed
 * 
 * @author pawan garia
 * 
 */
public class CustomWaitBot {
	private static SWTWorkbenchBot bot = new SWTWorkbenchBot();

	/**
	 * Wait for the Dialog to be appear with the Text with Label in the Dialog.
	 * Title of the Dialog is also Verified in the Wait. Dialog Should Contains
	 * the Title.
	 * 
	 * @param LabelInDialogVisible
	 * @param DialogTitle
	 * @throws Exception
	 */
	public static void waitForDialogWithLabelandTitle(
			final String LabelInDialogVisible, String DialogTitle)
			throws Exception {
		SWTBotShell shell = BotUtils.shell(new Runnable() {
			public void run() {
				bot.label(LabelInDialogVisible).isVisible();
			}
		}, DialogTitle);
	}

	/**
	 * Wait for the Dialog to be appear with the Text with Label in the Dialog.
	 * Method should be used for the Dialogs with no Title.
	 * 
	 * @param LabelInDialogVisible
	 * @throws Exception
	 */
	public static void waitForDialogWithLabelText(
			final String LabelInDialogVisible) throws Exception {
		SWTBotShell shell = BotUtils.shellWithLabelText(new Runnable() {
			public void run() {
				bot.label(LabelInDialogVisible).isVisible();
			}
		}, LabelInDialogVisible);
	}

	/**
	 * Wait until shell 'shellTitle' opens.
	 * 
	 * @param shellTitle
	 */
	public static void waitUntilShellIsActive(String shellTitle) {
		try {
			bot.waitUntil(Conditions.shellIsActive(shellTitle));
		} catch (TimeoutException e) {
			/*
			 * This is empty on purpose. It catches 'TimeoutException: The shell
			 * Eclipse RCP did not activate' thrown unnecessarily by method
			 * waitUntil
			 */
		}
	}

	/**
	 * Wait until shell 'shellTitle' closes. First checks for the shell is
	 * displayed or not.Do nothing if it does not exist anymore.
	 * 
	 * @param shellTilte
	 */
	public static void waitUntilShellCloses(String shellTilte) {
		try {
			if (isShellWithTitleDisplayed(shellTilte)) {
				bot.waitUntil(Conditions.shellCloses(bot.shell(shellTilte)));
			}
		} catch (WidgetNotFoundException e) {
			/*
			 * Method waitUntilShellCloses(String shellTitle) throws
			 * WidgetNotFoundException if window 'shellTitle' shut down itself
			 * after the operation has finished
			 */
		}
	}

	/**
	 * Checks for the shell is displayed or not.
	 * 
	 * @param shellTilte
	 * @return
	 */
	private static boolean isShellWithTitleDisplayed(String shellTilte) {
		String activeshell = bot.activeShell().getText();
		if (shellTilte.equalsIgnoreCase(activeshell)) {
			return true;
		}
		return false;
	}

	/**
	 * Wait for the Shell having the Expected Text in the Dialog shell.
	 * 
	 * @param bot
	 * @param ExpectedText
	 * @throws Exception
	 */
	private static void waitForTextInNewShellWindow(SWTWorkbenchBot bot,
			String ExpectedText) throws Exception {
		System.out.println("In waitfor Method");
		boolean visible = bot.shell(ExpectedText).isVisible();
		System.out.println(visible);
		while (!visible) {
			System.out.println("Waiting for the Shell");
			Thread.sleep(1000);
		}
	}
}
