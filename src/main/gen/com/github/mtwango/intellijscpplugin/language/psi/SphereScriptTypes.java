// This is a generated file. Not intended for manual editing.
package com.github.mtwango.intellijscpplugin.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.mtwango.intellijscpplugin.language.psi.impl.*;

public interface SphereScriptTypes {

  IElementType ADDITIVE_EXPRESSION = new SphereScriptElementType("ADDITIVE_EXPRESSION");
  IElementType ARGUMENT_LIST = new SphereScriptElementType("ARGUMENT_LIST");
  IElementType ASSIGNMENT = new SphereScriptElementType("ASSIGNMENT");
  IElementType BREAK_STATEMENT = new SphereScriptElementType("BREAK_STATEMENT");
  IElementType COMMENT_RULE = new SphereScriptElementType("COMMENT_RULE");
  IElementType COMPARISON_EXPRESSION = new SphereScriptElementType("COMPARISON_EXPRESSION");
  IElementType CONTINUE_STATEMENT = new SphereScriptElementType("CONTINUE_STATEMENT");
  IElementType EXPRESSION = new SphereScriptElementType("EXPRESSION");
  IElementType FOR_STATEMENT = new SphereScriptElementType("FOR_STATEMENT");
  IElementType FUNCTION_CALL = new SphereScriptElementType("FUNCTION_CALL");
  IElementType IF_STATEMENT = new SphereScriptElementType("IF_STATEMENT");
  IElementType KEYWORD_AS_PROPERTY = new SphereScriptElementType("KEYWORD_AS_PROPERTY");
  IElementType LITERAL = new SphereScriptElementType("LITERAL");
  IElementType LOGICAL_AND_EXPRESSION = new SphereScriptElementType("LOGICAL_AND_EXPRESSION");
  IElementType LOGICAL_OR_EXPRESSION = new SphereScriptElementType("LOGICAL_OR_EXPRESSION");
  IElementType MULTIPLICATIVE_EXPRESSION = new SphereScriptElementType("MULTIPLICATIVE_EXPRESSION");
  IElementType PRIMARY_EXPRESSION = new SphereScriptElementType("PRIMARY_EXPRESSION");
  IElementType PROPERTY = new SphereScriptElementType("PROPERTY");
  IElementType PROPERTY_KEY = new SphereScriptElementType("PROPERTY_KEY");
  IElementType PROPERTY_REFERENCE = new SphereScriptElementType("PROPERTY_REFERENCE");
  IElementType PROPERTY_VALUE = new SphereScriptElementType("PROPERTY_VALUE");
  IElementType RETURN_STATEMENT = new SphereScriptElementType("RETURN_STATEMENT");
  IElementType SECTION = new SphereScriptElementType("SECTION");
  IElementType SECTION_BODY = new SphereScriptElementType("SECTION_BODY");
  IElementType SECTION_HEADER_RULE = new SphereScriptElementType("SECTION_HEADER_RULE");
  IElementType STATEMENT = new SphereScriptElementType("STATEMENT");
  IElementType UNARY_EXPRESSION = new SphereScriptElementType("UNARY_EXPRESSION");
  IElementType VARIABLE = new SphereScriptElementType("VARIABLE");
  IElementType VARIABLE_PATH = new SphereScriptElementType("VARIABLE_PATH");
  IElementType WHILE_STATEMENT = new SphereScriptElementType("WHILE_STATEMENT");

  IElementType AND = new SphereScriptTokenType("&&");
  IElementType AREADEF = new SphereScriptTokenType("AREADEF");
  IElementType BREAK = new SphereScriptTokenType("BREAK");
  IElementType BUILTIN_FUNCTION = new SphereScriptTokenType("BUILTIN_FUNCTION");
  IElementType CATEGORY = new SphereScriptTokenType("CATEGORY");
  IElementType CHARDEF = new SphereScriptTokenType("CHARDEF");
  IElementType COMMA = new SphereScriptTokenType(",");
  IElementType COMMENT = new SphereScriptTokenType("COMMENT");
  IElementType CONTINUE = new SphereScriptTokenType("CONTINUE");
  IElementType CRLF = new SphereScriptTokenType("CRLF");
  IElementType DEFNAME = new SphereScriptTokenType("DEFNAME");
  IElementType DESCRIPTION = new SphereScriptTokenType("DESCRIPTION");
  IElementType DIV = new SphereScriptTokenType("/");
  IElementType DOT = new SphereScriptTokenType(".");
  IElementType ELSE = new SphereScriptTokenType("ELSE");
  IElementType ELSEIF = new SphereScriptTokenType("ELSEIF");
  IElementType ENDFOR = new SphereScriptTokenType("ENDFOR");
  IElementType ENDIF = new SphereScriptTokenType("ENDIF");
  IElementType ENDWHILE = new SphereScriptTokenType("ENDWHILE");
  IElementType EQ = new SphereScriptTokenType("==");
  IElementType EQUALS = new SphereScriptTokenType("=");
  IElementType EVENTS = new SphereScriptTokenType("EVENTS");
  IElementType FLOAT_NUMBER = new SphereScriptTokenType("FLOAT_NUMBER");
  IElementType FOR = new SphereScriptTokenType("FOR");
  IElementType FORCHARS = new SphereScriptTokenType("FORCHARS");
  IElementType FORCLIENTS = new SphereScriptTokenType("FORCLIENTS");
  IElementType FORITEMS = new SphereScriptTokenType("FORITEMS");
  IElementType FORPLAYERS = new SphereScriptTokenType("FORPLAYERS");
  IElementType FUNCTION = new SphereScriptTokenType("FUNCTION");
  IElementType GE = new SphereScriptTokenType(">=");
  IElementType GT = new SphereScriptTokenType(">");
  IElementType HEX_NUMBER = new SphereScriptTokenType("HEX_NUMBER");
  IElementType ID = new SphereScriptTokenType("ID");
  IElementType IDENTIFIER = new SphereScriptTokenType("IDENTIFIER");
  IElementType IF = new SphereScriptTokenType("IF");
  IElementType ITEMDEF = new SphereScriptTokenType("ITEMDEF");
  IElementType LBRACE = new SphereScriptTokenType("{");
  IElementType LBRACKET = new SphereScriptTokenType("[");
  IElementType LE = new SphereScriptTokenType("<=");
  IElementType LPAREN = new SphereScriptTokenType("(");
  IElementType LT = new SphereScriptTokenType("<");
  IElementType MINUS = new SphereScriptTokenType("-");
  IElementType MOD = new SphereScriptTokenType("%");
  IElementType MULT = new SphereScriptTokenType("*");
  IElementType NAME = new SphereScriptTokenType("NAME");
  IElementType NE = new SphereScriptTokenType("!=");
  IElementType NOT = new SphereScriptTokenType("!");
  IElementType NUMBER = new SphereScriptTokenType("NUMBER");
  IElementType ON = new SphereScriptTokenType("ON");
  IElementType OR = new SphereScriptTokenType("||");
  IElementType PLUS = new SphereScriptTokenType("+");
  IElementType RBRACE = new SphereScriptTokenType("}");
  IElementType RBRACKET = new SphereScriptTokenType("]");
  IElementType REGIONTYPE = new SphereScriptTokenType("REGIONTYPE");
  IElementType RETURN = new SphereScriptTokenType("RETURN");
  IElementType ROOMDEF = new SphereScriptTokenType("ROOMDEF");
  IElementType RPAREN = new SphereScriptTokenType(")");
  IElementType SECTION_HEADER = new SphereScriptTokenType("SECTION_HEADER");
  IElementType SEMICOLON = new SphereScriptTokenType(";");
  IElementType STRING = new SphereScriptTokenType("STRING");
  IElementType SUBSECTION = new SphereScriptTokenType("SUBSECTION");
  IElementType TEMPLATE = new SphereScriptTokenType("TEMPLATE");
  IElementType TRIGGER = new SphereScriptTokenType("TRIGGER");
  IElementType TYPE = new SphereScriptTokenType("TYPE");
  IElementType TYPEDEF = new SphereScriptTokenType("TYPEDEF");
  IElementType VALUE = new SphereScriptTokenType("VALUE");
  IElementType VARIABLE_CONTENT = new SphereScriptTokenType("VARIABLE_CONTENT");
  IElementType VARIABLE_END = new SphereScriptTokenType("VARIABLE_END");
  IElementType VARIABLE_START = new SphereScriptTokenType("VARIABLE_START");
  IElementType WHILE = new SphereScriptTokenType("WHILE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ADDITIVE_EXPRESSION) {
        return new SphereScriptAdditiveExpressionImpl(node);
      }
      else if (type == ARGUMENT_LIST) {
        return new SphereScriptArgumentListImpl(node);
      }
      else if (type == ASSIGNMENT) {
        return new SphereScriptAssignmentImpl(node);
      }
      else if (type == BREAK_STATEMENT) {
        return new SphereScriptBreakStatementImpl(node);
      }
      else if (type == COMMENT_RULE) {
        return new SphereScriptCommentRuleImpl(node);
      }
      else if (type == COMPARISON_EXPRESSION) {
        return new SphereScriptComparisonExpressionImpl(node);
      }
      else if (type == CONTINUE_STATEMENT) {
        return new SphereScriptContinueStatementImpl(node);
      }
      else if (type == EXPRESSION) {
        return new SphereScriptExpressionImpl(node);
      }
      else if (type == FOR_STATEMENT) {
        return new SphereScriptForStatementImpl(node);
      }
      else if (type == FUNCTION_CALL) {
        return new SphereScriptFunctionCallImpl(node);
      }
      else if (type == IF_STATEMENT) {
        return new SphereScriptIfStatementImpl(node);
      }
      else if (type == KEYWORD_AS_PROPERTY) {
        return new SphereScriptKeywordAsPropertyImpl(node);
      }
      else if (type == LITERAL) {
        return new SphereScriptLiteralImpl(node);
      }
      else if (type == LOGICAL_AND_EXPRESSION) {
        return new SphereScriptLogicalAndExpressionImpl(node);
      }
      else if (type == LOGICAL_OR_EXPRESSION) {
        return new SphereScriptLogicalOrExpressionImpl(node);
      }
      else if (type == MULTIPLICATIVE_EXPRESSION) {
        return new SphereScriptMultiplicativeExpressionImpl(node);
      }
      else if (type == PRIMARY_EXPRESSION) {
        return new SphereScriptPrimaryExpressionImpl(node);
      }
      else if (type == PROPERTY) {
        return new SphereScriptPropertyImpl(node);
      }
      else if (type == PROPERTY_KEY) {
        return new SphereScriptPropertyKeyImpl(node);
      }
      else if (type == PROPERTY_REFERENCE) {
        return new SphereScriptPropertyReferenceImpl(node);
      }
      else if (type == PROPERTY_VALUE) {
        return new SphereScriptPropertyValueImpl(node);
      }
      else if (type == RETURN_STATEMENT) {
        return new SphereScriptReturnStatementImpl(node);
      }
      else if (type == SECTION) {
        return new SphereScriptSectionImpl(node);
      }
      else if (type == SECTION_BODY) {
        return new SphereScriptSectionBodyImpl(node);
      }
      else if (type == SECTION_HEADER_RULE) {
        return new SphereScriptSectionHeaderRuleImpl(node);
      }
      else if (type == STATEMENT) {
        return new SphereScriptStatementImpl(node);
      }
      else if (type == UNARY_EXPRESSION) {
        return new SphereScriptUnaryExpressionImpl(node);
      }
      else if (type == VARIABLE) {
        return new SphereScriptVariableImpl(node);
      }
      else if (type == VARIABLE_PATH) {
        return new SphereScriptVariablePathImpl(node);
      }
      else if (type == WHILE_STATEMENT) {
        return new SphereScriptWhileStatementImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
