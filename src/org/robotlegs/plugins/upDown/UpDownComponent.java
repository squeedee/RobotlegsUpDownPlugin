package org.robotlegs.plugins.upDown;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.components.ApplicationComponent;
import org.jetbrains.annotations.NotNull;
import org.robotlegs.plugins.upDown.chain.AbstractContextHandler;
import org.robotlegs.plugins.upDown.chain.MediatorContextHandler;
import org.robotlegs.plugins.upDown.chain.NoContextHandler;
import org.robotlegs.plugins.upDown.strategy.IUpDownStrategy;

/**
 * Created by IntelliJ IDEA. User: rasheed Date: 30/03/2010 Time: 7:31:24 AM To change this template use File | Settings
 * | File Templates.
 */
public class UpDownComponent implements ApplicationComponent {
	public UpDownComponent() {
	}

	private AbstractContextHandler chain;

	public void initComponent() {
		chain = new MediatorContextHandler();
		chain.add(new NoContextHandler());
	}

	public IUpDownStrategy getUpStrategy(AnActionEvent event) {
		return chain.handleUp(event);
	}

	public IUpDownStrategy getDownStrategy(AnActionEvent event) {
		return chain.handleDown(event);
	}


	public void disposeComponent() {
		chain = null;
	}

	@NotNull
	public String getComponentName() {
		return "UpDownComponent";
	}
}
