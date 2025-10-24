// This is a generated file. Not intended for manual editing.
package com.github.mtwango.intellijscpplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SphereScriptPrimaryExpression extends PsiElement {

  @Nullable
  SphereScriptExpression getExpression();

  @Nullable
  SphereScriptFunctionCall getFunctionCall();

  @Nullable
  SphereScriptLiteral getLiteral();

  @Nullable
  SphereScriptPropertyReference getPropertyReference();

  @Nullable
  SphereScriptVariable getVariable();

  @Nullable
  PsiElement getIdentifier();

}
