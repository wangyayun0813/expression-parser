package com.test.ruleEngine.parser;

import com.test.ruleEngine.token.RelationOperatorToken;
import com.test.ruleEngine.token.Token;
import com.test.ruleEngine.token.TokenType;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

import static com.test.ruleEngine.token.TokenType.*;

/**
 * Created by 王亚运 on 2018/5/5.
 */
public class RelationTokenParser extends TokenParserChain{
    private static final TokenType[] operators = {Equal, NotEqual,GT, LT, GTOrEqual, LTOrEqual,
            In, NotIn, StartWith, EndWith};
    private TokenType tokenType;
    public RelationTokenParser(TokenParserChain parserChain) {
        super(parserChain);
    }

    @Override
    protected Token createToken(java.lang.String expression, String tokenStr, int position) {
        return new RelationOperatorToken(tokenType, tokenStr);
    }

    @Override
    protected boolean isToken(java.lang.String expression, String s, int position) {
        Optional<TokenType> any = Stream.of(operators)
                             .filter(type -> Arrays.asList(type.getTokens()).contains(s.toLowerCase()))
                             .findAny();
        tokenType = any.orElse(null);
        return any.isPresent();
    }
}
