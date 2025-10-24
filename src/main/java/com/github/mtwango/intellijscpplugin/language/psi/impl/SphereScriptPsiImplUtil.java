package com.github.mtwango.intellijscpplugin.language.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.github.mtwango.intellijscpplugin.language.psi.SphereScriptElementFactory;
import com.github.mtwango.intellijscpplugin.language.psi.SphereScriptProperty;
import com.github.mtwango.intellijscpplugin.language.psi.SphereScriptPropertyKey;
import com.github.mtwango.intellijscpplugin.language.psi.SphereScriptTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class SphereScriptPsiImplUtil {

  public static String getKey(SphereScriptProperty element) {
    ASTNode keyNode = element.getNode().findChildByType(SphereScriptTypes.IDENTIFIER);
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
  public static String getName(SphereScriptProperty element) {
    return getKey(element);
  }

  public static PsiElement setName(SphereScriptProperty element, String newName) {
    ASTNode keyNode = element.getNode().findChildByType(SphereScriptTypes.IDENTIFIER);
    if (keyNode != null) {
      SphereScriptProperty property = SphereScriptElementFactory.createProperty(element.getProject(), newName);
      ASTNode newKeyNode = property.getFirstChild().getNode();
      element.getNode().replaceChild(keyNode, newKeyNode);
    }
    return element;
  }

  public static PsiElement getNameIdentifier(SphereScriptProperty element) {
    ASTNode keyNode = element.getNode().findChildByType(SphereScriptTypes.IDENTIFIER);
    if (keyNode != null) {
      return keyNode.getPsi();
    } else {
      return null;
    }
  }

  public static ItemPresentation getPresentation(final SphereScriptProperty element) {
    return new ItemPresentation() {
      @Override
      public @Nullable String getPresentableText() {
        return element.getPropertyKey().toString();
      }

      @Nullable
      @Override
      public String getLocationString() {
        PsiFile containingFile = element.getContainingFile();
        return containingFile == null ? null : containingFile.getName();
      }

      @Override
      public Icon getIcon(boolean unused) {
        return element.getIcon(0);
      }
    };
  }

}
