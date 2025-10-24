package com.github.mtwango.intellijscpplugin.language;

import com.github.mtwango.intellijscpplugin.language.psi.SphereScriptTokenSets;
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

    public static final TextAttributesKey KEYWORD = createTextAttributesKey(
            "SCP_KEYWORD",
            DefaultLanguageHighlighterColors.KEYWORD
    );
    public static final TextAttributesKey STRING = createTextAttributesKey(
            "SCP_STRING",
            DefaultLanguageHighlighterColors.STRING
    );
    public static final TextAttributesKey NUMBER = createTextAttributesKey(
            "SCP_NUMBER",
            DefaultLanguageHighlighterColors.NUMBER
    );
    public static final TextAttributesKey COMMENT = createTextAttributesKey(
            "SCP_COMMENT",
            DefaultLanguageHighlighterColors.LINE_COMMENT
    );
    public static final TextAttributesKey OPERATOR = createTextAttributesKey(
            "SCP_OPERATOR",
            DefaultLanguageHighlighterColors.OPERATION_SIGN
    );
    public static final TextAttributesKey PROPERTY_KEY = createTextAttributesKey(
            "SCP_PROPERTY_KEY",
            DefaultLanguageHighlighterColors.INSTANCE_FIELD
    );
    public static final TextAttributesKey SECTION = createTextAttributesKey(
            "SCP_SECTION",
            DefaultLanguageHighlighterColors.CLASS_NAME
    );
    public static final TextAttributesKey BUILTIN_FUNCTION = createTextAttributesKey(
            "SCP_BUILTIN_FUNCTION",
            DefaultLanguageHighlighterColors.PREDEFINED_SYMBOL
    );
    public static final TextAttributesKey TRIGGER = createTextAttributesKey(
            "SCP_TRIGGER",
            DefaultLanguageHighlighterColors.FUNCTION_CALL
    );
    public static final TextAttributesKey VARIABLE = createTextAttributesKey(
            "SCP_VARIABLE",
            DefaultLanguageHighlighterColors.GLOBAL_VARIABLE
    );
    public static final TextAttributesKey VARIABLE_DELIMITER = createTextAttributesKey(
            "SCP_VARIABLE_DELIMITER",
            DefaultLanguageHighlighterColors.BRACES
    );

    private static final TextAttributesKey[] KEYWORD_KEYS = new TextAttributesKey[]{KEYWORD};
    private static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[]{STRING};
    private static final TextAttributesKey[] NUMBER_KEYS = new TextAttributesKey[]{NUMBER};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] OPERATOR_KEYS = new TextAttributesKey[]{OPERATOR};
    private static final TextAttributesKey[] PROPERTY_KEY_KEYS = new TextAttributesKey[]{PROPERTY_KEY};
    private static final TextAttributesKey[] SECTION_KEYS = new TextAttributesKey[]{SECTION};
    private static final TextAttributesKey[] BUILTIN_FUNCTION_KEYS = new TextAttributesKey[]{BUILTIN_FUNCTION};
    private static final TextAttributesKey[] TRIGGER_KEYS = new TextAttributesKey[]{TRIGGER};
    private static final TextAttributesKey[] VARIABLE_KEYS = new TextAttributesKey[]{VARIABLE};
    private static final TextAttributesKey[] VARIABLE_DELIMITER_KEYS = new TextAttributesKey[]{VARIABLE_DELIMITER};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

  @NotNull
  @Override
  public Lexer getHighlightingLexer() {
    return new SphereScriptLexerAdapter();
  }

  @Override
  public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
      if (SphereScriptTokenSets.KEYWORDS.contains(tokenType)) { return KEYWORD_KEYS; }
      if (SphereScriptTokenSets.STRINGS.contains(tokenType)) { return STRING_KEYS; }
      if (SphereScriptTokenSets.NUMBERS.contains(tokenType)) { return NUMBER_KEYS; }
      if (SphereScriptTokenSets.COMMENTS.contains(tokenType)) { return COMMENT_KEYS; }
      if (SphereScriptTokenSets.OPERATORS.contains(tokenType)) { return OPERATOR_KEYS; }
      if (SphereScriptTokenSets.PROPERTY_KEYS.contains(tokenType)) { return PROPERTY_KEY_KEYS; }
      if (tokenType.equals(SphereScriptTypes.SECTION_HEADER)) { return SECTION_KEYS; }
      if (tokenType.equals(SphereScriptTypes.BUILTIN_FUNCTION)) { return BUILTIN_FUNCTION_KEYS; }
      if (tokenType.equals(SphereScriptTypes.TRIGGER)) { return TRIGGER_KEYS; }
      if (tokenType.equals(SphereScriptTypes.VARIABLE_START) || tokenType.equals(SphereScriptTypes.VARIABLE_END)) { return VARIABLE_DELIMITER_KEYS; }
      if (tokenType.equals(SphereScriptTypes.VARIABLE_CONTENT)) { return VARIABLE_KEYS; }
    return EMPTY_KEYS;
  }
}
