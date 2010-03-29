package org.robotlegs.plugins.upDown.strategy;

import com.intellij.openapi.actionSystem.AnActionEvent;

/**
 * Created by IntelliJ IDEA. User: rasheed Date: 30/03/2010 Time: 7:02:07 AM To change this template use File | Settings
 * | File Templates.
 */
public interface IUpDownStrategy {
	
	void update(AnActionEvent event);

	void perform(AnActionEvent event);

	

}
