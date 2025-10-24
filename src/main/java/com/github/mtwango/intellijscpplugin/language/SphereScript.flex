package com.github.mtwango.intellijscpplugin.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.github.mtwango.intellijscpplugin.language.psi.SphereScriptTypes;
import com.intellij.psi.TokenType;

%%

%class SphereScriptLexer
%implements FlexLexer
%unicode
%caseless
%function advance
%type IElementType
%eof{ return;
%eof}

// Whitespace and line breaks
CRLF = \r|\n|\r\n
WHITE_SPACE = [ \t\f]+
LINE_TERMINATOR = \r|\n|\r\n

// Comments
SINGLE_LINE_COMMENT = "//" [^\r\n]*
MULTI_LINE_COMMENT = "/*" ~"*/"

// Identifiers and numbers
IDENTIFIER = [a-zA-Z_][a-zA-Z0-9_]*
HEX_NUMBER = 0[xX][0-9a-fA-F]+
DECIMAL_NUMBER = [0-9]+
FLOAT_NUMBER = [0-9]+ "." [0-9]+

// Strings
STRING_LITERAL = \" ([^\"\\\r\n] | \\ [^\r\n])* \"?

// Section headers
SECTION_HEADER = "[" [^\]\r\n]+ "]"

// Variables and tags
VARIABLE_START = "<"
VARIABLE_END = ">"
VARIABLE_CONTENT = [^<>\r\n]+

// Operators
EQUALS = "="
COMMA = ","
DOT = "."
SEMICOLON = ";"

// Parentheses and brackets
LPAREN = "("
RPAREN = ")"
LBRACE = "{"
RBRACE = "}"
LBRACKET = "["
RBRACKET = "]"

// Comparison operators
LT = "<"
GT = ">"
LE = "<="
GE = ">="
EQ = "=="
NE = "!="

// Logical operators
AND = "&&"
OR = "||"
NOT = "!"

// Arithmetic operators
PLUS = "+"
MINUS = "-"
MULT = "*"
DIV = "/"
MOD = "%"

%state IN_VARIABLE

%%

<YYINITIAL> {
    // Whitespace
    {WHITE_SPACE}           { return TokenType.WHITE_SPACE; }
    {LINE_TERMINATOR}       { return SphereScriptTypes.CRLF; }

    // Comments
    {SINGLE_LINE_COMMENT}   { return SphereScriptTypes.COMMENT; }
    {MULTI_LINE_COMMENT}    { return SphereScriptTypes.COMMENT; }

    // Section headers
    {SECTION_HEADER}        { return SphereScriptTypes.SECTION_HEADER; }

    // Keywords - Control structures
    "IF"                    { return SphereScriptTypes.IF; }
    "ELSEIF"                { return SphereScriptTypes.ELSEIF; }
    "ELSE"                  { return SphereScriptTypes.ELSE; }
    "ENDIF"                 { return SphereScriptTypes.ENDIF; }
    "WHILE"                 { return SphereScriptTypes.WHILE; }
    "ENDWHILE"              { return SphereScriptTypes.ENDWHILE; }
    "FOR"                   { return SphereScriptTypes.FOR; }
    "ENDFOR"                { return SphereScriptTypes.ENDFOR; }
    "FORCHARS"              { return SphereScriptTypes.FORCHARS; }
    "FORITEMS"              { return SphereScriptTypes.FORITEMS; }
    "FORCLIENTS"            { return SphereScriptTypes.FORCLIENTS; }
    "FORPLAYERS"            { return SphereScriptTypes.FORPLAYERS; }
    "RETURN"                { return SphereScriptTypes.RETURN; }
    "BREAK"                 { return SphereScriptTypes.BREAK; }
    "CONTINUE"              { return SphereScriptTypes.CONTINUE; }

    // Keywords - Definitions
    "DEFNAME"               { return SphereScriptTypes.DEFNAME; }
    "ITEMDEF"               { return SphereScriptTypes.ITEMDEF; }
    "CHARDEF"               { return SphereScriptTypes.CHARDEF; }
    "TYPEDEF"               { return SphereScriptTypes.TYPEDEF; }
    "EVENTS"                { return SphereScriptTypes.EVENTS; }
    "FUNCTION"              { return SphereScriptTypes.FUNCTION; }
    "TEMPLATE"              { return SphereScriptTypes.TEMPLATE; }
    "AREADEF"               { return SphereScriptTypes.AREADEF; }
    "ROOMDEF"               { return SphereScriptTypes.ROOMDEF; }
    "REGIONTYPE"            { return SphereScriptTypes.REGIONTYPE; }

    // Keywords - Common properties
    "ON"                    { return SphereScriptTypes.ON; }
    "TYPE"                  { return SphereScriptTypes.TYPE; }
    "VALUE"                 { return SphereScriptTypes.VALUE; }
    "CATEGORY"              { return SphereScriptTypes.CATEGORY; }
    "SUBSECTION"            { return SphereScriptTypes.SUBSECTION; }
    "DESCRIPTION"           { return SphereScriptTypes.DESCRIPTION; }
    "NAME"                  { return SphereScriptTypes.NAME; }
    "ID"                    { return SphereScriptTypes.ID; }

    // Keywords - Built-in functions
    "SYSMESSAGE"            { return SphereScriptTypes.BUILTIN_FUNCTION; }
    "SERV"                  { return SphereScriptTypes.BUILTIN_FUNCTION; }
    "SRC"                   { return SphereScriptTypes.BUILTIN_FUNCTION; }
    "NEW"                   { return SphereScriptTypes.BUILTIN_FUNCTION; }
    "NEWITEM"               { return SphereScriptTypes.BUILTIN_FUNCTION; }
    "NEWDUPE"               { return SphereScriptTypes.BUILTIN_FUNCTION; }
    "TRYSRC"                { return SphereScriptTypes.BUILTIN_FUNCTION; }
    "TRYSRV"                { return SphereScriptTypes.BUILTIN_FUNCTION; }
    "EVAL"                  { return SphereScriptTypes.BUILTIN_FUNCTION; }
    "BOUNCE"                { return SphereScriptTypes.BUILTIN_FUNCTION; }

    // Keywords - Triggers
    "@ABORT"   { return SphereScriptTypes.TRIGGER; }
    "@ADDMULTI"   { return SphereScriptTypes.TRIGGER; }
    "@ADDOBJ"   { return SphereScriptTypes.TRIGGER; }
    "@ADDREDCANDLE"   { return SphereScriptTypes.TRIGGER; }
    "@ADDWHITECANDLE"   { return SphereScriptTypes.TRIGGER; }
    "@AFKMODE"   { return SphereScriptTypes.TRIGGER; }
    "@AFTERCLICK"   { return SphereScriptTypes.TRIGGER; }
    "@ARROWQUEST_ADD"   { return SphereScriptTypes.TRIGGER; }
    "@ARROWQUEST_CLOSE"   { return SphereScriptTypes.TRIGGER; }
    "@ATTACK"   { return SphereScriptTypes.TRIGGER; }
    "@BUY"   { return SphereScriptTypes.TRIGGER; }
    "@CALLGUARDS"   { return SphereScriptTypes.TRIGGER; }
    "@CARVECORPSE"   { return SphereScriptTypes.TRIGGER; }
    "@CHARATTACK"   { return SphereScriptTypes.TRIGGER; }
    "@CHARCLICK"   { return SphereScriptTypes.TRIGGER; }
    "@CHARCLIENTTOOLTIP"   { return SphereScriptTypes.TRIGGER; }
    "@CHARCLIENTTOOLTIP_AFTERDEFAULT"   { return SphereScriptTypes.TRIGGER; }
    "@CHARDCLICK"   { return SphereScriptTypes.TRIGGER; }
    "@CHARSHOVE"   { return SphereScriptTypes.TRIGGER; }
    "@CHARTRADEACCEPTED"   { return SphereScriptTypes.TRIGGER; }
    "@CLICK"   { return SphereScriptTypes.TRIGGER; }
    "@CLIENTTOOLTIP"   { return SphereScriptTypes.TRIGGER; }
    "@CLIENTTOOLTIP_AFTERDEFAULT"   { return SphereScriptTypes.TRIGGER; }
    "@CLIPERIODIC"   { return SphereScriptTypes.TRIGGER; }
    "@COMBATADD"   { return SphereScriptTypes.TRIGGER; }
    "@COMBATDELETE"   { return SphereScriptTypes.TRIGGER; }
    "@COMBATEND"   { return SphereScriptTypes.TRIGGER; }
    "@COMBATSTART"   { return SphereScriptTypes.TRIGGER; }
    "@COMPLETE"   { return SphereScriptTypes.TRIGGER; }
    "@CONTEXTMENUREQUEST"   { return SphereScriptTypes.TRIGGER; }
    "@CONTEXTMENUSELECT"   { return SphereScriptTypes.TRIGGER; }
    "@CREATE"   { return SphereScriptTypes.TRIGGER; }
    "@CREATELOOT"   { return SphereScriptTypes.TRIGGER; }
    "@CRIMINAL"   { return SphereScriptTypes.TRIGGER; }
    "@DAMAGE"   { return SphereScriptTypes.TRIGGER; }
    "@DCLICK"   { return SphereScriptTypes.TRIGGER; }
    "@DEATH"   { return SphereScriptTypes.TRIGGER; }
    "@DEATHCORPSE"   { return SphereScriptTypes.TRIGGER; }
    "@DELMULTI"   { return SphereScriptTypes.TRIGGER; }
    "@DELOBJ"   { return SphereScriptTypes.TRIGGER; }
    "@DELREDCANDLE"   { return SphereScriptTypes.TRIGGER; }
    "@DELWHITECANDLE"   { return SphereScriptTypes.TRIGGER; }
    "@DESTROY"   { return SphereScriptTypes.TRIGGER; }
    "@DISMOUNT"   { return SphereScriptTypes.TRIGGER; }
    "@DRINK"   { return SphereScriptTypes.TRIGGER; }
    "@DROPON_CHAR"   { return SphereScriptTypes.TRIGGER; }
    "@DROPON_GROUND"   { return SphereScriptTypes.TRIGGER; }
    "@DROPON_ITEM"   { return SphereScriptTypes.TRIGGER; }
    "@DROPON_SELF"   { return SphereScriptTypes.TRIGGER; }
    "@DROPON_TRADE"   { return SphereScriptTypes.TRIGGER; }
    "@DYE"   { return SphereScriptTypes.TRIGGER; }
    "@EAT"   { return SphereScriptTypes.TRIGGER; }
    "@EFFECT"   { return SphereScriptTypes.TRIGGER; }
    "@EFFECTADD"   { return SphereScriptTypes.TRIGGER; }
    "@EFFECTREMOVE"   { return SphereScriptTypes.TRIGGER; }
    "@EFFECTTICK"   { return SphereScriptTypes.TRIGGER; }
    "@ENTER"   { return SphereScriptTypes.TRIGGER; }
    "@ENVIRONCHANGE"   { return SphereScriptTypes.TRIGGER; }
    "@EQUIP"   { return SphereScriptTypes.TRIGGER; }
    "@EQUIPTEST"   { return SphereScriptTypes.TRIGGER; }
    "@EXIT"   { return SphereScriptTypes.TRIGGER; }
    "@EXPCHANGE"   { return SphereScriptTypes.TRIGGER; }
    "@EXPLEVELCHANGE"   { return SphereScriptTypes.TRIGGER; }
    "@FAIL"   { return SphereScriptTypes.TRIGGER; }
    "@FALLING"   { return SphereScriptTypes.TRIGGER; }
    "@FAMECHANGE"   { return SphereScriptTypes.TRIGGER; }
    "@FOLLOWERSUPDATE"   { return SphereScriptTypes.TRIGGER; }
    "@GAIN"   { return SphereScriptTypes.TRIGGER; }
    "@GETHIT"   { return SphereScriptTypes.TRIGGER; }
    "@HIT"   { return SphereScriptTypes.TRIGGER; }
    "@HITCHECK"   { return SphereScriptTypes.TRIGGER; }
    "@HITIGNORE"   { return SphereScriptTypes.TRIGGER; }
    "@HITMISS"   { return SphereScriptTypes.TRIGGER; }
    "@HITPARRY"   { return SphereScriptTypes.TRIGGER; }
    "@HITREACTIVE"   { return SphereScriptTypes.TRIGGER; }
    "@HITTRY"   { return SphereScriptTypes.TRIGGER; }
    "@HOUSEDESIGNBEGIN"   { return SphereScriptTypes.TRIGGER; }
    "@HOUSEDESIGNCOMMIT"   { return SphereScriptTypes.TRIGGER; }
    "@HOUSEDESIGNCOMMITITEM"   { return SphereScriptTypes.TRIGGER; }
    "@HOUSEDESIGNEXIT"   { return SphereScriptTypes.TRIGGER; }
    "@ITEMAFTERCLICK"   { return SphereScriptTypes.TRIGGER; }
    "@ITEMBUY"   { return SphereScriptTypes.TRIGGER; }
    "@ITEMCARVECORPSE"   { return SphereScriptTypes.TRIGGER; }
    "@ITEMCLICK"   { return SphereScriptTypes.TRIGGER; }
    "@ITEMCLIENTTOOLTIP"   { return SphereScriptTypes.TRIGGER; }
    "@ITEMCLIENTTOOLTIP_AFTERDEFAULT"   { return SphereScriptTypes.TRIGGER; }
    "@ITEMCONTEXTMENUREQUEST"   { return SphereScriptTypes.TRIGGER; }
    "@ITEMCONTEXTMENUSELECT"   { return SphereScriptTypes.TRIGGER; }
    "@ITEMCREATE"   { return SphereScriptTypes.TRIGGER; }
    "@ITEMDAMAGE"   { return SphereScriptTypes.TRIGGER; }
    "@ITEMDCLICK"   { return SphereScriptTypes.TRIGGER; }
    "@ITEMDESTROY"   { return SphereScriptTypes.TRIGGER; }
    "@ITEMDROPON_CHAR"   { return SphereScriptTypes.TRIGGER; }
    "@ITEMDROPON_GROUND"   { return SphereScriptTypes.TRIGGER; }
    "@ITEMDROPON_ITEM"   { return SphereScriptTypes.TRIGGER; }
    "@ITEMDROPON_SELF"   { return SphereScriptTypes.TRIGGER; }
    "@ITEMDROPON_TRADE"   { return SphereScriptTypes.TRIGGER; }
    "@ITEMEQUIP"   { return SphereScriptTypes.TRIGGER; }
    "@ITEMEQUIPTEST"   { return SphereScriptTypes.TRIGGER; }
    "@ITEMFIRE"   { return SphereScriptTypes.TRIGGER; }
    "@ITEMMEMORYEQUIP"   { return SphereScriptTypes.TRIGGER; }
    "@ITEMPICKUP_GROUND"   { return SphereScriptTypes.TRIGGER; }
    "@ITEMPICKUP_PACK"   { return SphereScriptTypes.TRIGGER; }
    "@ITEMPICKUP_SELF"   { return SphereScriptTypes.TRIGGER; }
    "@ITEMPICKUP_STACK"   { return SphereScriptTypes.TRIGGER; }
    "@ITEMSELL"   { return SphereScriptTypes.TRIGGER; }
    "@ITEMSMELT"   { return SphereScriptTypes.TRIGGER; }
    "@ITEMSPELL"   { return SphereScriptTypes.TRIGGER; }
    "@ITEMSTEP"   { return SphereScriptTypes.TRIGGER; }
    "@ITEMTARGON_CANCEL"   { return SphereScriptTypes.TRIGGER; }
    "@ITEMTARGON_CHAR"   { return SphereScriptTypes.TRIGGER; }
    "@ITEMTARGON_GROUND"   { return SphereScriptTypes.TRIGGER; }
    "@ITEMTARGON_ITEM"   { return SphereScriptTypes.TRIGGER; }
    "@ITEMTIMER"   { return SphereScriptTypes.TRIGGER; }
    "@ITEMTOOLTIP"   { return SphereScriptTypes.TRIGGER; }
    "@ITEMUNEQUIP"   { return SphereScriptTypes.TRIGGER; }
    "@JAILED"   { return SphereScriptTypes.TRIGGER; }
    "@KARMACHANGE"   { return SphereScriptTypes.TRIGGER; }
    "@KILL"   { return SphereScriptTypes.TRIGGER; }
    "@MEMORYEQUIP"   { return SphereScriptTypes.TRIGGER; }
    "@LEVEL"   { return SphereScriptTypes.TRIGGER; }
    "@LOAD"   { return SphereScriptTypes.TRIGGER; }
    "@LOGIN"   { return SphereScriptTypes.TRIGGER; }
    "@LOGOUT"   { return SphereScriptTypes.TRIGGER; }
    "@MOUNT"   { return SphereScriptTypes.TRIGGER; }
    "@MURDERDECAY"   { return SphereScriptTypes.TRIGGER; }
    "@MURDERMARK"   { return SphereScriptTypes.TRIGGER; }
    "@NOTOSEND"   { return SphereScriptTypes.TRIGGER; }
    "@NPCACCEPTITEM"   { return SphereScriptTypes.TRIGGER; }
    "@NPCACTCAST"   { return SphereScriptTypes.TRIGGER; }
    "@NPCACTFIGHT"   { return SphereScriptTypes.TRIGGER; }
    "@NPCACTFOLLOW"   { return SphereScriptTypes.TRIGGER; }
    "@NPCACTION"   { return SphereScriptTypes.TRIGGER; }
    "@NPCACTWANDER"   { return SphereScriptTypes.TRIGGER; }
    "@NPCHEARGREETING"   { return SphereScriptTypes.TRIGGER; }
    "@NPCHEARUNKNOWN"   { return SphereScriptTypes.TRIGGER; }
    "@NPCLOOKATCHAR"   { return SphereScriptTypes.TRIGGER; }
    "@NPCLOOKATITEM"   { return SphereScriptTypes.TRIGGER; }
    "@NPCLOSTTELEPORT"   { return SphereScriptTypes.TRIGGER; }
    "@NPCREFUSEITEM"   { return SphereScriptTypes.TRIGGER; }
    "@NPCRESTOCK"   { return SphereScriptTypes.TRIGGER; }
    "@NPCSEENEWPLAYER"   { return SphereScriptTypes.TRIGGER; }
    "@NPCSEEWANTITEM"   { return SphereScriptTypes.TRIGGER; }
    "@NPCSPECIALACTION"   { return SphereScriptTypes.TRIGGER; }
    "@PARTYADD"   { return SphereScriptTypes.TRIGGER; }
    "@PARTYDISBAND"   { return SphereScriptTypes.TRIGGER; }
    "@PARTYINVITE"   { return SphereScriptTypes.TRIGGER; }
    "@PARTYLEAVE"   { return SphereScriptTypes.TRIGGER; }
    "@PARTYREMOVE"   { return SphereScriptTypes.TRIGGER; }
    "@PAYGOLD"   { return SphereScriptTypes.TRIGGER; }
    "@PERSONALSPACE"   { return SphereScriptTypes.TRIGGER; }
    "@PETDESERT"   { return SphereScriptTypes.TRIGGER; }
    "@PETRELEASE"   { return SphereScriptTypes.TRIGGER; }
    "@PICKUP_GROUND"   { return SphereScriptTypes.TRIGGER; }
    "@PICKUP_PACK"   { return SphereScriptTypes.TRIGGER; }
    "@PICKUP_SELF"   { return SphereScriptTypes.TRIGGER; }
    "@PICKUP_STACK"   { return SphereScriptTypes.TRIGGER; }
    "@PRESPAWN"   { return SphereScriptTypes.TRIGGER; }
    "@PRESTART"   { return SphereScriptTypes.TRIGGER; }
    "@PROFILE"   { return SphereScriptTypes.TRIGGER; }
    "@RECEIVEITEM"   { return SphereScriptTypes.TRIGGER; }
    "@REDEED"   { return SphereScriptTypes.TRIGGER; }
    "@REGENSTAT"   { return SphereScriptTypes.TRIGGER; }
    "@REGIONENTER"   { return SphereScriptTypes.TRIGGER; }
    "@REGIONLEAVE"   { return SphereScriptTypes.TRIGGER; }
    "@REGIONRESOURCEFOUND"   { return SphereScriptTypes.TRIGGER; }
    "@REGIONRESOURCEGATHER"   { return SphereScriptTypes.TRIGGER; }
    "@REGPERIODIC"   { return SphereScriptTypes.TRIGGER; }
    "@RENAME"   { return SphereScriptTypes.TRIGGER; }
    "@RESOURCEFOUND"   { return SphereScriptTypes.TRIGGER; }
    "@RESOURCEGATHER"   { return SphereScriptTypes.TRIGGER; }
    "@RESOURCETEST"   { return SphereScriptTypes.TRIGGER; }
    "@RESURRECT"   { return SphereScriptTypes.TRIGGER; }
    "@REVEAL"   { return SphereScriptTypes.TRIGGER; }
    "@SEECRIME"   { return SphereScriptTypes.TRIGGER; }
    "@SEEHIDDEN"   { return SphereScriptTypes.TRIGGER; }
    "@SEESNOOP"   { return SphereScriptTypes.TRIGGER; }
    "@SELECT"   { return SphereScriptTypes.TRIGGER; }
    "@SELL"   { return SphereScriptTypes.TRIGGER; }
    "@SENDPAPERDOLL"   { return SphereScriptTypes.TRIGGER; }
    "@SHIP_MOVE"   { return SphereScriptTypes.TRIGGER; }
    "@SHIP_STOP"   { return SphereScriptTypes.TRIGGER; }
    "@SHIP_TURN"   { return SphereScriptTypes.TRIGGER; }
    "@SKILLABORT"   { return SphereScriptTypes.TRIGGER; }
    "@SKILLCHANGE"   { return SphereScriptTypes.TRIGGER; }
    "@SKILLFAIL"   { return SphereScriptTypes.TRIGGER; }
    "@SKILLGAIN"   { return SphereScriptTypes.TRIGGER; }
    "@SKILLMAKEITEM"   { return SphereScriptTypes.TRIGGER; }
    "@SKILLMENU"   { return SphereScriptTypes.TRIGGER; }
    "@SKILLPRESTART"   { return SphereScriptTypes.TRIGGER; }
    "@SKILLSELECT"   { return SphereScriptTypes.TRIGGER; }
    "@SKILLSTART"   { return SphereScriptTypes.TRIGGER; }
    "@SKILLSTROKE"   { return SphereScriptTypes.TRIGGER; }
    "@SKILLSUCCESS"   { return SphereScriptTypes.TRIGGER; }
    "@SKILLTARGETCANCEL"   { return SphereScriptTypes.TRIGGER; }
    "@SKILLUSEQUICK"   { return SphereScriptTypes.TRIGGER; }
    "@SKILLWAIT"   { return SphereScriptTypes.TRIGGER; }
    "@SMELT"   { return SphereScriptTypes.TRIGGER; }
    "@SPAWN"   { return SphereScriptTypes.TRIGGER; }
    "@SPELLBOOK"   { return SphereScriptTypes.TRIGGER; }
    "@SPELLCAST"   { return SphereScriptTypes.TRIGGER; }
    "@SPELLEFFECT"   { return SphereScriptTypes.TRIGGER; }
    "@SPELLEFFECTADD"   { return SphereScriptTypes.TRIGGER; }
    "@SPELLEFFECTREMOVE"   { return SphereScriptTypes.TRIGGER; }
    "@SPELLEFFECTTICK"   { return SphereScriptTypes.TRIGGER; }
    "@SPELLFAIL"   { return SphereScriptTypes.TRIGGER; }
    "@SPELLINTERRUPT"   { return SphereScriptTypes.TRIGGER; }
    "@SPELLSELECT"   { return SphereScriptTypes.TRIGGER; }
    "@SPELLSUCCESS"   { return SphereScriptTypes.TRIGGER; }
    "@SPELLTARGETCANCEL"   { return SphereScriptTypes.TRIGGER; }
    "@START"   { return SphereScriptTypes.TRIGGER; }
    "@STATCHANGE"   { return SphereScriptTypes.TRIGGER; }
    "@STEP"   { return SphereScriptTypes.TRIGGER; }
    "@STEPSTEALTH"   { return SphereScriptTypes.TRIGGER; }
    "@STROKE"   { return SphereScriptTypes.TRIGGER; }
    "@STOP"   { return SphereScriptTypes.TRIGGER; }
    "@SUCCESS"   { return SphereScriptTypes.TRIGGER; }
    "@TARGETCANCEL"   { return SphereScriptTypes.TRIGGER; }
    "@TARGON_CANCEL"   { return SphereScriptTypes.TRIGGER; }
    "@TARGON_CHAR"   { return SphereScriptTypes.TRIGGER; }
    "@TARGON_GROUND"   { return SphereScriptTypes.TRIGGER; }
    "@TARGON_ITEM"   { return SphereScriptTypes.TRIGGER; }
    "@TIMER"   { return SphereScriptTypes.TRIGGER; }
    "@TOGGLEFLYING"   { return SphereScriptTypes.TRIGGER; }
    "@TOOLTIP"   { return SphereScriptTypes.TRIGGER; }
    "@TRADEACCEPTED"   { return SphereScriptTypes.TRIGGER; }
    "@TRADECLOSE"   { return SphereScriptTypes.TRIGGER; }
    "@TRADECREATE"   { return SphereScriptTypes.TRIGGER; }
    "@UNEQUIP"              { return SphereScriptTypes.TRIGGER; }
    "@USEQUICK"             { return SphereScriptTypes.TRIGGER; }
    "@USERBUGREPORT"        { return SphereScriptTypes.TRIGGER; }
    "@USERCHATBUTTON"       { return SphereScriptTypes.TRIGGER; }
    "@USEREXTCMD"           { return SphereScriptTypes.TRIGGER; }
    "@USEREXWALKLIMIT"      { return SphereScriptTypes.TRIGGER; }
    "@USERGUILDBUTTON"      { return SphereScriptTypes.TRIGGER; }
    "@USERKRTOOLBAR"        { return SphereScriptTypes.TRIGGER; }
    "@USERMAILBAG"          { return SphereScriptTypes.TRIGGER; }
    "@USERQUESTARROWCLICK"  { return SphereScriptTypes.TRIGGER; }
    "@USERQUESTBUTTON"      { return SphereScriptTypes.TRIGGER; }
    "@USERSKILLS"           { return SphereScriptTypes.TRIGGER; }
    "@USERSPECIALMOVE"      { return SphereScriptTypes.TRIGGER; }
    "@USERSTATS"            { return SphereScriptTypes.TRIGGER; }
    "@USERULTIMASTOREBUTTON" { return SphereScriptTypes.TRIGGER; }
    "@USERVIRTUE"           { return SphereScriptTypes.TRIGGER; }
    "@USERVIRTUEINVOKE"     { return SphereScriptTypes.TRIGGER; }
    "@USERWARMODE"          { return SphereScriptTypes.TRIGGER; }
    "@WAIT"                 { return SphereScriptTypes.TRIGGER; }


    // Variables
    "<"                     { yybegin(IN_VARIABLE); return SphereScriptTypes.VARIABLE_START; }

    // Operators
    {EQUALS}                { return SphereScriptTypes.EQUALS; }
    {COMMA}                 { return SphereScriptTypes.COMMA; }
    {DOT}                   { return SphereScriptTypes.DOT; }
    {SEMICOLON}             { return SphereScriptTypes.SEMICOLON; }
    {LE}                    { return SphereScriptTypes.LE; }
    {GE}                    { return SphereScriptTypes.GE; }
    {EQ}                    { return SphereScriptTypes.EQ; }
    {NE}                    { return SphereScriptTypes.NE; }
    {LT}                    { return SphereScriptTypes.LT; }
    {GT}                    { return SphereScriptTypes.GT; }
    {AND}                   { return SphereScriptTypes.AND; }
    {OR}                    { return SphereScriptTypes.OR; }
    {NOT}                   { return SphereScriptTypes.NOT; }
    {PLUS}                  { return SphereScriptTypes.PLUS; }
    {MINUS}                 { return SphereScriptTypes.MINUS; }
    {MULT}                  { return SphereScriptTypes.MULT; }
    {DIV}                   { return SphereScriptTypes.DIV; }
    {MOD}                   { return SphereScriptTypes.MOD; }

    // Parentheses and brackets
    {LPAREN}                { return SphereScriptTypes.LPAREN; }
    {RPAREN}                { return SphereScriptTypes.RPAREN; }
    {LBRACE}                { return SphereScriptTypes.LBRACE; }
    {RBRACE}                { return SphereScriptTypes.RBRACE; }
    {LBRACKET}              { return SphereScriptTypes.LBRACKET; }
    {RBRACKET}              { return SphereScriptTypes.RBRACKET; }

    // Literals
    {STRING_LITERAL}        { return SphereScriptTypes.STRING; }
    {HEX_NUMBER}            { return SphereScriptTypes.HEX_NUMBER; }
    {FLOAT_NUMBER}          { return SphereScriptTypes.FLOAT_NUMBER; }
    {DECIMAL_NUMBER}        { return SphereScriptTypes.NUMBER; }

    // Identifiers
    {IDENTIFIER}            { return SphereScriptTypes.IDENTIFIER; }
}

<IN_VARIABLE> {
    {VARIABLE_CONTENT}      { return SphereScriptTypes.VARIABLE_CONTENT; }
    ">"                     { yybegin(YYINITIAL); return SphereScriptTypes.VARIABLE_END; }
    {LINE_TERMINATOR}       { yybegin(YYINITIAL); return SphereScriptTypes.CRLF; }
}

// Catch-all
[^]                         { return TokenType.BAD_CHARACTER; }