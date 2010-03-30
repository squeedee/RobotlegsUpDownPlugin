package org.robotlegs.plugins.util;

import com.intellij.lang.javascript.psi.JSFile;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataKeys;
import com.intellij.psi.PsiFile;

/**
 * Created by IntelliJ IDEA. User: rasheed Date: 30/03/2010 Time: 1:17:02 PM To change this template use File | Settings
 * | File Templates.
 */
public class ActionEventUtil {
	public static PsiFile getPsiFile(AnActionEvent event) {
		return event.getData(DataKeys.PSI_FILE);
	}

	public static JSFile getJSFile(AnActionEvent event) {
		PsiFile file = getPsiFile(event);

		if (file == null)
			return null;

		if (!(file instanceof JSFile))
			return null;

		return (JSFile) file;
	}
}
