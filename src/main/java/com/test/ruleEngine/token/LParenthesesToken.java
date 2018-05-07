package com.test.ruleEngine.token;

/**
 * Created by 王亚运 on 2018/5/5.
 */
public class LParenthesesToken extends Token {
    public LParenthesesToken(String token) {
        super(token);
    }

    @Override
    public TokenType getTokenType() {
        return TokenType.LParentheses;
    }
}
