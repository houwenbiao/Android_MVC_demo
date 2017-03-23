package com.gree.hwb.android_mvc_demo.view;

import android.app.Activity;
import android.widget.TextView;

import com.gree.hwb.android_mvc_demo.R;

/**
 * Created by Administrator on 2016/09/02.
 */
public class CaOutputView
{
	private TextView tv;
	//在CaOutputView中，不需要通知Activity发生了什么，只需要显示结果
	public CaOutputView(Activity ac)
	{
		tv = (TextView) ac.findViewById(R.id.ResultOutput);
	}

	/**
	 * 定义CaOutputView拥有的方法，将输入的结果显示出来
	 * 实质是调用TextView的方法
	 */
	public void outputData(String string)
	{
		tv.setText(string);
	}
}
