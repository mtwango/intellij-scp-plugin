package com.github.mtwango.intellijscpplugin.language;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementResolveResult;
import com.intellij.psi.PsiPolyVariantReferenceBase;
import com.intellij.psi.ResolveResult;
import com.github.mtwango.intellijscpplugin.language.psi.SphereScriptProperty;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

final class SphereScriptReference extends PsiPolyVariantReferenceBase<PsiElement> {

  private final String key;

  SphereScriptReference(@NotNull PsiElement element, TextRange textRange) {
    super(element, textRange);
    key = element.getText()
        .substring(textRange.getStartOffset(), textRange.getEndOffset());
  }

  @Override
  public ResolveResult @NotNull [] multiResolve(boolean incompleteCode) {
    Project project = myElement.getProject();
    List<SphereScriptProperty> properties = SphereScriptUtil.findProperties(project, key);
    List<ResolveResult> results = new ArrayList<>();
    for (SphereScriptProperty property : properties) {
      results.add(new PsiElementResolveResult(property));
    }
    return results.toArray(new ResolveResult[0]);
  }

  @Override
  public Object @NotNull [] getVariants() {
    Project project = myElement.getProject();
    List<SphereScriptProperty> properties = SphereScriptUtil.findProperties(project);
    List<LookupElement> variants = new ArrayList<>();
    for (SphereScriptProperty property : properties) {
      if (property.getPropertyKey() != null && !property.getPropertyKey().toString().isEmpty()) {
        variants.add(LookupElementBuilder
            .create(property).withIcon(SphereScriptIcons.FILE)
            .withTypeText(property.getContainingFile().getName())
        );
      }
    }
    return variants.toArray();
  }

}
