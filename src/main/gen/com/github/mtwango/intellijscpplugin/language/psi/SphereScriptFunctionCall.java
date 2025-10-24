// This is a generated file. Not intended for manual editing.
package com.github.mtwango.intellijscpplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SphereScriptFunctionCall extends PsiElement {

  @Nullable
  SphereScriptArgumentList getArgumentList();

  @Nullable
  SphereScriptExpression getExpression();

  @Nullable
  SphereScriptPropertyReference getPropertyReference();

  @Nullable
  PsiElement getBuiltinFunction();

  @Nullable
  PsiElement getIdentifier();

}
