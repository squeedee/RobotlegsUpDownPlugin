package org.robotlegs.plugins.upDown;

import com.intellij.openapi.actionSystem.AnActionEvent;
import org.robotlegs.plugins.upDown.strategy.IUpDownStrategy;


/**
 * Created by IntelliJ IDEA. User: rasheed Date: 30/03/2010 Time: 6:36:40 AM To change this template use File | Settings
 * | File Templates.
 */
public class DownAction extends AbstractUpDownAction {

	@Override
	public void update(AnActionEvent e) {
		super.update(e);
		IUpDownStrategy strategy = upDownComponent().getStrategy(e);
		strategy.downPresentation(e);
	}

	@Override
	public void actionPerformed(AnActionEvent e) {

	}
}
