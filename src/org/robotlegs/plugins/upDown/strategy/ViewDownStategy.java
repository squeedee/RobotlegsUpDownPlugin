package org.robotlegs.plugins.upDown.strategy;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.Presentation;

/**
 * Created by IntelliJ IDEA. User: rasheed Date: 31/03/2010 Time: 8:15:19 AM To change this template use File | Settings
 * | File Templates.
 */
public class ViewDownStategy implements IUpDownStrategy {
	public void update(AnActionEvent event) {
		Presentation presentation = event.getPresentation();

		presentation.setEnabled(true);
		// FIXME resource bundles needed
		presentation.setText("RL Down: View -> [Mediator|Event|Actor]");
	}

	public void perform(AnActionEvent event) {
		// FIXME  implement
	}
}
