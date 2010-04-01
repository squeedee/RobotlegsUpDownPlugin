package org.robotlegs.plugins.upDown.strategy;

import com.intellij.lang.javascript.psi.ecmal4.JSClass;
import com.intellij.lang.javascript.psi.resolve.JSResolveUtil;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataKeys;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.psi.PsiReference;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.search.searches.ReferencesSearch;
import org.robotlegs.plugins.util.JSFileUtil;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA. User: rasheed Date: 31/03/2010 Time: 8:15:19 AM To change this template use File | Settings
 * | File Templates.
 */
public class ViewDownStategy implements IUpDownStrategy {
	public void update(AnActionEvent event) {
		Presentation presentation = event.getPresentation();

		presentation.setEnabled(true);
		// FIXME resource bundles needed
		presentation.setText("RL Down: View -> [Mediator|Event|Actor]");
	}

	public void perform(AnActionEvent event) {
		JSClass clazz = JSFileUtil.getJSClass(event);

		if (clazz == null)
			return;

		// Todo hunt for the classes' references (clazz in the references catalog)
		GlobalSearchScope scope = JSResolveUtil.getSearchScopeWithPredefined(event.getData(DataKeys.PROJECT));

		Collection<PsiReference> references = ReferencesSearch.search(clazz,scope,false).findAll();

		for (PsiReference reference : references) {
			System.out.println("***-1-*** " + reference.getRangeInElement().toString());
			System.out.println("***-2-*** " + reference.getElement().getContainingFile().getName());
			System.out.println("***-3-*** " + reference.toString());
		}

		//Collection<PsiReference> ReferencesSearc ReferencesSearc.search(clazz, scope, false).findAll();

		//ActionEventUtil.getIdeView(event).selectElement(viewElement);
	}

	
}
