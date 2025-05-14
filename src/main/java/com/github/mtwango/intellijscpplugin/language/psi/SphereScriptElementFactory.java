package com.github.mtwango.intellijscpplugin.language.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileFactory;
import com.github.mtwango.intellijscpplugin.language.SphereScriptFileType;

public class SphereScriptElementFactory {

  public static SphereScriptProperty createProperty(Project project, String name) {
    final SphereScriptFile file = createFile(project, name);
    return (SphereScriptProperty) file.getFirstChild();
  }

  public static SphereScriptFile createFile(Project project, String text) {
    String name = "dummpy.scp";
    return (SphereScriptFile) PsiFileFactory.getInstance(project).createFileFromText(name, SphereScriptFileType.INSTANCE, text);
  }

  public static SphereScriptProperty createProperty(Project project, String name, String value) {
    final SphereScriptFile file = createFile(project, name + " = " + value);
    return (SphereScriptProperty) file.getFirstChild();
  }

  public static PsiElement createCRLF(Project project) {
    final SphereScriptFile file = createFile(project, "\n");
    return file.getFirstChild();
  }

}
