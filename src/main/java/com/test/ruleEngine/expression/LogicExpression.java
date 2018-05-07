package com.test.ruleEngine.expression;

import com.test.ruleEngine.token.LogicalOperatorToken;

/**
 * Created by 王亚运 on 2018/5/5.
 */
public class LogicExpression extends Expression {
    public LogicExpression(Expression left, Expression right, LogicalOperatorToken token) {
        super(left, right, token);
    }

    @Override
    public Object getValue() {
        return null;
    }
}
