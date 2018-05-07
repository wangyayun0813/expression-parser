package com.test.ruleEngine.token;

/**
 * Created by 王亚运 on 2018/5/5.
 * 右括号
 */
public class RParenthesesToken extends Token {
    public RParenthesesToken(String token) {
        super(token);
    }

    @Override
    public TokenType getTokenType() {
        return TokenType.RParentheses;
    }
}
