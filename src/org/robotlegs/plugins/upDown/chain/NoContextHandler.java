package org.robotlegs.plugins.upDown.chain;

import com.intellij.openapi.actionSystem.AnActionEvent;
import org.robotlegs.plugins.upDown.strategy.UnhandledStrategy;

/**
 * Created by IntelliJ IDEA. User: rasheed Date: 30/03/2010 Time: 7:25:08 AM To change this template use File | Settings
 * | File Templates.
 */
public class NoContextHandler extends AbstractContextHandler {
	public NoContextHandler() {
		// FIXME time to look into GUICE
		// http://code.google.com/p/google-guice/
		strategy = new UnhandledStrategy();
	}

	@Override
	public boolean handled(AnActionEvent event) {
		return true; 
	}
	
	
}