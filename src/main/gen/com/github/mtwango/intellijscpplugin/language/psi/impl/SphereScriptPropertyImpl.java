// This is a generated file. Not intended for manual editing.
package com.github.mtwango.intellijscpplugin.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.mtwango.intellijscpplugin.language.psi.SphereScriptTypes.*;
import com.github.mtwango.intellijscpplugin.language.psi.*;

public class SphereScriptPropertyImpl extends SphereScriptNamedElementImpl implements SphereScriptProperty {

  public SphereScriptPropertyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SphereScriptVisitor visitor) {
    visitor.visitProperty(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SphereScriptVisitor) accept((SphereScriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  public String getKey() {
    return SphereScriptPsiImplUtil.getKey(this);
  }

  @Override
  public String getValue() {
    return SphereScriptPsiImplUtil.getValue(this);
  }

  @Override
  public String getName() {
    return SphereScriptPsiImplUtil.getName(this);
  }

  @Override
  public PsiElement setName(String newName) {
    return SphereScriptPsiImplUtil.setName(this, newName);
  }

  @Override
  public PsiElement getNameIdentifier() {
    return SphereScriptPsiImplUtil.getNameIdentifier(this);
  }

}
