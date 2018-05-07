package com.test.ruleEngine.expression;

import com.test.ruleEngine.token.NumericToken;
import com.test.ruleEngine.token.Token;

/**
 * Created by 王亚运 on 2018/5/6.
 */
public class NumericExpression extends Expression<Float> {
    public NumericExpression(Token token) {
        super(null, null, token);
    }

    @Override
    public Float getValue() {
        return ((NumericToken)getToken()).getValue();
    }
}
