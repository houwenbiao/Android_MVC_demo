package com.gree.hwb.android_mvc_demo.model;

/**
 * Created by Administrator on 2016/09/02.
 */
public interface ICalculator
{
	//接收操作数输入
	void pushOperand(String operand);
	//接收运算符输入时返回运算结果
	double pushOperate(String operate);
	//重置清零
	void reset();
}
