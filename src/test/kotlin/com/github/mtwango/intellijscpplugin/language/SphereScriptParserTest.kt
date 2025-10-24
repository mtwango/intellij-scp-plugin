package com.github.mtwango.intellijscpplugin.language

import com.intellij.testFramework.ParsingTestCase

class SphereScriptParserTest : ParsingTestCase("testData", "scp", SphereScriptParserDefinition()) {
    override fun getTestDataPath(): String {
        return "src/test/resources"
    }

    fun testBasicSections() {
        doTest(true)
    }

    fun testControlStructures() {
        doTest(true)
    }

    fun testVariablesAndTriggers() {
        doTest(true)
    }

    fun testComplexProperties() {
        doTest(true)
    }
}