package com.springcore.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/spel/spelconfig.xml");
		Demo demo = (Demo) context.getBean("demo");
		System.out.println(demo);
		SpelExpressionParser temp = new SpelExpressionParser();
		Expression expression = temp.parseExpression("20+30");
		System.out.println(expression.getValue());
	}

}
