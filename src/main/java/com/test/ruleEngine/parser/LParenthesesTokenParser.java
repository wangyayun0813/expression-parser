package com.test.ruleEngine.parser;

import com.test.ruleEngine.token.LParenthesesToken;
import com.test.ruleEngine.token.Token;
import com.test.ruleEngine.token.TokenType;

import java.util.Arrays;

/**
 * Created by 王亚运 on 2018/5/5.
 */
public class LParenthesesTokenParser extends TokenParserChain{
    public LParenthesesTokenParser(TokenParserChain parserChain) {
        super(parserChain);
    }

    @Override
    protected Token createToken(String expression, String tokenStr, int position) {
        return new LParenthesesToken(tokenStr);
    }

    @Override
    protected boolean isToken(String expression, String s, int position) {
        return Arrays.asList(TokenType.LParentheses.getTokens()).contains(s.toLowerCase());
    }
}
