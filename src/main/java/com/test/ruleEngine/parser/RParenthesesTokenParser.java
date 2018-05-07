package com.test.ruleEngine.parser;

import com.test.ruleEngine.token.RParenthesesToken;
import com.test.ruleEngine.token.Token;
import com.test.ruleEngine.token.TokenType;

import java.util.Arrays;

/**
 * Created by 王亚运 on 2018/5/5.
 */
public class RParenthesesTokenParser extends TokenParserChain{
    public RParenthesesTokenParser(TokenParserChain parserChain) {
        super(parserChain);
    }

    @Override
    protected Token createToken(String expression, String tokenStr, int position) {
        return new RParenthesesToken(tokenStr);
    }

    @Override
    protected boolean isToken(String expression, String s, int position) {
        return Arrays.asList(TokenType.RParentheses.getTokens()).contains(s.toLowerCase());
    }
}
