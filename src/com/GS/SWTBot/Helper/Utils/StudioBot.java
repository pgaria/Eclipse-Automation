
package com.GS.SWTBot.Helper.Utils;


import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable;
import org.eclipse.swtbot.swt.finder.results.VoidResult;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * 
 * @author Pawan garia
 *
 */
public class StudioBot
{   
	private SWTWorkbenchBot bot;
   /* To do ........
    * public InstallationCenterBot getInstallationCenterView()
    {
        return new InstallationCenterBot();
    }
    
    To Do............
    public OperationsAndMonitoringBot getOperationsAndMonitoringView()
    {
        return new OperationsAndMonitoringBot();
    }*/


    /*public EntryEditorBot getEntryEditorBot( String title )
    {
        return new EntryEditorBot( title );
    }*/

    /**
     * Check if the Prespective is opened or not.
     * @param PrespectiveTitle
     * @return
     */
    private boolean isPrespectiveActive(String PrespectiveTitle)
    {
    	bot = new SWTWorkbenchBot();
    	String Currentprespective = bot.activePerspective().getLabel();
    	if(Currentprespective.equalsIgnoreCase(PrespectiveTitle))
    	return true;
    	else 
    	return false;
    }
    /**
     * Open and Activate the Prespective
     * @param PrespectiveName
     */
    public void ActivatePrespective(String PrespectiveName)
	{   
    	if(!isPrespectiveActive(PrespectiveName))
		{
    	 bot.perspectiveByLabel(PrespectiveName).activate();
    	
		}
		
	}
   
    /**
     * Open the Preferences Window.
     * @return
     */
    public PreferencesBot openPreferences()
    {   
    	//if(!new PreferencesBot().isVisible())
       // {
    	new SWTBot().menu( "Window" ).menu( "Preferences" ).click();
       // }
       	return new PreferencesBot();
    }

    /**
     * Set Fouse on the View
     * @return
     */
    public void SetFouseOnView(String ViewTitle)
    {   
    	bot.viewByTitle(ViewTitle).setFocus();
    }
  

}
