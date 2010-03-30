package org.robotlegs.plugins.util;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiPolyVariantReference;

public class ReferenceUtil {
	public static PsiElement resolvedReferenceOrNull(PsiElement element) {
		if (!(element instanceof PsiPolyVariantReference))
			return null;

		return ((PsiPolyVariantReference) element).resolve();
	}
}