package com.test.ruleEngine.token;

/**
 * Created by 王亚运 on 2018/5/5.
 */
public class LogicalOperatorToken extends Token {
    protected TokenType tokenType;
    public LogicalOperatorToken(TokenType tokenType, String token) {
        super(token);
        this.tokenType = tokenType;
    }

    @Override
    public TokenType getTokenType() {
        return tokenType;
    }
}
