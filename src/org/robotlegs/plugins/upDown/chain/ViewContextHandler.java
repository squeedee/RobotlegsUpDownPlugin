package org.robotlegs.plugins.upDown.chain;

import com.intellij.lang.javascript.psi.ecmal4.JSClass;
import com.intellij.lang.javascript.psi.resolve.JSInheritanceUtil;
import com.intellij.lang.javascript.psi.resolve.JSResolveUtil;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.psi.search.GlobalSearchScope;
import org.robotlegs.plugins.upDown.strategy.NullUpStrategy;
import org.robotlegs.plugins.upDown.strategy.ViewDownStategy;
import org.robotlegs.plugins.util.JSFileUtil;

/**
 * Created by IntelliJ IDEA. User: rasheed Date: 31/03/2010 Time: 8:14:16 AM To change this template use File | Settings
 * | File Templates.
 */
public class ViewContextHandler extends AbstractContextHandler {

	public ViewContextHandler() {
		upStrategy = new NullUpStrategy();
		downStrategy = new ViewDownStategy();

	}

	@Override
	public boolean handled(AnActionEvent event) {

		JSClass fileClass = JSFileUtil.getJSClass(event);

		if (fileClass == null)
			return false;

		return isView(fileClass);

	}

	// FIXME Utility
	private static boolean isView(JSClass clazz) {
		// Fixme: can locating the viewClass be optimised? - On tree update?
		GlobalSearchScope scope = JSResolveUtil.getSearchScope(clazz);
		JSClass viewClass = (JSClass) JSResolveUtil.findClassByQName("flash.display.DisplayObject",scope);

		if (viewClass == null)
			return false;

		return JSInheritanceUtil.isParentClass(clazz, viewClass,true);
	}


}
