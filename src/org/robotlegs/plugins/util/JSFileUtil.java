package org.robotlegs.plugins.util;

import com.intellij.lang.javascript.psi.JSFile;
import com.intellij.lang.javascript.psi.ecmal4.JSClass;
import com.intellij.lang.javascript.psi.impl.JSPsiImplUtils;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.psi.PsiFile;

/**
 * Created by IntelliJ IDEA. User: rasheed Date: 30/03/2010 Time: 1:21:15 PM To change this template use File | Settings
 * | File Templates.
 */
public class JSFileUtil {
	public static JSClass getJSClass(JSFile file) {
		JSClass clazz = JSPsiImplUtils.findClass(file);

		if (clazz == null)
			return null;

		return clazz; 
	}

	public static JSClass getJSClass(PsiFile file) {
		if (!(file instanceof JSFile ))
			return null;

		return getJSClass((JSFile) file);
	}

	public static JSClass getJSClass(AnActionEvent event) {
		return getJSClass(ActionEventUtil.getJSFile(event));
	}

}
