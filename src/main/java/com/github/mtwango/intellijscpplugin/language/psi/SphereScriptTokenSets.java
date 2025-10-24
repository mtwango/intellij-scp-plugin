package com.github.mtwango.intellijscpplugin.language.psi;

import com.intellij.psi.TokenType;
import com.intellij.psi.tree.TokenSet;
import com.github.mtwango.intellijscpplugin.language.psi.SphereScriptTypes;


public interface SphereScriptTokenSets {
    TokenSet COMMENTS = TokenSet.create(SphereScriptTypes.COMMENT);

    TokenSet WHITESPACES = TokenSet.create(TokenType.WHITE_SPACE, SphereScriptTypes.CRLF);

    TokenSet STRINGS = TokenSet.create(SphereScriptTypes.STRING);

    TokenSet NUMBERS = TokenSet.create(
            SphereScriptTypes.NUMBER,
            SphereScriptTypes.HEX_NUMBER,
            SphereScriptTypes.FLOAT_NUMBER
    );

    TokenSet KEYWORDS = TokenSet.create(
            SphereScriptTypes.IF, SphereScriptTypes.ELSEIF, SphereScriptTypes.ELSE, SphereScriptTypes.ENDIF,
            SphereScriptTypes.WHILE, SphereScriptTypes.ENDWHILE,
            SphereScriptTypes.FOR, SphereScriptTypes.ENDFOR,
            SphereScriptTypes.FORCHARS, SphereScriptTypes.FORITEMS, SphereScriptTypes.FORCLIENTS, SphereScriptTypes.FORPLAYERS,
            SphereScriptTypes.RETURN, SphereScriptTypes.BREAK, SphereScriptTypes.CONTINUE,
            SphereScriptTypes.DEFNAME, SphereScriptTypes.ITEMDEF, SphereScriptTypes.CHARDEF,
            SphereScriptTypes.TYPEDEF, SphereScriptTypes.EVENTS, SphereScriptTypes.FUNCTION,
            SphereScriptTypes.TEMPLATE, SphereScriptTypes.AREADEF, SphereScriptTypes.ROOMDEF, SphereScriptTypes.REGIONTYPE
    );

    TokenSet OPERATORS = TokenSet.create(
            SphereScriptTypes.EQUALS, SphereScriptTypes.LT, SphereScriptTypes.GT,
            SphereScriptTypes.LE, SphereScriptTypes.GE, SphereScriptTypes.EQ, SphereScriptTypes.NE,
            SphereScriptTypes.AND, SphereScriptTypes.OR, SphereScriptTypes.NOT,
            SphereScriptTypes.PLUS, SphereScriptTypes.MINUS, SphereScriptTypes.MULT, SphereScriptTypes.DIV, SphereScriptTypes.MOD
    );

    TokenSet PROPERTY_KEYS = TokenSet.create(
            SphereScriptTypes.ON, SphereScriptTypes.TYPE, SphereScriptTypes.VALUE,
            SphereScriptTypes.CATEGORY, SphereScriptTypes.SUBSECTION, SphereScriptTypes.DESCRIPTION,
            SphereScriptTypes.NAME, SphereScriptTypes.ID
    );

    TokenSet SECTION_TYPES = TokenSet.create(
            SphereScriptTypes.ITEMDEF, SphereScriptTypes.CHARDEF, SphereScriptTypes.TYPEDEF,
            SphereScriptTypes.EVENTS, SphereScriptTypes.FUNCTION, SphereScriptTypes.TEMPLATE,
            SphereScriptTypes.AREADEF, SphereScriptTypes.ROOMDEF, SphereScriptTypes.REGIONTYPE
    );
}
