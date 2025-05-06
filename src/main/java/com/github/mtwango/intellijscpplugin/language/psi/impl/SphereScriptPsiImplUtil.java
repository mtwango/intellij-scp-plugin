package com.github.mtwango.intellijscpplugin.language.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.github.mtwango.intellijscpplugin.language.psi.SphereScriptElementFactory;
import com.github.mtwango.intellijscpplugin.language.psi.SphereScriptProperty;
import com.github.mtwango.intellijscpplugin.language.psi.SphereScriptTypes;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class SphereScriptPsiImplUtil {

  public static String getKey(SphereScriptProperty element) {
    ASTNode keyNode = element.getNode().findChildByType(SphereScriptTypes.KEY);
    if (keyNode != null) {
      // IMPORTANT: Convert embedded escaped spaces to SphereScript spaces
      return keyNode.getText().replaceAll("\\\\ ", " ");
    } else {
      return null;
    }
  }

  public static String getValue(SphereScriptProperty element) {
    ASTNode valueNode = element.getNode().findChildByType(SphereScriptTypes.VALUE);
    if (valueNode != null) {
      return valueNode.getText();
    } else {
      return null;
    }
  }

}
