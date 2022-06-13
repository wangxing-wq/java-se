package com.wx.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author 王兴
 * @version 1.0
 * @date 2022/2/9 22:11
 * Lambda学习
 * 只包含一个抽象方法的接口，称为函数式接口。
 * 可以通过 Lambda 表达式来创建该接口的对象。（若 Lambda表达式抛出一个受检异常，那么该
 * 异常需要在目标接口的抽象方法上进行声明）。
 * 可以在任意函数式接口上使用 @FunctionalInterface 注解，这样做可以检查它是否是一个函数式
 * 接口，同时 javadoc 也会包含一条声明，说明这个接口是一个函数式接口。
 *
 *
 * 与Lambda相关的四大函数接口
 * Consumer消费型接口 T void 对类型为T的对象应用操作，接口定义的方法：void accept(T t)
 * Supplier供给 型接口 无 T 返回类型为T的对象，接口定义的方法：T get()
 * Function<T,R>函数式接口 T R对类型为T的对象应用操作，并R类型的返回结果。接口定义的方法：R apply(T t)
 * Predicate断言型接口 T boolean 确定类型为T的对象是否满足约束条件，并返回boolean 类型的数据。接口定义的方法：boolean test(T t)
 */
public class LambdaTest {


	/**
	 * Lambda四种特性
	 * 可选类型声明：不需要声明参数类型，编译器可以统一识别参数值。
	 * 可选的参数圆括号：一个参数无需定义圆括号，但多个参数需要定义圆括号。
	 * 可选的大括号：如果主体包含了一个语句，就不需要使用大括号。
	 * 可选的返回关键字：如果主体只有一个表达式返回值则编译器会自动返回值，大括号需要指定表达式返回了一个数值
	 */
	@Test
	public void t1(){
		// 1. 可选类型声明 | 可选的返回关键字 | 可选的大括号
		System.out.println(calculate(3, 4, ((a, b) -> a * b)));
		// 2 可选的参数圆括号
		print("测试", o -> {
			String msg = o.toString();
			System.out.println(msg);
		});
	}

	public int calculate(int a,int b,Calculate calculate){
		return calculate.calculate(a, b);
	}

	public void print(Object o,Print print){
		print.print(o);
	}


	interface Calculate{

		int calculate(int a,int b);

	}


	interface Print{

		void print(Object o);

	}


}
