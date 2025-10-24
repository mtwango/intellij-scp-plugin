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

public class SphereScriptAssignmentImpl extends ASTWrapperPsiElement implements SphereScriptAssignment {

  public SphereScriptAssignmentImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SphereScriptVisitor visitor) {
    visitor.visitAssignment(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SphereScriptVisitor) accept((SphereScriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public SphereScriptExpression getExpression() {
    return findNotNullChildByClass(SphereScriptExpression.class);
  }

  @Override
  @Nullable
  public SphereScriptPropertyReference getPropertyReference() {
    return findChildByClass(SphereScriptPropertyReference.class);
  }

  @Override
  @Nullable
  public SphereScriptVariable getVariable() {
    return findChildByClass(SphereScriptVariable.class);
  }

  @Override
  @Nullable
  public PsiElement getIdentifier() {
    return findChildByType(IDENTIFIER);
  }

}
