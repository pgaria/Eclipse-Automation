
package com.GS.SWTBot.Helper.Utils;

import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.widgetOfType;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotStyledText;

import com.GS.WorkBench.Application.Dialogs.SaveQueryParametersDialog;

/**
 * 
 * @author Pawan garia
 *
 */
public abstract class WizardBot extends DialogBot
{

    public boolean isBackButtonEnabled()
    {
        return isButtonEnabled( "< Back" );
    }


    public boolean isNextButtonEnabled()
    {
        return isButtonEnabled( "Next >" );
    }


    public boolean isFinishButtonEnabled()
    {
        return isButtonEnabled( "Finish" );
    }


    public boolean isCancelButtonEnabled()
    {
        return isButtonEnabled( "Cancel" );
    }
    
    public boolean isAddButtonEnabled()
    {
        return isButtonEnabled( "Add" );
    }
    
    public boolean isApplyButtonEnabled()
    {
        return isButtonEnabled( "Apply" );
    }
    
    public boolean isRemoveButtonEnabled()
    {
        return isButtonEnabled( "Remove" );
    }
    
    public boolean isEditButtonEnabled()
    {
        return isButtonEnabled( "Edit" );
    }
   
    public boolean isRestoreDefaultsButtonEnabled()
    {
        return isButtonEnabled( "Restore Defaults" );
    }
    public boolean isOKButtonEnabled()
    {
        return isButtonEnabled( "OK" );
    }
    
    protected boolean isButtonEnabled( String buttonTitle )
    {
        return bot.button( buttonTitle ).isEnabled();
    }
    protected boolean isNOButtonEnabled( String buttonTitle )
    {
        return bot.button( buttonTitle ).isEnabled();
    }

    public void clickBackButton()
    {
        clickButton( "< Back" );
    }


    public void clickNextButton()
    {
        clickButton( "Next >" );
    }


    public void clickFinishButton()
    {
        clickButton( "Finish" );
    }


    public void clickCancelButton()
    {
        clickButton( "Cancel" );
    }
    
    public void clickAddButton()
    {
        clickButton( "Add" );
    }
    
    public void clickEditButton()
    {
        clickButton( "Edit" );
    }
    
    public void clickRemoveButton()
    {
        clickButton( "Remove" );
    }
    
    public void clickApplyButton()
    {
        super.clickButton( "Apply" );
    }


    public void clickRestoreDefaultsButton()
    {
        super.clickButton( "Restore Defaults" );
    }
    
    public void clickOKButton()
    {
        super.clickButton( "OK" );
    }
    public void clickYesButton()
    {
        super.clickButton( "Yes" );
    }
    public void clickNoButton()
    {  
    	
        super.clickButton( "No" );
        
    	
    }
    
    public void closeTABwithOutSavingFile(String TABname)
    {
    	bot.cTabItem(TABname).close();
    	if(super.isVisible("Save Resource"))
    	{
		clickNoButton();}	
    }
    public void closeTABwithSavingFile(String TABname)
    {
    	bot.cTabItem(TABname).close();
    	if(super.isVisible("Save Resource"))
    	{
    		clickYesButton();}	
    }
    
    public void clicknewCTab(String TABname) 
	{
		bot.cTabItem(TABname).activate();
		
	}
    public void EnterTextinStyledText(String Text)
    {
    	StyledText widget = bot.widget(widgetOfType(StyledText.class));
     	SWTBotStyledText text = new SWTBotStyledText(widget, null);
     	text.setText(Text); // set the text
    }
}
