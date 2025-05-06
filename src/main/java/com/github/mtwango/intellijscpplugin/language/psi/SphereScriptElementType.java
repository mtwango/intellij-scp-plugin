package com.github.mtwango.intellijscpplugin.language.psi;

import com.intellij.psi.tree.IElementType;
import com.github.mtwango.intellijscpplugin.language.SphereScriptLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class SphereScriptElementType extends IElementType {

  public SphereScriptElementType(@NotNull @NonNls String debugName) {
    super(debugName, SphereScriptLanguage.INSTANCE);
  }

}
