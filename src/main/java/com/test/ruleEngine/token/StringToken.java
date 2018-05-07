package com.test.ruleEngine.token;

/**
 * Created by 王亚运 on 2018/5/5.
 */
public class StringToken extends LeafToken<String> {
    public StringToken(String token) {
        super(token);
    }

    @Override
    public String getValue() {
        return token;
    }

    @Override
    public TokenType getTokenType() {
        return TokenType.String;
    }
}
