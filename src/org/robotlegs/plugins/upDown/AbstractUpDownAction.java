package org.robotlegs.plugins.upDown;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.application.ApplicationManager;

/**
 * Created by IntelliJ IDEA. User: rasheed Date: 30/03/2010 Time: 8:25:24 AM To change this template use File | Settings
 * | File Templates.
 */
public abstract class AbstractUpDownAction extends AnAction {
	protected UpDownComponent upDownComponent() {
		return ApplicationManager.getApplication().getComponent(UpDownComponent.class);
	}
}
