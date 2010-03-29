package org.robotlegs.plugins.upDown.strategy;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.Presentation;

/**
 * Created by IntelliJ IDEA. User: rasheed Date: 30/03/2010 Time: 7:26:03 AM To change this template use File | Settings
 * | File Templates.
 */
public class UnhandledUpStrategy implements IUpDownStrategy{

	public void update(AnActionEvent event) {
		Presentation presentation = event.getPresentation();

		presentation.setEnabled(false);
		// FIXME resource bundles needed
		presentation.setText("RL Up: None Available");
	}

	public void perform(AnActionEvent event) {
		// does nothing
	}
}
