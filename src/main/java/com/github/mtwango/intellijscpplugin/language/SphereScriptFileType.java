package com.github.mtwango.intellijscpplugin.language;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public final class SphereScriptFileType extends LanguageFileType {

  public static final SphereScriptFileType INSTANCE = new SphereScriptFileType();

  private SphereScriptFileType() {
    super(SphereScriptLanguage.INSTANCE);
  }

  @NotNull
  @Override
  public String getName() {
    return "SphereScript File";
  }

  @NotNull
  @Override
  public String getDescription() {
    return "SphereScript language file";
  }

  @NotNull
  @Override
  public String getDefaultExtension() {
    return "scp";
  }

  @Override
  public Icon getIcon() {
    return SphereScriptIcons.FILE;
  }

}
