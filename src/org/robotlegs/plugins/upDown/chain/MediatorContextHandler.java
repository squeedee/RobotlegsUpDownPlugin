package org.robotlegs.plugins.upDown.chain;

import com.intellij.lang.javascript.psi.JSFile;
import com.intellij.lang.javascript.psi.ecmal4.JSClass;
import com.intellij.lang.javascript.psi.impl.JSPsiImplUtils;
import com.intellij.lang.javascript.psi.resolve.JSInheritanceUtil;
import com.intellij.lang.javascript.psi.resolve.JSResolveUtil;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataKeys;
import com.intellij.psi.PsiFile;
import com.intellij.psi.search.GlobalSearchScope;
import org.robotlegs.plugins.upDown.strategy.MediatorDownStrategy;
import org.robotlegs.plugins.upDown.strategy.MediatorUpStrategy;

/**
 * Created by IntelliJ IDEA. User: rasheed Date: 30/03/2010 Time: 7:14:16 AM To change this template use File | Settings
 * | File Templates.
 */
public class MediatorContextHandler extends AbstractContextHandler {
	public MediatorContextHandler() {
		upStrategy = new MediatorUpStrategy();
		downStrategy = new MediatorDownStrategy();
	}

	@Override
	public boolean handled(AnActionEvent event) {
		PsiFile file = event.getData(DataKeys.PSI_FILE);

		if (file == null)
			return false;

		if (!(file instanceof JSFile))
			return false;
		
		JSFile castFile = (JSFile) file;

		JSClass fileClass = JSPsiImplUtils.findClass(castFile);

		if (fileClass == null)
			return false;
		
		return isMediator(fileClass);
	}

	// FXIME: Utility
	private static boolean isMediator(JSClass clazz) {
		// Fixme: can locating the mediatorClass be optimised? - On tree update?
		GlobalSearchScope scope = JSResolveUtil.getSearchScope(clazz);
		JSClass mediatorClass = (JSClass) JSResolveUtil.findClassByQName("org.robotlegs.core.IMediator",scope);

		if (mediatorClass == null)
			return false;

		return JSInheritanceUtil.isParentClass(clazz,mediatorClass,true);
	}


}
