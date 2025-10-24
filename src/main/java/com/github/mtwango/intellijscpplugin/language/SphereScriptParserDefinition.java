package com.github.mtwango.intellijscpplugin.language;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import com.github.mtwango.intellijscpplugin.language.parser.SphereScriptParser;
import com.github.mtwango.intellijscpplugin.language.psi.SphereScriptFile;
import com.github.mtwango.intellijscpplugin.language.psi.SphereScriptTokenSets;
import com.github.mtwango.intellijscpplugin.language.psi.SphereScriptTypes;
import org.jetbrains.annotations.NotNull;

final class SphereScriptParserDefinition implements ParserDefinition {

  public static final IFileElementType FILE = new IFileElementType(SphereScriptLanguage.INSTANCE);

  @NotNull
  @Override
  public Lexer createLexer(Project project) {
    return new SphereScriptLexerAdapter();
  }

  @NotNull
  @Override
  public TokenSet getCommentTokens() {
    return SphereScriptTokenSets.COMMENTS;
  }

  @NotNull
  @Override
  public TokenSet getStringLiteralElements() {
    return TokenSet.EMPTY;
  }

  @NotNull
  @Override
  public PsiParser createParser(final Project project) {
    return new SphereScriptParser();
  }

  @NotNull
  @Override
  public IFileElementType getFileNodeType() {
    return FILE;
  }

  @NotNull
  @Override
  public PsiFile createFile(@NotNull FileViewProvider viewProvider) {
    return new SphereScriptFile(viewProvider);
  }

  @NotNull
  @Override
  public TokenSet getWhitespaceTokens() {
    return SphereScriptTokenSets.WHITESPACES;
  }

  @NotNull
  @Override
  public PsiElement createElement(ASTNode node) {
    return SphereScriptTypes.Factory.createElement(node);
  }

}
