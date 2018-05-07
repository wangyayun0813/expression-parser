package com.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        String[] s = new String[]{"zhan", "wang", "xx", "zhangSan", "tttt"};

        int index = Arrays.binarySearch(s, "zhangSan");
        System.out.println(index);
    }

    @Test
    public void testStack()
    {
        Stack<Integer> s = new Stack<>();
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(4);
        a.add(3);
        a.add(2);
        a.add(5);
        Collections.sort(a, Comparator.comparingInt(o -> o));
        s.addAll(a);
        while (!s.empty())
            System.out.println(s.pop());
    }

}
