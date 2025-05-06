package com.github.mtwango.intellijscpplugin.language.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.github.mtwango.intellijscpplugin.language.SphereScriptFileType;
import com.github.mtwango.intellijscpplugin.language.SphereScriptLanguage;
import org.jetbrains.annotations.NotNull;

public class SphereScriptFile extends PsiFileBase {

  public SphereScriptFile(@NotNull FileViewProvider viewProvider) {
    super(viewProvider, SphereScriptLanguage.INSTANCE);
  }

  @NotNull
  @Override
  public FileType getFileType() {
    return SphereScriptFileType.INSTANCE;
  }

  @Override
  public String toString() {
    return "SphereScript File";
  }

}
