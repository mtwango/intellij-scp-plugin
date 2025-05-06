package com.github.mtwango.intellijscpplugin.language;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.github.mtwango.intellijscpplugin.language.psi.SphereScriptTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class SphereScriptSyntaxHighlighter extends SyntaxHighlighterBase {

  public static final TextAttributesKey SEPARATOR =
      createTextAttributesKey("SCP_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
  public static final TextAttributesKey KEYWORD =
      createTextAttributesKey("SCP_KEY", DefaultLanguageHighlighterColors.KEYWORD);
  public static final TextAttributesKey TRIGGER =
          createTextAttributesKey("SCP_TRIGGER", DefaultLanguageHighlighterColors.FUNCTION_DECLARATION);
  public static final TextAttributesKey VALUE =
      createTextAttributesKey("SCP_VALUE", DefaultLanguageHighlighterColors.STRING);
  public static final TextAttributesKey COMMENT =
      createTextAttributesKey("SCP_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
  public static final TextAttributesKey BAD_CHARACTER =
      createTextAttributesKey("SCP_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);


  private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
  private static final TextAttributesKey[] SEPARATOR_KEYS = new TextAttributesKey[]{SEPARATOR};
  private static final TextAttributesKey[] KEY_KEYS = new TextAttributesKey[]{KEYWORD};
  private static final TextAttributesKey[] TRIGGER_KEYS = new TextAttributesKey[]{TRIGGER};
  private static final TextAttributesKey[] VALUE_KEYS = new TextAttributesKey[]{VALUE};
  private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
  private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

  @NotNull
  @Override
  public Lexer getHighlightingLexer() {
    return new SphereScriptLexerAdapter();
  }

  @Override
  public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
    if (tokenType.equals(SphereScriptTypes.SEPARATOR)) {
      return SEPARATOR_KEYS;
    }
    if (tokenType.equals(SphereScriptTypes.KEY)) {
      return KEY_KEYS;
    }
    if (tokenType.equals(SphereScriptTypes.VALUE)) {
      return VALUE_KEYS;
    }
    if (tokenType.equals(SphereScriptTypes.TRIGGER)) {
      return TRIGGER_KEYS;
    }
    if (tokenType.equals(SphereScriptTypes.COMMENT)) {
      return COMMENT_KEYS;
    }
    if (tokenType.equals(TokenType.BAD_CHARACTER)) {
      return BAD_CHAR_KEYS;
    }
    return EMPTY_KEYS;
  }

}
