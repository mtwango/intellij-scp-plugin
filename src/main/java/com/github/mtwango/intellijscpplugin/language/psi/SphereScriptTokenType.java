package com.github.mtwango.intellijscpplugin.language.psi;

import com.intellij.psi.tree.IElementType;
import com.github.mtwango.intellijscpplugin.language.SphereScriptLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class SphereScriptTokenType extends IElementType {

  public SphereScriptTokenType(@NotNull @NonNls String debugName) {
    super(debugName, SphereScriptLanguage.INSTANCE);
  }

  @Override
  public String toString() {
    return "SphereScriptTokenType." + super.toString();
  }

}
