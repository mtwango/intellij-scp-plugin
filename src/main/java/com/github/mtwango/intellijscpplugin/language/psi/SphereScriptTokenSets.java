package com.github.mtwango.intellijscpplugin.language.psi;

import com.intellij.psi.tree.TokenSet;

public interface SphereScriptTokenSets {

  TokenSet IDENTIFIERS = TokenSet.create(SphereScriptTypes.KEY);

  TokenSet COMMENTS = TokenSet.create(SphereScriptTypes.COMMENT);

}
