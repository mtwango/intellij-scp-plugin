// This is a generated file. Not intended for manual editing.
package com.github.mtwango.intellijscpplugin.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.mtwango.intellijscpplugin.language.psi.SphereScriptTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.github.mtwango.intellijscpplugin.language.psi.*;

public class SphereScriptArgumentListImpl extends ASTWrapperPsiElement implements SphereScriptArgumentList {

  public SphereScriptArgumentListImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SphereScriptVisitor visitor) {
    visitor.visitArgumentList(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SphereScriptVisitor) accept((SphereScriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<SphereScriptExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SphereScriptExpression.class);
  }

}
