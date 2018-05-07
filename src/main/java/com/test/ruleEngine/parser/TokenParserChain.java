package com.test.ruleEngine.parser;

import com.test.ruleEngine.token.Token;

/**
 * Created by 王亚运 on 2018/5/5.
 */
public abstract class TokenParserChain {
    protected TokenParserChain parserChain;
    protected Token prevToken;

    public TokenParserChain(TokenParserChain parserChain) {
        this.parserChain = parserChain;
    }

    public Token parse(String expression, int position, Token prevToken) {
        this.prevToken = prevToken;
        Token token = readToken(expression, position);
        if (null == token && null != parserChain)
            return this.parserChain.parse(expression, position, prevToken);
        return token;
    }

    protected abstract Token createToken(String expression, String tokenStr, int position);

    private Token readToken(String expression, int position) {
        StringBuffer sb = new StringBuffer();
        boolean isToken = false;
        for(; position <= expression.length()-1; position++)
        {
            char c = expression.charAt(position);
            if(Character.isWhitespace(c))
                break;
            sb.append(c);
            isToken = isToken(expression, sb.toString(), position);
            if (isToken) {
                break;
            }
        }
        return isToken ? createToken(expression, sb.toString(), position) : null;
    }

    protected abstract boolean isToken(String expression, String s, int position);
}
