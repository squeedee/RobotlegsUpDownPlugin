package org.robotlegs.plugins.upDown.chain;

import com.intellij.openapi.actionSystem.AnActionEvent;
import org.robotlegs.plugins.upDown.strategy.IUpDownStrategy;

/**
 * Created by IntelliJ IDEA. User: rasheed Date: 30/03/2010 Time: 7:13:44 AM To change this template use File | Settings
 * | File Templates.
 */
public abstract class AbstractContextHandler {

	public IUpDownStrategy handle(AnActionEvent event) {
		if (handled(event))
			return strategy;

		return next(event);
	}


	public abstract boolean handled(AnActionEvent event);

	private IUpDownStrategy next(AnActionEvent event) {
		if (next_handler == null)
			throw new Error("No handler found.");

		return next_handler.handle(event);

	}

	public void add(AbstractContextHandler handler) {
		if (next_handler == null) {
			next_handler = handler;
			return;
		}

		next_handler.add(handler);
	}

	private AbstractContextHandler next_handler;


	@Override
	protected void finalize() throws Throwable {
		next_handler = null;
		super.finalize();
	}

	protected IUpDownStrategy strategy;

}
