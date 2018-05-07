package com.test.ruleEngine;

import com.test.ruleEngine.token.NumericToken;
import com.test.ruleEngine.token.StringToken;
import com.test.ruleEngine.token.Token;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by 王亚运 on 2018/5/6.
 */
public class ExpressionEvaluator {

    /**
     * 对表达式进行计算
     * @param polishNotation
     * @return
     */
    public static boolean calcExpression(List<Token> polishNotation)
    {
        Stack<Object> valueStack = new Stack<>();
        Iterator<Token> iterator = polishNotation.iterator();
        while (iterator.hasNext())
        {
            Token token = iterator.next();
            Object left, right;
            switch (token.getTokenType())
            {
                case Not:
                    left = valueStack.pop();
                    valueStack.push(!(Boolean) left);
                    break;
                case Mod:
                    right = valueStack.pop();
                    left = valueStack.pop();
                    valueStack.push((Float)left %  (Float)right);
                case MultiPly:
                    right = valueStack.pop();
                    left = valueStack.pop();
                    valueStack.push((Float)left *  (Float)right);
                    break;
                case Divide:
                    right = valueStack.pop();
                    left = valueStack.pop();
                    valueStack.push((Float)left / (Float)right);
                    break;
                case Plus:
                    right = valueStack.pop();
                    left = valueStack.pop();
                    valueStack.push((Float)left +  (Float)right);
                    break;
                case Subtract:
                    right = valueStack.pop();
                    left = valueStack.pop();
                    valueStack.push((Float)left -  (Float)right);
                    break;
                case Equal:
                    right = valueStack.pop();
                    left = valueStack.pop();
                    valueStack.push(left == right);
                    break;
                case NotEqual:
                    right = valueStack.pop();
                    left = valueStack.pop();
                    valueStack.push(left != right);
                    break;
                case GT:
                    right = valueStack.pop();
                    left = valueStack.pop();
                    valueStack.push((Float)left > (Float)right);
                    break;
                case LT:
                    right = valueStack.pop();
                    left = valueStack.pop();
                    valueStack.push((Float)left < (Float)right);
                    break;
                case GTOrEqual:
                    right = valueStack.pop();
                    left = valueStack.pop();
                    valueStack.push((Float)left >= (Float)right);
                    break;
                case LTOrEqual:
                    right = valueStack.pop();
                    left = valueStack.pop();
                    valueStack.push((Float)left <= (Float)right);
                    break;
                case In:
                    break;
                case NotIn:
                    break;
                case StartWith:
                    break;
                case EndWith:
                    break;
                case And:
                    right = valueStack.pop();
                    left = valueStack.pop();
                    valueStack.push((Boolean)left && (Boolean)right);
                    break;
                case Or:
                    right = valueStack.pop();
                    left = valueStack.pop();
                    valueStack.push((Boolean)left || (Boolean)right);
                    break;
                case Numeric:
                    valueStack.push(((NumericToken)token).getValue());
                    break;
                case String:
                    valueStack.push(((StringToken)token).getValue());
                    break;
                case Date:
                case Variable:
                    break;
            }
        }
        return (boolean) valueStack.pop();
    }
}
