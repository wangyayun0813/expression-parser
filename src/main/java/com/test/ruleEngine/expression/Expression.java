package com.test.ruleEngine.expression;

import com.test.ruleEngine.token.Token;

/**
 * Created by 王亚运 on 2018/5/5.
 */
public abstract class Expression<V>{
    private Expression left;
    private Expression right;
    private Token token;
    private V value;

    public Expression(Expression left, Expression right, Token token) {
        this.left = left;
        this.right = right;
        this.token = token;
    }

    public abstract V getValue();

    public Expression getLeft() {
        return left;
    }

    public void setLeft(Expression left) {
        this.left = left;
    }

    public Expression getRight() {
        return right;
    }

    public void setRight(Expression right) {
        this.right = right;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }
}
