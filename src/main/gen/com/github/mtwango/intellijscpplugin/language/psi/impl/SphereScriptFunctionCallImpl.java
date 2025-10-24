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

public class SphereScriptFunctionCallImpl extends ASTWrapperPsiElement implements SphereScriptFunctionCall {

  public SphereScriptFunctionCallImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SphereScriptVisitor visitor) {
    visitor.visitFunctionCall(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SphereScriptVisitor) accept((SphereScriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SphereScriptArgumentList getArgumentList() {
    return findChildByClass(SphereScriptArgumentList.class);
  }

  @Override
  @Nullable
  public SphereScriptExpression getExpression() {
    return findChildByClass(SphereScriptExpression.class);
  }

  @Override
  @Nullable
  public SphereScriptPropertyReference getPropertyReference() {
    return findChildByClass(SphereScriptPropertyReference.class);
  }

  @Override
  @Nullable
  public PsiElement getBuiltinFunction() {
    return findChildByType(BUILTIN_FUNCTION);
  }

  @Override
  @Nullable
  public PsiElement getIdentifier() {
    return findChildByType(IDENTIFIER);
  }

}
