package com.test.ruleEngine.expression;

import com.test.ruleEngine.token.Token;

/**
 * Created by 王亚运 on 2018/5/6.
 */
public class RelationExpression extends Expression<Boolean> {
    public RelationExpression(Expression left, Expression right, Token token) {
        super(left, right, token);
    }

    @Override
    public Boolean getValue() {
        return null;
    }
}
