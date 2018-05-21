package com.goldpalm.emergencyinquiry.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.goldpalm.emergencyinquiry.R;


/**
 * 首页按钮 图片+ 文字
 * @author gp-yqh
 */
public class HomeTabItem extends LinearLayout
{

	private ImageView tabImg = null;

	private TextView tabName = null;


	public HomeTabItem(Context context)
	{
		super(context);
		initView((Activity)context);
	}

	public HomeTabItem(Context context, AttributeSet attrs, int defStyle)
	{
		super(context, attrs,defStyle);
		initView((Activity)context);
	}

	public HomeTabItem(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		initView((Activity)context);
	}

	private void initView(Activity context)
	{
		View layout = LayoutInflater.from(context).inflate(R.layout.tabitem_layout, this);

		tabImg =  layout.findViewById(R.id.tabitem_icon);
		tabName = layout.findViewById(R.id.tabitem_title);
	}

	public void setTab(int res, String text, boolean isChecked){
		if(tabImg!=null){
			tabImg.setImageResource(res);
		}
		if(tabName!=null){
			tabName.setText(text);
			if(!isChecked){
				tabName.setTextColor(getResources().getColor(R.color.menu_unselected));
			}else {
				tabName.setTextColor(getResources().getColor(R.color.menu_selected));
			}
		}
	}

	public void setTab(int res, int text, boolean isChecked){
		if(tabImg!=null){
			tabImg.setImageResource(res);
		}
		if(tabName!=null){
			tabName.setText(text);
			if(!isChecked){
				tabName.setTextColor(getResources().getColor(R.color.menu_unselected));
			}else {
				tabName.setTextColor(getResources().getColor(R.color.menu_selected));
			}
		}
	}



}
