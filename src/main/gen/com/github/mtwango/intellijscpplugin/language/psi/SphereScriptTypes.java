// This is a generated file. Not intended for manual editing.
package com.github.mtwango.intellijscpplugin.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.mtwango.intellijscpplugin.language.psi.impl.*;

public interface SphereScriptTypes {

  IElementType PROPERTY = new SphereScriptElementType("PROPERTY");

  IElementType COMMENT = new SphereScriptTokenType("COMMENT");
  IElementType CRLF = new SphereScriptTokenType("CRLF");
  IElementType KEY = new SphereScriptTokenType("KEY");
  IElementType SEPARATOR = new SphereScriptTokenType("SEPARATOR");
  IElementType TRIGGER = new SphereScriptTokenType("TRIGGER");
  IElementType VALUE = new SphereScriptTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == PROPERTY) {
        return new SphereScriptPropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
