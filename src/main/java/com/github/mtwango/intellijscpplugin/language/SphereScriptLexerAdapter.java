package com.github.mtwango.intellijscpplugin.language;

import com.intellij.lexer.FlexAdapter;

public class SphereScriptLexerAdapter extends FlexAdapter {

  public SphereScriptLexerAdapter() {
    super(new SphereScriptLexer(null));
  }

}
