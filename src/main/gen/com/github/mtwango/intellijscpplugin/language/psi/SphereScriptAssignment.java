// This is a generated file. Not intended for manual editing.
package com.github.mtwango.intellijscpplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SphereScriptAssignment extends PsiElement {

  @NotNull
  SphereScriptExpression getExpression();

  @Nullable
  SphereScriptPropertyReference getPropertyReference();

  @Nullable
  SphereScriptVariable getVariable();

  @Nullable
  PsiElement getIdentifier();

}
