package com.test.ruleEngine.parser;

import com.test.ruleEngine.token.ArithmeticOperatorToken;
import com.test.ruleEngine.token.LeafToken;
import com.test.ruleEngine.token.Token;
import com.test.ruleEngine.token.TokenType;
import com.pactera.ruleEngine.token.*;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

import static com.test.ruleEngine.token.TokenType.*;

/**
 * Created by 王亚运 on 2018/5/5.
 */
public class ArithmeticOperatorTokenParser extends TokenParserChain {
    private static final TokenType[] operators = {Mod, Subtract, MultiPly, Plus, Divide};
    private TokenType tokenType;
    public ArithmeticOperatorTokenParser(TokenParserChain parserChain) {
        super(parserChain);
    }

    @Override
    protected Token createToken(String expression, String tokenStr, int position) {
        return new ArithmeticOperatorToken(tokenType, tokenStr);
    }

    @Override
    protected boolean isToken(java.lang.String expression, String s, int position) {
        Optional<TokenType> any = Stream.of(operators)
                .filter(type -> Arrays.asList(type.getTokens()).contains(s.toLowerCase()))
                .findAny();
        tokenType = any.orElse(null);
        if(any.isPresent() && tokenType.equals(Subtract) && s.equals("-") && (null== prevToken || !(prevToken instanceof LeafToken)))
        {
            return false;
        }
        return any.isPresent();
    }
}
