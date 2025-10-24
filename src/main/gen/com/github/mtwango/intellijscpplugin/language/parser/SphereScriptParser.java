// This is a generated file. Not intended for manual editing.
package com.github.mtwango.intellijscpplugin.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.mtwango.intellijscpplugin.language.psi.SphereScriptTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class SphereScriptParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return scpFile(b, l + 1);
  }

  /* ********************************************************** */
  // multiplicative_expression
  //                        ((PLUS | MINUS) multiplicative_expression)*
  public static boolean additive_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additive_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ADDITIVE_EXPRESSION, "<additive expression>");
    r = multiplicative_expression(b, l + 1);
    r = r && additive_expression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ((PLUS | MINUS) multiplicative_expression)*
  private static boolean additive_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additive_expression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!additive_expression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "additive_expression_1", c)) break;
    }
    return true;
  }

  // (PLUS | MINUS) multiplicative_expression
  private static boolean additive_expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additive_expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = additive_expression_1_0_0(b, l + 1);
    r = r && multiplicative_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // PLUS | MINUS
  private static boolean additive_expression_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additive_expression_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    return r;
  }

  /* ********************************************************** */
  // expression (COMMA expression)*
  public static boolean argument_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARGUMENT_LIST, "<argument list>");
    r = expression(b, l + 1);
    r = r && argument_list_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COMMA expression)*
  private static boolean argument_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!argument_list_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "argument_list_1", c)) break;
    }
    return true;
  }

  // COMMA expression
  private static boolean argument_list_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (IDENTIFIER | variable | property_reference) EQUALS expression
  public static boolean assignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment")) return false;
    if (!nextTokenIs(b, "<assignment>", IDENTIFIER, VARIABLE_START)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASSIGNMENT, "<assignment>");
    r = assignment_0(b, l + 1);
    r = r && consumeToken(b, EQUALS);
    r = r && expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // IDENTIFIER | variable | property_reference
  private static boolean assignment_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_0")) return false;
    boolean r;
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = variable(b, l + 1);
    if (!r) r = property_reference(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // BREAK
  public static boolean break_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "break_statement")) return false;
    if (!nextTokenIs(b, BREAK)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BREAK);
    exit_section_(b, m, BREAK_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // COMMENT
  public static boolean commentRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "commentRule")) return false;
    if (!nextTokenIs(b, COMMENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMENT);
    exit_section_(b, m, COMMENT_RULE, r);
    return r;
  }

  /* ********************************************************** */
  // additive_expression
  //                          ((LT | GT | LE | GE | EQ | NE) additive_expression)?
  public static boolean comparison_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comparison_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMPARISON_EXPRESSION, "<comparison expression>");
    r = additive_expression(b, l + 1);
    r = r && comparison_expression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ((LT | GT | LE | GE | EQ | NE) additive_expression)?
  private static boolean comparison_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comparison_expression_1")) return false;
    comparison_expression_1_0(b, l + 1);
    return true;
  }

  // (LT | GT | LE | GE | EQ | NE) additive_expression
  private static boolean comparison_expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comparison_expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = comparison_expression_1_0_0(b, l + 1);
    r = r && additive_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LT | GT | LE | GE | EQ | NE
  private static boolean comparison_expression_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comparison_expression_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, LT);
    if (!r) r = consumeToken(b, GT);
    if (!r) r = consumeToken(b, LE);
    if (!r) r = consumeToken(b, GE);
    if (!r) r = consumeToken(b, EQ);
    if (!r) r = consumeToken(b, NE);
    return r;
  }

  /* ********************************************************** */
  // CONTINUE
  public static boolean continue_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "continue_statement")) return false;
    if (!nextTokenIs(b, CONTINUE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CONTINUE);
    exit_section_(b, m, CONTINUE_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // logical_or_expression
  public static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION, "<expression>");
    r = logical_or_expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (FOR | FORCHARS | FORITEMS | FORCLIENTS | FORPLAYERS)
  //                  expression? CRLF
  //                  statement*
  //                  ENDFOR
  public static boolean for_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FOR_STATEMENT, "<for statement>");
    r = for_statement_0(b, l + 1);
    r = r && for_statement_1(b, l + 1);
    r = r && consumeToken(b, CRLF);
    r = r && for_statement_3(b, l + 1);
    r = r && consumeToken(b, ENDFOR);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // FOR | FORCHARS | FORITEMS | FORCLIENTS | FORPLAYERS
  private static boolean for_statement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_statement_0")) return false;
    boolean r;
    r = consumeToken(b, FOR);
    if (!r) r = consumeToken(b, FORCHARS);
    if (!r) r = consumeToken(b, FORITEMS);
    if (!r) r = consumeToken(b, FORCLIENTS);
    if (!r) r = consumeToken(b, FORPLAYERS);
    return r;
  }

  // expression?
  private static boolean for_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_statement_1")) return false;
    expression(b, l + 1);
    return true;
  }

  // statement*
  private static boolean for_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_statement_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "for_statement_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (BUILTIN_FUNCTION | IDENTIFIER | property_reference)
  //                  (expression | argument_list)?
  public static boolean function_call(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_call")) return false;
    if (!nextTokenIs(b, "<function call>", BUILTIN_FUNCTION, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_CALL, "<function call>");
    r = function_call_0(b, l + 1);
    r = r && function_call_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // BUILTIN_FUNCTION | IDENTIFIER | property_reference
  private static boolean function_call_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_call_0")) return false;
    boolean r;
    r = consumeToken(b, BUILTIN_FUNCTION);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = property_reference(b, l + 1);
    return r;
  }

  // (expression | argument_list)?
  private static boolean function_call_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_call_1")) return false;
    function_call_1_0(b, l + 1);
    return true;
  }

  // expression | argument_list
  private static boolean function_call_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_call_1_0")) return false;
    boolean r;
    r = expression(b, l + 1);
    if (!r) r = argument_list(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // IF expression CRLF
  //                 statement*
  //                 (ELSEIF expression CRLF statement*)*
  //                 (ELSE CRLF statement*)?
  //                 ENDIF
  public static boolean if_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, CRLF);
    r = r && if_statement_3(b, l + 1);
    r = r && if_statement_4(b, l + 1);
    r = r && if_statement_5(b, l + 1);
    r = r && consumeToken(b, ENDIF);
    exit_section_(b, m, IF_STATEMENT, r);
    return r;
  }

  // statement*
  private static boolean if_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "if_statement_3", c)) break;
    }
    return true;
  }

  // (ELSEIF expression CRLF statement*)*
  private static boolean if_statement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!if_statement_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "if_statement_4", c)) break;
    }
    return true;
  }

  // ELSEIF expression CRLF statement*
  private static boolean if_statement_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSEIF);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, CRLF);
    r = r && if_statement_4_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // statement*
  private static boolean if_statement_4_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_4_0_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "if_statement_4_0_3", c)) break;
    }
    return true;
  }

  // (ELSE CRLF statement*)?
  private static boolean if_statement_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_5")) return false;
    if_statement_5_0(b, l + 1);
    return true;
  }

  // ELSE CRLF statement*
  private static boolean if_statement_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ELSE, CRLF);
    r = r && if_statement_5_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // statement*
  private static boolean if_statement_5_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_5_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "if_statement_5_0_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // section | property | commentRule | CRLF
  static boolean item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item")) return false;
    boolean r;
    r = section(b, l + 1);
    if (!r) r = property(b, l + 1);
    if (!r) r = commentRule(b, l + 1);
    if (!r) r = consumeToken(b, CRLF);
    return r;
  }

  /* ********************************************************** */
  // TYPE | VALUE | CATEGORY | SUBSECTION |
  //                        DESCRIPTION | NAME | ID | ON | DEFNAME
  public static boolean keyword_as_property(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "keyword_as_property")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, KEYWORD_AS_PROPERTY, "<keyword as property>");
    r = consumeToken(b, TYPE);
    if (!r) r = consumeToken(b, VALUE);
    if (!r) r = consumeToken(b, CATEGORY);
    if (!r) r = consumeToken(b, SUBSECTION);
    if (!r) r = consumeToken(b, DESCRIPTION);
    if (!r) r = consumeToken(b, NAME);
    if (!r) r = consumeToken(b, ID);
    if (!r) r = consumeToken(b, ON);
    if (!r) r = consumeToken(b, DEFNAME);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // STRING
  //          | HEX_NUMBER
  //          | FLOAT_NUMBER
  //          | NUMBER
  public static boolean literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL, "<literal>");
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, HEX_NUMBER);
    if (!r) r = consumeToken(b, FLOAT_NUMBER);
    if (!r) r = consumeToken(b, NUMBER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // comparison_expression (AND comparison_expression)*
  public static boolean logical_and_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logical_and_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LOGICAL_AND_EXPRESSION, "<logical and expression>");
    r = comparison_expression(b, l + 1);
    r = r && logical_and_expression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (AND comparison_expression)*
  private static boolean logical_and_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logical_and_expression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!logical_and_expression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "logical_and_expression_1", c)) break;
    }
    return true;
  }

  // AND comparison_expression
  private static boolean logical_and_expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logical_and_expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AND);
    r = r && comparison_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // logical_and_expression (OR logical_and_expression)*
  public static boolean logical_or_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logical_or_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LOGICAL_OR_EXPRESSION, "<logical or expression>");
    r = logical_and_expression(b, l + 1);
    r = r && logical_or_expression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (OR logical_and_expression)*
  private static boolean logical_or_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logical_or_expression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!logical_or_expression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "logical_or_expression_1", c)) break;
    }
    return true;
  }

  // OR logical_and_expression
  private static boolean logical_or_expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logical_or_expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OR);
    r = r && logical_and_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // unary_expression
  //                              ((MULT | DIV | MOD) unary_expression)*
  public static boolean multiplicative_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplicative_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MULTIPLICATIVE_EXPRESSION, "<multiplicative expression>");
    r = unary_expression(b, l + 1);
    r = r && multiplicative_expression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ((MULT | DIV | MOD) unary_expression)*
  private static boolean multiplicative_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplicative_expression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!multiplicative_expression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "multiplicative_expression_1", c)) break;
    }
    return true;
  }

  // (MULT | DIV | MOD) unary_expression
  private static boolean multiplicative_expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplicative_expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = multiplicative_expression_1_0_0(b, l + 1);
    r = r && unary_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // MULT | DIV | MOD
  private static boolean multiplicative_expression_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplicative_expression_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, MULT);
    if (!r) r = consumeToken(b, DIV);
    if (!r) r = consumeToken(b, MOD);
    return r;
  }

  /* ********************************************************** */
  // literal
  //                     | variable
  //                     | property_reference
  //                     | IDENTIFIER
  //                     | function_call
  //                     | LPAREN expression RPAREN
  public static boolean primary_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PRIMARY_EXPRESSION, "<primary expression>");
    r = literal(b, l + 1);
    if (!r) r = variable(b, l + 1);
    if (!r) r = property_reference(b, l + 1);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = function_call(b, l + 1);
    if (!r) r = primary_expression_5(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LPAREN expression RPAREN
  private static boolean primary_expression_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_expression_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // property_key EQUALS property_value
  public static boolean property(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROPERTY, "<property>");
    r = property_key(b, l + 1);
    r = r && consumeToken(b, EQUALS);
    r = r && property_value(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER | keyword_as_property
  public static boolean property_key(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_key")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROPERTY_KEY, "<property key>");
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = keyword_as_property(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER (DOT IDENTIFIER)+
  public static boolean property_reference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_reference")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && property_reference_1(b, l + 1);
    exit_section_(b, m, PROPERTY_REFERENCE, r);
    return r;
  }

  // (DOT IDENTIFIER)+
  private static boolean property_reference_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_reference_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = property_reference_1_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!property_reference_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "property_reference_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // DOT IDENTIFIER
  private static boolean property_reference_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_reference_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expression
  public static boolean property_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROPERTY_VALUE, "<property value>");
    r = expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // RETURN expression?
  public static boolean return_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "return_statement")) return false;
    if (!nextTokenIs(b, RETURN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RETURN);
    r = r && return_statement_1(b, l + 1);
    exit_section_(b, m, RETURN_STATEMENT, r);
    return r;
  }

  // expression?
  private static boolean return_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "return_statement_1")) return false;
    expression(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // item*
  static boolean scpFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scpFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!item(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "scpFile", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // section_headerRule section_body?
  public static boolean section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "section")) return false;
    if (!nextTokenIs(b, SECTION_HEADER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = section_headerRule(b, l + 1);
    r = r && section_1(b, l + 1);
    exit_section_(b, m, SECTION, r);
    return r;
  }

  // section_body?
  private static boolean section_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "section_1")) return false;
    section_body(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (property | statement | commentRule | CRLF)*
  public static boolean section_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "section_body")) return false;
    Marker m = enter_section_(b, l, _NONE_, SECTION_BODY, "<section body>");
    while (true) {
      int c = current_position_(b);
      if (!section_body_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "section_body", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // property | statement | commentRule | CRLF
  private static boolean section_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "section_body_0")) return false;
    boolean r;
    r = property(b, l + 1);
    if (!r) r = statement(b, l + 1);
    if (!r) r = commentRule(b, l + 1);
    if (!r) r = consumeToken(b, CRLF);
    return r;
  }

  /* ********************************************************** */
  // SECTION_HEADER
  public static boolean section_headerRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "section_headerRule")) return false;
    if (!nextTokenIs(b, SECTION_HEADER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SECTION_HEADER);
    exit_section_(b, m, SECTION_HEADER_RULE, r);
    return r;
  }

  /* ********************************************************** */
  // if_statement
  //            | while_statement
  //            | for_statement
  //            | return_statement
  //            | break_statement
  //            | continue_statement
  //            | function_call
  //            | assignment
  public static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = if_statement(b, l + 1);
    if (!r) r = while_statement(b, l + 1);
    if (!r) r = for_statement(b, l + 1);
    if (!r) r = return_statement(b, l + 1);
    if (!r) r = break_statement(b, l + 1);
    if (!r) r = continue_statement(b, l + 1);
    if (!r) r = function_call(b, l + 1);
    if (!r) r = assignment(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (NOT | MINUS)? primary_expression
  public static boolean unary_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNARY_EXPRESSION, "<unary expression>");
    r = unary_expression_0(b, l + 1);
    r = r && primary_expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (NOT | MINUS)?
  private static boolean unary_expression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary_expression_0")) return false;
    unary_expression_0_0(b, l + 1);
    return true;
  }

  // NOT | MINUS
  private static boolean unary_expression_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary_expression_0_0")) return false;
    boolean r;
    r = consumeToken(b, NOT);
    if (!r) r = consumeToken(b, MINUS);
    return r;
  }

  /* ********************************************************** */
  // VARIABLE_START variable_path VARIABLE_END
  public static boolean variable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable")) return false;
    if (!nextTokenIs(b, VARIABLE_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VARIABLE_START);
    r = r && variable_path(b, l + 1);
    r = r && consumeToken(b, VARIABLE_END);
    exit_section_(b, m, VARIABLE, r);
    return r;
  }

  /* ********************************************************** */
  // VARIABLE_CONTENT (DOT VARIABLE_CONTENT)*
  public static boolean variable_path(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_path")) return false;
    if (!nextTokenIs(b, VARIABLE_CONTENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VARIABLE_CONTENT);
    r = r && variable_path_1(b, l + 1);
    exit_section_(b, m, VARIABLE_PATH, r);
    return r;
  }

  // (DOT VARIABLE_CONTENT)*
  private static boolean variable_path_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_path_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!variable_path_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "variable_path_1", c)) break;
    }
    return true;
  }

  // DOT VARIABLE_CONTENT
  private static boolean variable_path_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_path_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, VARIABLE_CONTENT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // WHILE expression CRLF
  //                    statement*
  //                    ENDWHILE
  public static boolean while_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "while_statement")) return false;
    if (!nextTokenIs(b, WHILE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHILE);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, CRLF);
    r = r && while_statement_3(b, l + 1);
    r = r && consumeToken(b, ENDWHILE);
    exit_section_(b, m, WHILE_STATEMENT, r);
    return r;
  }

  // statement*
  private static boolean while_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "while_statement_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "while_statement_3", c)) break;
    }
    return true;
  }

}
