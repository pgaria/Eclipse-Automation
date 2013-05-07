
package com.GS.SWTBot.Helper.Utils;


import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.widgetOfType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable;
import org.eclipse.swtbot.swt.finder.results.VoidResult;
import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.eclipse.swtbot.swt.finder.waits.ICondition;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotButton;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.eclipse.swtbot.swt.finder.widgets.TimeoutException;


/**
 * Helpers for using SWTBot.
 * 
 * @author <a href="mailto:pgaria@thegoldensource.com">CEN Automation Project</a>
 * @version $Rev$, $Date$
 */
public class TreeViewWidgetBot
{
    
	 private static SWTWorkbenchBot bot = new SWTWorkbenchBot();
    /**
     * Get the Tree View of the Particular View.
     * @param ViewTitle
     * @return
     * @throws Exception
     */
	 // "Operations and Monitoring Explorer"
    public static SWTBotTree getTree(String ViewTitle) throws Exception
    {
        SWTBotView view = bot.viewByTitle(ViewTitle );
        view.show();

        Tree tree = ( Tree ) bot.widget( widgetOfType( Tree.class ), view.getWidget() );
        return new SWTBotTree( tree );
    }


     /**
     * Gets the editor tree.
     * 
     * @param bot
     *            the bot
     * 
     * @return the  editor tree
     * 
     * @throws Exception
     *             the exception
     */
    public static SWTBotTree getEditorTree( final SWTWorkbenchBot bot, String title ) throws Exception
    {
        SWTBotEditor editor = bot.editorByTitle( title );
        SWTBotTree tree = editor.bot().tree();
        return tree;
    }


    /**
     * Clicks a button asynchronously and waits till the given condition is
     * fulfilled.
     * 
     * @param bot
     *            the SWT bot
     * @param button
     *            the button to click
     * @param waitCondition
     *            the condition to wait for, may be null
     * 
     * @throws TimeoutException
     */
    public static void asyncClick( final SWTWorkbenchBot bot, final SWTBotButton button, final ICondition waitCondition )
        throws TimeoutException
    {
        bot.waitUntil( new DefaultCondition()
        {
            public boolean test() throws Exception
            {
                return button.isEnabled();
            }


            public String getFailureMessage()
            {
                return "Button isn't enabled.";
            }
        } );

        UIThreadRunnable.asyncExec( bot.getDisplay(), new VoidResult()
        {
            public void run()
            {
                button.click();
            }
        } );

        if ( waitCondition != null )
        {
            bot.waitUntil( waitCondition );
        }
    }


    /**
     * Clicks a menu item asynchronously and waits till the given condition is
     * fulfilled.
     * 
     * @param bot
     *            the SWT bot
     * @param button
     *            the button to click
     * @param waitCondition
     *            the condition to wait for, may be null
     * 
     * @throws TimeoutException
     */
    public static void asyncClick( final SWTWorkbenchBot bot, final SWTBotMenu menu, final ICondition waitCondition )
        throws TimeoutException
    {
        UIThreadRunnable.asyncExec( bot.getDisplay(), new VoidResult()
        {
            public void run()
            {
                menu.click();
            }
        } );

        if ( waitCondition != null )
        {
            bot.waitUntil( waitCondition );
        }
    }


    /**
     * Clicks a tree item asynchronously and waits till the given condition is
     * fulfilled.
     * 
     * @param bot
     *            the SWT bot
     * @param item
     *            the tree item to click
     * @param waitCondition
     *            the condition to wait for, may be null
     * 
     * @throws TimeoutException
     *             the timeout exception
     */
    public static void asyncClick( final SWTWorkbenchBot bot, final SWTBotTreeItem item, final ICondition waitCondition )
        throws TimeoutException
    {
        UIThreadRunnable.asyncExec( bot.getDisplay(), new VoidResult()
        {
            public void run()
            {
                item.click();
            }
        } );

        if ( waitCondition != null )
        {
            bot.waitUntil( waitCondition );
        }
    }

    
    /**
     * Selects an entry in the given tree and optionally expands the selected
     * entry. Takes care that all attributes and child entries are initialized
     * so that there are no pending background actions and event notifications.
     * This is necessary to avoid race conditions.
     * 
     * @param bot
     *            the SWT bot
     * @param tree
     *            the given tree
     * @param expandChild
     *            true to expand the child entry
     * @param path
     *            the path to the entry
     * 
     * @return the selected entry as SWTBotTreeItem
     * 
     * @throws Exception
     *             the exception
     */
    public static SWTBotTreeItem selectEntry( final SWTWorkbenchBot bot, final SWTBotTree tree,
        final boolean expandChild, final String... path )
    {
        List<String> pathList = new ArrayList<String>( Arrays.asList( path ) );
        SWTBotTreeItem entry = null;

        while ( !pathList.isEmpty() )
        {
            String currentPath = pathList.remove( 0 );

            if ( entry == null )
            {
                currentPath = adjustNodeName( tree, currentPath );
                entry = tree.getTreeItem( currentPath );
            }
            else
            {
                // adjust current path, because the label is decorated with the
                // number of children
                currentPath = adjustNodeName( entry, currentPath );
                entry = entry.getNode( currentPath );
            }
            entry.click();

            if ( !pathList.isEmpty() || expandChild )
            {
                // expand entry and wait till
                // - children are displayed
                // - next child is visible
                final String nextName = !pathList.isEmpty() ? pathList.get( 0 ) : null;
                expandEntry( bot, entry, nextName );
            }

            entry.select();
        }
        return entry;
    }


    /**
     * Expands the entry. Takes care that all attributes and child entries are
     * initialized so that there are no pending background actions and event
     * notifications. This is necessary to avoid race conditions.
     * 
     * @param bot
     *            the bot
     * @param entry
     *            the entry to expand
     * @param nextName
     *            the name of the entry that must become visible, may be null
     * 
     * @throws Exception
     *             the exception
     */
    public static void expandEntry( final SWTWorkbenchBot bot, final SWTBotTreeItem entry, final String nextName )
    {
        UIThreadRunnable.asyncExec( bot.getDisplay(), new VoidResult()
        {
            public void run()
            {
                entry.expand();
            }
        } );

        bot.waitUntil( new DefaultCondition()
        {
            public boolean test() throws Exception
            {
                if ( nextName != null )
                {
                    String adjustedNodeName = nextName != null ? adjustNodeName( entry, nextName ) : null;
                    SWTBotTreeItem node = entry.getNode( adjustedNodeName );
                    if ( node == null )
                    {
                        return false;
                    }
                }
                return !entry.getNodes().contains( "Fetching Entries..." );
            }


            public String getFailureMessage()
            {
                return "Could not find entry " + entry.getText() + " -> " + nextName;
            }
        } );
    }


    private static String adjustNodeName( SWTBotTreeItem child, String nodeName )
    {
        List<String> nodes = child.getNodes();
        for ( String node : nodes )
        {
            if ( node.toUpperCase().startsWith( nodeName.toUpperCase() ) )
            {
                return node;
            }
        }
        return null;
    }


    private static String adjustNodeName( SWTBotTree tree, String nodeName )
    {
        SWTBotTreeItem[] allItems = tree.getAllItems();
        for ( SWTBotTreeItem item : allItems )
        {
            String node = item.getText();
            if ( node.toUpperCase().startsWith( nodeName.toUpperCase() ) )
            {
                return node;
            }
        }
        return null;
    }
    
    // Tree View Widget API to Run 
    
    public boolean existsEntry(String ViewTitle, String... path ) throws Exception
    {
        // ensure the parent exists
        String[] parentPath = new String[path.length - 1];
        System.arraycopy( path, 0, parentPath, 0, parentPath.length );
        getEntry(ViewTitle, parentPath );

        // check if the child exists
        try
        {
            getEntry(ViewTitle, path );
            return true;
        }
        catch ( WidgetNotFoundException e )
        {
            return false;
        }
    }

    public static void setectTreeNode(SWTBotTree tree)
    {
    	tree.select(0);
    }
    public void selectEntry( String ViewTitle, String... path ) throws Exception
    {
        SWTBotTreeItem entry = getEntry(ViewTitle, path );
        select( entry );
    }


    public void selectChildrenOfEnty( String[] children,String  ViewTitle,String... path ) throws Exception
    {
        SWTBotTreeItem entry = getEntry(ViewTitle, path );
        entry.select( children );
    }


    /*ReferralDialogBot selectEntryExpectingReferralDialog( String... path )
    {
        SWTBotTreeItem entry = getEntry( path );
        select( entry );
        return new ReferralDialogBot();
    }*/


    public void expandEntry( String ViewTitle, String... path ) throws Exception
    {
        SWTBotTreeItem entry = getEntry(ViewTitle, path );
        expand( entry, true, null );
    }


    public void waitForEntry( String ViewTitle,String... path ) throws Exception
    {
        getEntry( ViewTitle, path );
    }


    /*ReferralDialogBot expandEntryExpectingReferralDialog( String... path )
    {
        SWTBotTreeItem entry = getEntry( path );
        expand( entry, false, null );
        return new ReferralDialogBot();
    }
*/

    private SWTBotTreeItem getEntry(String ViewTitle, String... path ) throws Exception
    {   
    	
        SWTBotTree browserTree = getTree(ViewTitle);
        List<String> pathList = new ArrayList<String>( Arrays.asList( path ) );
        SWTBotTreeItem entry = null;

        while ( !pathList.isEmpty() )
        {
            String node = pathList.remove( 0 );

            if ( entry == null )
            {
                node = adjustNodeName( browserTree, node );
                entry = browserTree.getTreeItem( node );
            }
            else
            {
                // adjust current path, because the label is decorated with the
                // number of children
                node = adjustNodeName( entry, node );
                entry = entry.getNode( node );
            }

            if ( !pathList.isEmpty() )
            {
                // expand entry and wait till
                // - children are displayed
                // - next child is visible
                final String nextNode = !pathList.isEmpty() ? pathList.get( 0 ) : null;
                expand( entry, true, nextNode );
            }
        }

        return entry;
    }


    private void expand( final SWTBotTreeItem entry, boolean wait, final String nextNode )
    {
        UIThreadRunnable.asyncExec( bot.getDisplay(), new VoidResult()
        {
            public void run()
            {
                entry.expand();
            }
        } );

        if ( wait )
        {
            bot.waitUntil( new DefaultCondition()
            {
                public boolean test() throws Exception
                {
                    //                    if ( nextNode != null )
                    //                    {
                    //                        String adjustedNodeName = nextNode != null ? adjustNodeName( entry, nextNode ) : null;
                    //                        SWTBotTreeItem node = entry.getNode( adjustedNodeName );
                    //                        if ( node == null )
                    //                        {
                    //                            return false;
                    //                        }
                    //                    }
                    return !entry.getNodes().contains( "Fetching Entries..." )
                        && !entry.getNodes().contains( "Opening Connection..." );
                }


                public String getFailureMessage()
                {
                    return "Could not find entry " + entry.getText() + " -> " + nextNode;
                }
            } );
        }
    }


    private void select( final SWTBotTreeItem entry )
    {
        if ( !bot.tree().isEnabled() )
        {
            bot.waitUntil( new DefaultCondition()
            {

                public boolean test() throws Exception
                {
                    return bot.tree().isEnabled();
                }


                public String getFailureMessage()
                {
                    return "Entry " + entry + " is not enabled!";
                }
            } );
        }
        //JobWatcher watcher = new JobWatcher( BrowserCoreMessages.jobs__init_entries_title_attonly );
        entry.click();
        entry.select();
        //watcher.waitUntilDone();
    }

    SWTBotTree getTree()
    {
        return bot.tree();
    }

    
    
    
}
