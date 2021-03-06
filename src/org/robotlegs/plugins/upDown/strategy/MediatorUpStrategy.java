package org.robotlegs.plugins.upDown.strategy;

import com.intellij.lang.javascript.psi.ecmal4.JSClass;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.psi.PsiElement;
import org.robotlegs.plugins.util.ActionEventUtil;
import org.robotlegs.plugins.util.JSFileUtil;
import org.robotlegs.plugins.util.JSMemberUtil;

import java.util.ResourceBundle;

/**
 * Created by IntelliJ IDEA. User: rasheed Date: 30/03/2010 Time: 11:11:25 AM To change this template use File |
 * Settings | File Templates.
 */
public class MediatorUpStrategy implements IUpDownStrategy {

	protected ResourceBundle resourceBundle = ResourceBundle.getBundle("org.robotlegs.plugins.UpDownPluginBundle");

	public void update(AnActionEvent event) {
		Presentation presentation = event.getPresentation();

		presentation.setEnabled(true);
		presentation.setText(resourceBundle.getString("mediator.up"));
	}

	public void perform(AnActionEvent event) {
		JSClass clazz = JSFileUtil.getJSClass(event);

		if (clazz == null)
			return;

		PsiElement viewElement = JSMemberUtil.getTypeByAccessorName("view", clazz);

		if (viewElement == null) // todo: add a nice warning (no dialog)
			return;

		ActionEventUtil.getIdeView(event).selectElement(viewElement);

	}
}
