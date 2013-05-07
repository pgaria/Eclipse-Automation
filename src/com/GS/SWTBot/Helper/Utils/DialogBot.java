
package com.GS.SWTBot.Helper.Utils;


import java.awt.AWTException;
import java.awt.Robot;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.waits.ICondition;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotButton;

/**
 * 
 * @author Pawan garia
 *
 */
public abstract class DialogBot
{

    protected SWTWorkbenchBot bot = new SWTWorkbenchBot();
   

    protected boolean isVisible( String dialogTitle )
    {   boolean isVisible=false;
    	try{
    	bot.shell(dialogTitle).activate();
    	isVisible = bot.shell( dialogTitle ).isVisible();
        return  isVisible;
    	} catch(Throwable t)
    	{  t=null;
    		//Do Nothing Just return False, as the Dialog is not displayed.
    		return false;
    	}
    }
    /**
     * Click Enter Button using the Robot class
     * @throws Exception
     */
    public void clickEnterButton() throws Exception
    {   
    	Robot key = new Robot(); 
    	key.keyPress(java.awt.event.KeyEvent.VK_ENTER);
    }
    /**
     * Click  Button.
     * @param buttonTitle
     */
    protected void clickButton( final String buttonTitle )
    {
        final SWTBotButton button = bot.button( buttonTitle );
        if ( !button.isEnabled() )
        {
            bot.waitUntil( new ICondition()
            {

                public boolean test() throws Exception
                {
                    return button.isEnabled();
                }


                public void init( SWTBot bot )
                {
                }


                public String getFailureMessage()
                {
                    return "Button " + buttonTitle + " is not enabled!";
                }
            } );
        }
        button.click();
    }

}
