package org.robotlegs.plugins.upDown.strategy;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.Presentation;

/**
 * Created by IntelliJ IDEA. User: rasheed Date: 30/03/2010 Time: 11:11:25 AM To change this template use File |
 * Settings | File Templates.
 */
public class MediatorDownStrategy implements IUpDownStrategy {

	public void update(AnActionEvent event) {
		Presentation presentation = event.getPresentation();

		presentation.setEnabled(true);
		// FIXME resource bundles needed
		presentation.setText("RL Down: Mediator -> [Event|Actor]");
	}

	public void perform(AnActionEvent event) {
		// TODO
	}
}
