package com.test.ruleEngine.expression;

import com.test.ruleEngine.token.LogicalOperatorToken;
import com.test.ruleEngine.token.TokenType;

/**
 * Created by 王亚运 on 2018/5/5.
 */
public class ArithmeticExpression extends Expression<Float> {
    public ArithmeticExpression(Expression left, Expression right, LogicalOperatorToken token) {
        super(left, right, token);
    }


    @Override
    public Float getValue() {
        Float left = (Float) getLeft().getValue();
        Float right;
        if(null != getRight())
            right = (Float) getRight().getValue();
        switch (getToken().getTokenType())
        {
            case TokenType.Mod:
                break;
            case TokenType.Subtract:
                break;
            case TokenType.MultiPly:
                break;
            case TokenType.Plus:
                break;
            case TokenType.Divide:
                break;
        }
        return null;
    }
}
