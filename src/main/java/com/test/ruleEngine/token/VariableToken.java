package com.test.ruleEngine.token;

/**
 * Created by 王亚运 on 2018/5/5.
 * 变量Token
 */
public class VariableToken extends LeafToken{
    public VariableToken(String token) {
        super(token);
    }

    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public TokenType getTokenType() {
        return TokenType.Variable;
    }
}
