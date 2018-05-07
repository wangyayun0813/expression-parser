package com.test.ruleEngine.parser;

import com.pactera.huawei.multi.iot.ruleEngine.token.*;
import com.test.ruleEngine.common.StringUtil;
import com.pactera.ruleEngine.token.*;
import com.test.ruleEngine.token.*;

/**
 * Created by 王亚运 on 2018/5/5.
 */
public class LeafTokenParser extends TokenParserChain {
    private static final String operators = "+-*/)><&|%";
    public LeafTokenParser(TokenParserChain parserChain) {
        super(parserChain);
    }

    @Override
    protected Token createToken(String expression, String tokenStr, int position) {
        if(tokenStr.startsWith("\"") && tokenStr.endsWith("\"") && tokenStr.length()>2)
            return new StringToken(tokenStr);
        else if(StringUtil.isNumerics(tokenStr))
            return new NumericToken(tokenStr);
        else if(StringUtil.isDatetime(tokenStr))
            return new DateToken(tokenStr);
        return new VariableToken(tokenStr);
    }

    @Override
    protected boolean isToken(String expression, String s, int position) {
        int len = expression.length() -1;
        boolean isLast = position == len;
        boolean isWhiteSpace = false;
        boolean nextIsTag = false;
        if(!isLast){
            char c = expression.charAt(position + 1);
            isWhiteSpace = Character.isWhitespace(c);
            String next = String.valueOf(c);
            nextIsTag = operators.contains(next);
        }
        return !StringUtil.isBlank(s) && (isLast || isWhiteSpace || nextIsTag);
    }
}
