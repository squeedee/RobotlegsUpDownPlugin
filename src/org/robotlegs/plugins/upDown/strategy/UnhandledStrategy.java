package org.robotlegs.plugins.upDown.strategy;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.Presentation;

/**
 * Created by IntelliJ IDEA. User: rasheed Date: 30/03/2010 Time: 7:26:03 AM To change this template use File | Settings
 * | File Templates.
 */
public class UnhandledStrategy implements IUpDownStrategy{
	public void upPresentation(AnActionEvent event) {
		Presentation presentation = event.getPresentation();

		presentation.setEnabled(false);
		// FIXME resource bundles needed
		presentation.setText("RL Up: None Available");

	}

	public void downPresentation(AnActionEvent event) {
		Presentation presentation = event.getPresentation();

		presentation.setEnabled(false);
		// FIXME resource bundles needed
		presentation.setText("RL Down: None Available");
	}

	public void doUp(AnActionEvent event) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	public void doDown(AnActionEvent event) {
		//To change body of implemented methods use File | Settings | File Templates.
	}
}
