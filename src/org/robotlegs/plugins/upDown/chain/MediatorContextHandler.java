package org.robotlegs.plugins.upDown.chain;

import com.intellij.openapi.actionSystem.AnActionEvent;

/**
 * Created by IntelliJ IDEA. User: rasheed Date: 30/03/2010 Time: 7:14:16 AM To change this template use File | Settings
 * | File Templates.
 */
public class MediatorContextHandler extends AbstractContextHandler {
	public MediatorContextHandler() {
		strategy = null; 
	}

	@Override
	public boolean handled(AnActionEvent event) {
		return false;
	}
}
