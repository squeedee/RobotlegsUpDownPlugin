package org.robotlegs.plugins.upDown.chain;

import com.intellij.lang.javascript.psi.JSFile;
import com.intellij.lang.javascript.psi.resolve.JSResolveUtil;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataKeys;
import com.intellij.psi.PsiElement;
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

		return isMediator(castFile);
	}
	
	public static boolean isMediator(JSFile file) {
		GlobalSearchScope scope = JSResolveUtil.getSearchScope(file);
		PsiElement clazz = JSResolveUtil.findClassByQName("OtherClass",scope);
		//PsiElement clazz = JSResolveUtil.findClassByQName("org.robotlegs.base.MediatorBase",scope);

		return clazz != null;
	}


}
