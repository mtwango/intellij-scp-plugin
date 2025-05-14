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
%eof{  return;
%eof}

CRLF=\R
WHITE_SPACE=[\ \n\t\f]
FIRST_VALUE_CHARACTER=[^ \n\f\\] | "\\"{CRLF} | "\\".
VALUE_CHARACTER=[^\n\f\\] | "\\"{CRLF} | "\\".
DEFINITION=\[(TYPEDEF|TEMPLATE|AREADEF|ITEMDEF|CHARDEF|EVENTS|FUNCTION) (.*)\]
END_OF_LINE_COMMENT=("//")[^\r\n]*
SEPARATOR=[=]
KEY_CHARACTER=[^=\ \n\t\f\\] | "\\ "
TRIGGER_DEF=ON=@
TRIGGER=(
"Abort"|
"AfterClick"|
"Attack"|
"Buy"|
"CallGuards"|
"CharAttack"|
"CharClick"|
"CharClientTooltip"|
"CharDClick"|
"CharTradeAccepted"|
"Click"|
"ClientTooltip"|
"CliPeriodic"|
"CombatAdd"|
"CombatDelete"|
"CombatEnd"|
"CombatStart"|
"ContextMenuRequest"|
"ContextMenuSelect"|
"Create"|
"Criminal"|
"Damage"|
"DClick"|
"Death"|
"DeathCorpse"|
"Destroy"|
"Dismount"|
"DropOn_Char"|
"DropOn_Ground"|
"DropOn_Item"|
"DropOn_Self"|
"DropOn_Trade"|
"Dye"|
"Eat"|
"EffectAdd"|
"EffectRemove"|
"EffectTick"|
"Effect"|
"Enter"|
"EnvironChange"|
"EquipTest"|
"Equip"|
"Exit"|
"ExpChange"|
"ExpLevelChange"|
"Fail"|
"FameChange"|
"Gain"|
"GetHit"|
"HitMiss"|
"HitParry"|
"HitTry"|
"Hit"|
"HouseDesignCommit"|
"HouseDesignExit"|
"ItemAfterClick"|
"ItemBuy"|
"ItemClick"|
"ItemClientTooltip"|
"ItemContextMenuRequest"|
"ItemContextMenuSelect"|
"ItemCreate"|
"ItemDamage"|
"ItemDClick"|
"ItemDropOn_Char"|
"ItemDropOn_Ground"|
"ItemDropOn_Item"|
"ItemDropOn_Self"|
"ItemEquipTest"|
"ItemEquip"|
"ItemPickUp_Ground"|
"ItemPickUp_Pack"|
"ItemPickUp_Self"|
"ItemPickUp_Stack"|
"ItemSell"|
"ItemSmelt"|
"ItemSpellEffect"|
"ItemStep"|
"ItemTargOn_Cancel"|
"ItemTargOn_Char"|
"ItemTargOn_Ground"|
"ItemTargOn_Item"|
"ItemToolTip"|
"ItemUnEquip"|
"Jailed"|
"KarmaChange"|
"Kill"|
"Login"|
"Logout"|
"Mount"|
"MurderDecay"|
"MurderMark"|
"NotoSend"|
"NPCAcceptItem"|
"NpcActCast"|
"NPCActFight"|
"NPCActFollow"|
"NPCAction"|
"NPCActWander"|
"NPCHearGreeting"|
"NPCHearUnknown"|
"NPCLookAtChar"|
"NPCLookAtItem"|
"NPCLostTeleport"|
"NPCRefuseItem"|
"NPCRestock"|
"NPCSeeNewPlayer"|
"NPCSeeWantItem"|
"NPCSpecialAction"|
"PartyDisband"|
"PartyInvite"|
"PartyLeave"|
"PartyRemove"|
"PayGold"|
"PersonalSpace"|
"PetDesert"|
"PickUp_Ground"|
"PickUp_Pack"|
"PickUp_Self"|
"PickUp_Stack"|
"PreStart"|
"Profile"|
"ReceiveItem"|
"Redeed"|
"RegenStat"|
"RegionEnter"|
"RegionLeave"|
"RegionResourceFound"|
"RegPeriodic"|
"Rename"|
"ResourceFound"|
"ResourceGather"|
"ResourceTest"|
"Resurrect"|
"SeeCrime"|
"SeeHidden"|
"SeeSnoop"|
"Select"|
"Sell"|
"SkillAbort"|
"SkillChange"|
"SkillFail"|
"SkillGain"|
"SkillMakeItem"|
"SkillMenu"|
"SkillPreStart"|
"SkillSelect"|
"SkillStart"|
"SkillSuccess"|
"SkillUseQuick"|
"SkillWait"|
"Smelt"|
"SpellBook"|
"SpellCast"|
"SpellEffectAdd"|
"SpellEffectRemove"|
"SpellEffectTick"|
"SpellEffect"|
"SpellFail"|
"SpellSelect"|
"SpellSuccess"|
"SpellTargetCancel"|
"Start"|
"StatChange"|
"Step"|
"StepStealth"|
"Success"|
"TargOn_Cancel"|
"TargOn_Char"|
"TargOn_Ground"|
"TargOn_Item"|
"Timer"|
"ToggleFlying"|
"ToolTip"|
"TradeAccepted"|
"TradeClose"|
"TradeCreate"|
"UnEquip"|
"UseQuick"|
"UserBugReport"|
"UserChatButton"|
"UserExtCmd"|
"UserExWalkLimit"|
"UserGuildButton"|
"UserKRToolbar"|
"UserMailBag"|
"UserQuestArrowClick"|
"UserQuestButton"|
"UserSkills"|
"UserSpecialMove"|
"UserStats"|
"UserVirtue"|
"UserVirtueInvoke"|
"UserWarmode"|
"Wait"
)

%state WAITING_VALUE

%%

<YYINITIAL> {DEFINITION} { yybegin(YYINITIAL); return SphereScriptTypes.TRIGGER; }

<YYINITIAL> {TRIGGER_DEF}?{TRIGGER} { yybegin(YYINITIAL); return SphereScriptTypes.TRIGGER; }

<YYINITIAL> {END_OF_LINE_COMMENT}                           { yybegin(YYINITIAL); return SphereScriptTypes.COMMENT; }

<YYINITIAL> {KEY_CHARACTER}+                                { yybegin(YYINITIAL); return SphereScriptTypes.KEY; }

<YYINITIAL> {SEPARATOR}                                     { yybegin(WAITING_VALUE); return SphereScriptTypes.SEPARATOR; }

<WAITING_VALUE> {CRLF}({CRLF}|{WHITE_SPACE})+               { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

<WAITING_VALUE> {WHITE_SPACE}+                              { yybegin(WAITING_VALUE); return TokenType.WHITE_SPACE; }

<WAITING_VALUE> {FIRST_VALUE_CHARACTER}{VALUE_CHARACTER}*   { yybegin(YYINITIAL); return SphereScriptTypes.VALUE; }

({CRLF}|{WHITE_SPACE})+                                     { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

[^]                                                         { return TokenType.BAD_CHARACTER; }
