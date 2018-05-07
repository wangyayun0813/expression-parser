package com.test;

import com.test.ruleEngine.ExpressionEvaluator;
import com.test.ruleEngine.parser.ExpressionParser;
import com.test.ruleEngine.token.Token;
import org.junit.Test;

import java.util.List;

/**
 * Created by 王亚运 on 2018/5/5.
 */
public class ExpressionParserTest {
    /**
     * a+d*(b-c)    a,d,b,c,-,*,+
     * a+(b-c)*d    +	*	d	-	c	b	a
     * A && (B || !c)>=(2+E/10+F%3*2) and A or not c      --》 &	and	or	not	c	A	ge	+	+	*	2	%	3	F	/	10	E	2	|	!	c	B	A
     * 1 + 2* 3 -4      +	-	4	*	3	2	1
     * (-1 + 2* 3 -4) > 0 & 3 < 1 or (7 - 2 > 2)
     * @throws Exception
     */
    @Test
    public void parseTest() throws Exception {
        ExpressionParser parser = new ExpressionParser();
//        String exp = "A && (B || !c)>=(-2+E/10+F%3*2) and A not c";
        String exp = "(-1 + 2* 3 -4) > 0 & 3 < 1 or (7 - 2 > 2)";
        List<Token> tokens = parser.parse(exp);
        List<Token> polishNotation = parser.convertToPolishNotation(tokens);
        boolean b = ExpressionEvaluator.calcExpression(polishNotation);
        System.out.println(b);
//        tokens1.forEach(t-> System.out.print(t.getToken()+"\t"));

    }

    @Test
    public void testQQ()
    {
        String exp = "A and B or c > 2 + E / 10 + F % 3 * 2";
        System.out.println(exp.substring(exp.length()-1));
    }

}