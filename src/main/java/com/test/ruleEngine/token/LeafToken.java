package com.test.ruleEngine.token;

/**
 * Created by 王亚运 on 2018/5/5.
 * 叶子节点
 */
public abstract class LeafToken<T> extends Token{
    public LeafToken(String token) {
        super(token);
    }

    public abstract T getValue();
}
