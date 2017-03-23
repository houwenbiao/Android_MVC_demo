package com.gree.hwb.android_mvc_demo.view;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/09/02.
 */
public class CaInputView
{
	public interface InputHappend
	{
		//当用户输入运算数字时，通知输入了operand这个数字
		void operandIn(String operand);
		//当用户输入运算符时，通知输入了operate这个运算符
		void operateIn(String operate);
	}

	private List<Button> operands;
	private List<Button> operates;
	private CaInputView.InputHappend dlg;

	public CaInputView(Activity ac,CaInputView.InputHappend delegate)
	{
		dlg = delegate;
		operands = new ArrayList<>();
		operates = new ArrayList<>();
		Resources resources = ac.getResources();
		for (int i = 0; i <= 9; i++)
		{
			if(i <= 5)
			{
				int id_operate = resources.getIdentifier("Operate" + i,"id",ac.getPackageName());
				Button btn_operate = (Button) ac.findViewById(id_operate);
				operates.add(btn_operate);
			}
			int id_operand = resources.getIdentifier("Operand" + i, "id",ac.getPackageName());
			Button btn_operand = (Button) ac.findViewById(id_operand);
			operands.add(btn_operand);
		}
		//为操作数添加事件，当用户触发时，通知dlg发生operandIn
		for (Button btn:operands)
		{
			btn.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View view)
				{
					Button cli_btn = (Button) view;
					String text = cli_btn.getText().toString();
					dlg.operandIn(text);
				}
			});
		}
		//为操作符添加事件，当用户触发时，通知dlg发生operateIn
		for (Button button:operates)
		{
			button.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View view)
				{
					Button btn = (Button) view;
					String text = btn.getText().toString();
					dlg.operateIn(text);
				}
			});
		}
	}
}
