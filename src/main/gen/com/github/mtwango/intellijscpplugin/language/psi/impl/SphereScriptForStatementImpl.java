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

public class SphereScriptForStatementImpl extends ASTWrapperPsiElement implements SphereScriptForStatement {

  public SphereScriptForStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SphereScriptVisitor visitor) {
    visitor.visitForStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SphereScriptVisitor) accept((SphereScriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SphereScriptExpression getExpression() {
    return findChildByClass(SphereScriptExpression.class);
  }

  @Override
  @NotNull
  public List<SphereScriptStatement> getStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SphereScriptStatement.class);
  }

  @Override
  @NotNull
  public PsiElement getCrlf() {
    return findNotNullChildByType(CRLF);
  }

}
