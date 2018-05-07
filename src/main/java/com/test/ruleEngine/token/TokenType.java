package com.test.ruleEngine.token;

/**
 * Created by 王亚运 on 2018/5/5.
 * level 越大优先级越高
 */
public enum TokenType {
    LParentheses(9, "("),// (
    RParentheses(9, ")"), // )

    Not(8, "!", "not"),/// ! (逻辑非)


    Mod(7, "%", "mod"),//% (求模,取余)
    MultiPly(7, "*"),// *
    Divide(7, "/", "div"),// /

    Plus(6, "+", "add", "plus"),// +
    Subtract(6, "-", "minus"), // -

    GT(5, ">", "gt"), /// > (大于)
    LT(5, "<", "lt"), /// < (小于)
    GTOrEqual(5, ">=", "ge"),/// >= (大于等于)
    LTOrEqual(5, "<=", "le"), /// <= (小于等于)
    In(5, "in"),//包含
    NotIn(5, "not in"),//不包含
    StartWith(5, ""),//以什么开始
    EndWith(5, ""),//以什么结尾

    Equal(4, "==", "eq"),// == (相等)
    NotEqual(4, "!=", "ne"),/// != 或 <> (不等于)


    And(3, "&&", "&", "and"),// && (逻辑与)
    Or(2, "|", "||", "or"), /// || (逻辑或)

    Numeric(1, null), /// 数值,
    String(1, null),
    Date(1, null),
    Variable(0, null);// 变量

    private String[] tokens;
    private int level;

    TokenType(int level, String... tokens) {
        this.tokens = tokens;
        this.level = level;
    }

    public java.lang.String[] getTokens() {
        return tokens;
    }

    public int getLevel() {
        return level;
    }
}
