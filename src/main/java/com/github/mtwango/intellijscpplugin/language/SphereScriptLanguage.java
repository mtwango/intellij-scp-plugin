package com.github.mtwango.intellijscpplugin.language;

import com.intellij.lang.Language;

public class SphereScriptLanguage extends Language {

  public static final SphereScriptLanguage INSTANCE = new SphereScriptLanguage();

  private SphereScriptLanguage() {
    super("SphereScript");
  }

}
