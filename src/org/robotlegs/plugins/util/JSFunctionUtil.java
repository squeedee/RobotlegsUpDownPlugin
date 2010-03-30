package org.robotlegs.plugins.util;

import com.intellij.lang.javascript.psi.JSFunction;

public class JSFunctionUtil {
	public static boolean functionIsNamedGetter(String name, JSFunction function) {
		if (!name.equals(function.getName()))
			return false;

		return function.getKind().equals(JSFunction.FunctionKind.GETTER);

	}
}