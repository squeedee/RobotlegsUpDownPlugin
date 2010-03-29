package org.robotlegs.plugins;

import com.intellij.lang.javascript.psi.JSFile;
import com.intellij.lang.javascript.psi.resolve.JSResolveUtil;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.search.GlobalSearchScope;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA. User: rasheed Date: 25/03/2010 Time: 12:43:05 PM To change this template use File |
 * Settings | File Templates.
 * @deprecated
 */
public class GoToViewDefinition extends AnAction {
	private static final Logger logger = Logger.getInstance("#org.robotlegs.plugins.GoToViewDefinition");

	@Override
	public void update(AnActionEvent e) {
		super.update(e);    //To change body of overridden methods use File | Settings | File Templates.

		Presentation presentation = e.getPresentation();

		PsiFile file = e.getData(DataKeys.PSI_FILE);
		
		if (file == null) {
			presentation.setEnabled(false);
			return;
		}

		if (!(file instanceof JSFile)) {
			presentation.setEnabled(false);
			return;
		}

		JSFile castFile = (JSFile) file;
		
		if (!isMediator(castFile)) {
			presentation.setEnabled(false);
			return;
		}

		presentation.setEnabled(canFindView(castFile));


	}

	public static boolean isMediator(JSFile file) {
		GlobalSearchScope scope = JSResolveUtil.getSearchScope(file);
		PsiElement clazz = JSResolveUtil.findClassByQName("OtherClass",scope);
		//PsiElement clazz = JSResolveUtil.findClassByQName("org.robotlegs.base.MediatorBase",scope);

		return clazz != null;
	}

	public static boolean canFindView(JSFile file) {

		//Project project = file.getProject();
		//PsiManager manager = file.getManager();

		// First let's find the robotlegs Mediator.


//		SearchScope scope = GlobalSearchScope.projectScope(file.getProject());
//
//		ReferencesSearch.search(,scope)

		return false;

//		if (!file.getLanguage().getID().equals("ECMA Script Level 4"))
//			return false;
//
//		PsiElement packageRef = file.getFirstChild();
//
//		if (packageRef == null)
//			return false;
//
//		PsiElement classRef;
//
//		// fixme: dumb search, needs fixing
//		classRef = findElementByToString(packageRef,"JSClass");
//
//		if (classRef == null)
//			return false;
//
//		dumpElementChildren(classRef);
//
//		ArrayList<PsiElement> referenceLists = findElementsByToString(classRef,"JSReferenceList");

//		for (PsiElement referenceList : referenceLists) {
//			if (findElementByToString(referenceList,"PsiElement(JS:EXTENDS_KEYWORD)") != null )
//			dumpElementChildren(referenceList);
//		}

		// Search for extends references
		


//		System.out.println(((PsiClass) classRef).getInterfaces().toString());
		
		//PsiClass[] interfaces = packageClass.getInterfaces();

//		for (PsiClass a : interfaces) {
//			System.out.println(a.toString());
//		}
		
		//return true;
		
	}

	private static ArrayList<PsiElement> findElementsByToString(PsiElement parentElement, String name) {
		ArrayList<PsiElement> matches = new ArrayList<PsiElement>();

		for (PsiElement element = parentElement.getFirstChild(); element != null; element = element.getNextSibling()){
			if (element.toString().equals(name))
				matches.add(element);
        }
		
		return matches;

	}

	private static PsiElement findElementByToString(PsiElement parentElement, String name) {
		PsiElement element;

		for (element = parentElement.getFirstChild(); element != null; element = element.getNextSibling()){
			if (element.toString().equals(name))
				return element;
        }
		return null;
	}

	public void actionPerformed(AnActionEvent e) {
		// Messages.showInfoMessage("Wee","Yay");
		
	}

	private static void dumpElementChildren(PsiElement element) {
		System.out.println("Children of: " + element.toString());
		PsiElement child;
		for (child = element.getFirstChild(); child != null; child = child.getNextSibling()) {
			System.out.println("\t" + child.toString());
		}
	}

}


