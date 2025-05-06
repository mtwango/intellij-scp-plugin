package com.github.mtwango.intellijscpplugin.language;

import com.google.common.collect.Lists;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiComment;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.PsiWhiteSpace;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import com.github.mtwango.intellijscpplugin.language.psi.SphereScriptFile;
import com.github.mtwango.intellijscpplugin.language.psi.SphereScriptProperty;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class SphereScriptUtil {

  /**
   * Searches the entire project for SphereScript language files with instances of the SphereScript property with the given key.
   *
   * @param project current project
   * @param key     to check
   * @return matching properties
   */
  public static List<SphereScriptProperty> findProperties(Project project, String key) {
    List<SphereScriptProperty> result = new ArrayList<>();
    Collection<VirtualFile> virtualFiles =
        FileTypeIndex.getFiles(SphereScriptFileType.INSTANCE, GlobalSearchScope.allScope(project));
    for (VirtualFile virtualFile : virtualFiles) {
      SphereScriptFile spherescriptFile = (SphereScriptFile) PsiManager.getInstance(project).findFile(virtualFile);
      if (spherescriptFile != null) {
        SphereScriptProperty[] properties = PsiTreeUtil.getChildrenOfType(spherescriptFile, SphereScriptProperty.class);
        if (properties != null) {
          for (SphereScriptProperty property : properties) {
            //if (key.equals(property.getKey())) {
            //  result.add(property);
            //}
          }
        }
      }
    }
    return result;
  }

  public static List<SphereScriptProperty> findProperties(Project project) {
    List<SphereScriptProperty> result = new ArrayList<>();
    Collection<VirtualFile> virtualFiles =
        FileTypeIndex.getFiles(SphereScriptFileType.INSTANCE, GlobalSearchScope.allScope(project));
    for (VirtualFile virtualFile : virtualFiles) {
      SphereScriptFile spherescriptFile = (SphereScriptFile) PsiManager.getInstance(project).findFile(virtualFile);
      if (spherescriptFile != null) {
        SphereScriptProperty[] properties = PsiTreeUtil.getChildrenOfType(spherescriptFile, SphereScriptProperty.class);
        if (properties != null) {
          Collections.addAll(result, properties);
        }
      }
    }
    return result;
  }

  /**
   * Attempts to collect any comment elements above the SphereScript key/value pair.
   */
  public static @NotNull String findDocumentationComment(SphereScriptProperty property) {
    List<String> result = new LinkedList<>();
    PsiElement element = property.getPrevSibling();
    while (element instanceof PsiComment || element instanceof PsiWhiteSpace) {
      if (element instanceof PsiComment) {
        String commentText = element.getText().replaceFirst("[!# ]+", "");
        result.add(commentText);
      }
      element = element.getPrevSibling();
    }
    return StringUtil.join(Lists.reverse(result), "\n ");
  }

}
