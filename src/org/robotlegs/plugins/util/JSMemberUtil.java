package org.robotlegs.plugins.util;

import com.intellij.lang.javascript.psi.JSFunction;
import com.intellij.lang.javascript.psi.JSVariable;
import com.intellij.lang.javascript.psi.ecmal4.JSClass;
import com.intellij.psi.PsiElement;


public class JSMemberUtil {
	public static PsiElement getTypeByAccessorName(String name, JSClass in) {
		// Vars first
		JSVariable[] vars = in.getFields();

		for (JSVariable var : vars) {
			if (name.equals(var.getName()))
				return ReferenceUtil.resolvedReferenceOrNull(var.getTypeElement());
		}

		JSFunction[] functions = in.getFunctions();

		for (JSFunction function : functions) {
			if (JSFunctionUtil.functionIsNamedGetter(name, function))
				return ReferenceUtil.resolvedReferenceOrNull(function.getReturnTypeElement());
		}

		return null;
	}
}