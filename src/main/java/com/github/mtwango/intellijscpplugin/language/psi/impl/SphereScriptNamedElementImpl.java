package com.github.mtwango.intellijscpplugin.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.github.mtwango.intellijscpplugin.language.psi.SphereScriptNamedElement;
import org.jetbrains.annotations.NotNull;

public abstract class SphereScriptNamedElementImpl extends ASTWrapperPsiElement implements SphereScriptNamedElement {

  public SphereScriptNamedElementImpl(@NotNull ASTNode node) {
    super(node);
  }

}
