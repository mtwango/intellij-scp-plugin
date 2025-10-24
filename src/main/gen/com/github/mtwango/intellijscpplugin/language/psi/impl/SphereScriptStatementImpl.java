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

public class SphereScriptStatementImpl extends ASTWrapperPsiElement implements SphereScriptStatement {

  public SphereScriptStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SphereScriptVisitor visitor) {
    visitor.visitStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SphereScriptVisitor) accept((SphereScriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SphereScriptAssignment getAssignment() {
    return findChildByClass(SphereScriptAssignment.class);
  }

  @Override
  @Nullable
  public SphereScriptBreakStatement getBreakStatement() {
    return findChildByClass(SphereScriptBreakStatement.class);
  }

  @Override
  @Nullable
  public SphereScriptContinueStatement getContinueStatement() {
    return findChildByClass(SphereScriptContinueStatement.class);
  }

  @Override
  @Nullable
  public SphereScriptForStatement getForStatement() {
    return findChildByClass(SphereScriptForStatement.class);
  }

  @Override
  @Nullable
  public SphereScriptFunctionCall getFunctionCall() {
    return findChildByClass(SphereScriptFunctionCall.class);
  }

  @Override
  @Nullable
  public SphereScriptIfStatement getIfStatement() {
    return findChildByClass(SphereScriptIfStatement.class);
  }

  @Override
  @Nullable
  public SphereScriptReturnStatement getReturnStatement() {
    return findChildByClass(SphereScriptReturnStatement.class);
  }

  @Override
  @Nullable
  public SphereScriptWhileStatement getWhileStatement() {
    return findChildByClass(SphereScriptWhileStatement.class);
  }

}
