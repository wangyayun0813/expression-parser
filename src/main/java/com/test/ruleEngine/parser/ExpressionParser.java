package com.test.ruleEngine.parser;

import com.test.ruleEngine.common.StringUtil;
import com.test.ruleEngine.token.Token;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

import static com.test.ruleEngine.token.TokenType.LParentheses;

/**
 * Created by 王亚运 on 2018/5/5.
 * 表达式解析器
 */
public class ExpressionParser {
    private static TokenParserChain parserChain;

    static {
        LeafTokenParser leafTokenParser = new LeafTokenParser(parserChain);
        LogicalTokenParser logicalTokenParser = new LogicalTokenParser(leafTokenParser);
        RelationTokenParser relationTokenParser = new RelationTokenParser(logicalTokenParser);
        ArithmeticOperatorTokenParser arithmeticOperatorTokenParser = new ArithmeticOperatorTokenParser(relationTokenParser);
        RParenthesesTokenParser rParenthesesTokenParser = new RParenthesesTokenParser(arithmeticOperatorTokenParser);
        parserChain = new LParenthesesTokenParser(rParenthesesTokenParser);
    }

    public List<Token> parse(String expression)
    {
        expression = replateOperators(expression);
        List<Token> tokens = new ArrayList<>();
        int position = 0;
        Token token = null;
        do
        {
            position += StringUtil.skipBlank(expression, position);
            token = parserChain.parse(expression, position, token);
            if(null == token)break;
            tokens.add(token);
            position += token.getToken().length();
        }while (true);
        return tokens;
    }

    /**
     * 转波兰式
     * @param tokens
     * @return
     */
    public List<Token> convertToPolishNotation(List<Token> tokens)
    {
        Queue<Token> tokenQueue = new LinkedBlockingDeque<>();
        Iterator<Token> iterator = tokens.iterator();
        Stack<Token> operators = new Stack<>();
        while (iterator.hasNext())
        {
            Token token = iterator.next();
            switch (token.getTokenType())
            {
                case LParentheses:
                    operators.push(token);
                    break;
                case RParentheses:
                    while (true)
                    {
                        if(operators.peek().getTokenType().equals(LParentheses))
                        {
                            operators.pop();
                            break;
                        }else {
                            tokenQueue.offer(operators.pop());
                        }
                    }
                    break;
                case Numeric:
                case String:
                case Date:
                case Variable:
                    tokenQueue.offer(token);
                    break;
                default:
                    while (!operators.empty() && !operators.peek().getTokenType().equals(LParentheses))
                    {
                        if(operators.peek().getTokenType().getLevel() - token.getTokenType().getLevel() >0) {
                            tokenQueue.offer(operators.pop());
                        }else break;
                    }
                    operators.push(token);
                    break;
            }
        }
        while (!operators.empty())
            tokenQueue.offer(operators.pop());
        List<Token> polishNotation = new ArrayList<>(tokenQueue);
        return polishNotation;
    }


    /**
     * 替换操作符
     * @param expression
     * @return
     */
    private String replateOperators(String expression) {
        expression = expression.replaceAll("&&", "&");
        expression = expression.replaceAll(">=", " ge ");
        expression = expression.replaceAll("<=", "le");
        expression = expression.replaceAll("==", "eq");
        expression = expression.replaceAll("\\|\\|", "|");
        return expression;
    }
}
