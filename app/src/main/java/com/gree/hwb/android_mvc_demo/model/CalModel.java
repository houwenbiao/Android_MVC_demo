package com.gree.hwb.android_mvc_demo.model;

import java.util.Stack;

/**
 * Created by Administrator on 2016/09/02.
 */
public class CalModel implements ICalculator
{
	private boolean isOperate = false;//是否在输入操作符，对连续输入操作符的情况视为操作符的替换
	private Stack<String> dataStack = new Stack<>();//记录输入的运算数和操作符的栈
	public static double popOpPffStack(Stack<String> stack)
	{
		double result = 0;
		//从堆栈中去运算数，转换为double
		double operand = Double.valueOf(stack.pop());
		//从栈中获取元素后假如栈为空，则直接返回Operand
		if(stack.isEmpty())
		{
			return operand;
		}
		//继续从栈中取操作符，根据操作符类型继续递归调用
		String operate = stack.pop();
		if(operate.equals("+"))
		{
			result = CalModel.popOpPffStack(stack) + operand;
		}
		if(operate.equals("-"))
		{
			result = CalModel.popOpPffStack(stack) - operand;
		}
		if(operate.equals("*"))
		{
			result = CalModel.popOpPffStack(stack) * operand;
		}
		if(operate.equals("/"))
		{
			result = CalModel.popOpPffStack(stack) / operand;
		}
		return result;
	}
	@Override
	public void pushOperand(String operand)
	{
		dataStack.add(operand);
		isOperate = false;
	}

	@Override
	public double pushOperate(String operate)
	{
		double result = 0;
		if(isOperate)
		{
			dataStack.pop();
		}
		if(operate.equals("="))
		{
			result = CalModel.popOpPffStack(dataStack);
		}
		else
		{
			Stack<String> temStack = (Stack<String>) dataStack.clone();
			result = CalModel.popOpPffStack(temStack);
			dataStack.add(operate);
			isOperate = true;
		}
		return result;
	}

	@Override
	public void reset()
	{
		dataStack.removeAllElements();
		isOperate = false;
	}
}
