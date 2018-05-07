package com.test.ruleEngine.token;

import java.util.Date;

/**
 * Created by 王亚运 on 2018/5/5.
 */
public class DateToken extends LeafToken<Date> {
    public DateToken(String token) {
        super(token);
    }

    @Override
    public Date getValue() {
        //TODO
        return new Date();
    }

    @Override
    public TokenType getTokenType() {
        return TokenType.Date;
    }
}
