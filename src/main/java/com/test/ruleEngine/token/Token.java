package com.test.ruleEngine.token;

/**
 * Created by 王亚运 on 2018/5/5.
 */
public abstract class Token {
    protected String token;

    public Token(String token) {
        this.token = token;
    }

    public abstract TokenType getTokenType();

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
