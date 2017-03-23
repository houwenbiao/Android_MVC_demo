package com.gree.hwb.android_mvc_demo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.gree.hwb.android_mvc_demo.R;
import com.gree.hwb.android_mvc_demo.model.CalModel;
import com.gree.hwb.android_mvc_demo.model.ICalculator;
import com.gree.hwb.android_mvc_demo.view.CaInputView;
import com.gree.hwb.android_mvc_demo.view.CaOutputView;

/**
 * activity从model层获取数据并将之放到view层（xml文件中）可以看做MVC中的Controller
 */

public class MainActivity extends AppCompatActivity implements CaInputView.InputHappend
{
	private CaInputView civ;
	private CaOutputView cov;
	private ICalculator calModel;
	private String number = "0";
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		civ = new CaInputView(this,this);
		cov = new CaOutputView(this);
		calModel = new CalModel();
	}

	@Override
	public void operandIn(String operand)
	{
		number = number.equals("0")?operand:number + operand;
		cov.outputData(operand);
	}

	@Override
	public void operateIn(String operate)
	{
		if(operate.equalsIgnoreCase("C"))
		{
			calModel.reset();
			number = "0";
			cov.outputData(number);
			return;
		}
		calModel.pushOperand(number);
		double result = calModel.pushOperate(operate);
		if(result % 1d == 0d)
		{
			int tem = Double.valueOf(result).intValue();
			cov.outputData(String.valueOf(tem));
		}else
		{
			cov.outputData(String.valueOf(result));
		}
		number = "0";
	}
}
