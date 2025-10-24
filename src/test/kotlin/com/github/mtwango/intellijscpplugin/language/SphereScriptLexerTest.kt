package com.github.mtwango.intellijscpplugin.language

import com.intellij.testFramework.fixtures.BasePlatformTestCase
import com.github.mtwango.intellijscpplugin.language.psi.SphereScriptTypes

class SphereScriptLexerTest : BasePlatformTestCase() {

    fun testSectionHeader() {
        val code = "[ITEMDEF i_gold]"
        val lexer = SphereScriptLexerAdapter()
        lexer.start(code)

        assertEquals(SphereScriptTypes.SECTION_HEADER, lexer.tokenType)
        assertEquals("[ITEMDEF i_gold]", lexer.tokenText)
    }

    fun testProperty() {
        val code = "NAME=Gold Coins"
        val lexer = SphereScriptLexerAdapter()
        lexer.start(code)

        assertEquals(SphereScriptTypes.NAME, lexer.tokenType)
        lexer.advance()
        assertEquals(SphereScriptTypes.EQUALS, lexer.tokenType)
        lexer.advance()
        assertEquals(SphereScriptTypes.IDENTIFIER, lexer.tokenType)
        assertEquals("Gold", lexer.tokenText)
    }

    fun testVariable() {
        val code = "<SRC.ACCOUNT.PLEVEL>"
        val lexer = SphereScriptLexerAdapter()
        lexer.start(code)

        assertEquals(SphereScriptTypes.VARIABLE_START, lexer.tokenType)
        lexer.advance()
        assertEquals(SphereScriptTypes.VARIABLE_CONTENT, lexer.tokenType)
        assertEquals("SRC.ACCOUNT.PLEVEL", lexer.tokenText)
        lexer.advance()
        assertEquals(SphereScriptTypes.VARIABLE_END, lexer.tokenType)
    }

    fun testHexNumber() {
        val code = "0xeed"
        val lexer = SphereScriptLexerAdapter()
        lexer.start(code)

        assertEquals(SphereScriptTypes.HEX_NUMBER, lexer.tokenType)
        assertEquals("0xeed", lexer.tokenText)
    }

    fun testComments() {
        val code = """
            // Single line comment
            /* Multi-line
               comment */
        """.trimIndent()
        val lexer = SphereScriptLexerAdapter()
        lexer.start(code)

        assertEquals(SphereScriptTypes.COMMENT, lexer.tokenType)
        lexer.advance()
        assertEquals(SphereScriptTypes.CRLF, lexer.tokenType)
        lexer.advance()
        assertEquals(SphereScriptTypes.COMMENT, lexer.tokenType)
    }

    fun testTrigger() {
        val code = "@Create"
        val lexer = SphereScriptLexerAdapter()
        lexer.start(code)

        assertEquals(SphereScriptTypes.TRIGGER, lexer.tokenType)
        assertEquals("@Create", lexer.tokenText)
    }

    fun testControlStructures() {
        val code = """
            IF condition
            ELSEIF other_condition
            ELSE
            ENDIF
        """.trimIndent()
        val lexer = SphereScriptLexerAdapter()
        lexer.start(code)

        assertEquals(SphereScriptTypes.IF, lexer.tokenType)
    }
}