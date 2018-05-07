package com.test.ruleEngine.token;

import static com.test.ruleEngine.token.TokenType.Numeric;

/**
 * Created by 王亚运 on 2018/5/5.
 */
public class NumericToken extends LeafToken<Float> {
    public NumericToken(String token) {
        super(token);
    }

    @Override
    public Float getValue() {
        return Float.valueOf(token);
    }

    @Override
    public TokenType getTokenType() {
        return Numeric;
    }
}
