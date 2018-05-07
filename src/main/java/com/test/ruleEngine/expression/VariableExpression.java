package com.test.ruleEngine.expression;

import com.test.ruleEngine.token.Token;

/**
 * Created by 王亚运 on 2018/5/6.
 */
public class VariableExpression extends Expression {
    public VariableExpression(Token token) {
        super(null, null, token);
    }

    @Override
    public Object getValue() {
        return null;
    }
}
