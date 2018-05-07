package com.test.ruleEngine.parser;

import com.test.ruleEngine.token.RelationOperatorToken;
import com.test.ruleEngine.common.StringUtil;
import com.test.ruleEngine.token.LogicalOperatorToken;
import com.test.ruleEngine.token.Token;
import com.test.ruleEngine.token.TokenType;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

import static com.test.ruleEngine.token.TokenType.*;

/**
 * Created by 王亚运 on 2018/5/5.
 */
public class LogicalTokenParser extends TokenParserChain {
    private static final TokenType[] operators = {Not, And, Or};
    private TokenType tokenType;
    public LogicalTokenParser(TokenParserChain parserChain) {
        super(parserChain);
    }

    @Override
    protected Token createToken(String expression, String tokenStr, int position) {
        if(!tokenType.equals(Not))
        {
            return new LogicalOperatorToken(tokenType, tokenStr);
        }
        position ++;
        int blank = StringUtil.skipBlank(expression, position);
        int start = position + blank;
        if(start < expression.length()-3 && expression.substring(start, start + 3).equalsIgnoreCase("in "))
        {
            return new RelationOperatorToken(NotIn, tokenStr+" in");
        }
        return new LogicalOperatorToken(tokenType, tokenStr);
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
