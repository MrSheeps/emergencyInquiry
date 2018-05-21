package com.goldpalm.emergencyinquiry.widget

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

import com.goldpalm.emergencyinquiry.R
import kotlinx.android.synthetic.main.layout_card_item.view.*


/**
 * 首页 文本
 * @author gp-yqh
 */
class CardViewItem : LinearLayout {



    constructor(context: Context) : super(context) {
        initView(context as Activity)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        initView(context as Activity)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initView(context as Activity)
    }

    private fun initView(context: Activity) {
        val layout = LayoutInflater.from(context).inflate(R.layout.layout_card_item, this)
        setText("2018-05-18（周一）","杨启航","15626535234",false)
    }


    fun setText(date:String="--",name:String="--",phone:String="",isToday:Boolean){
        duty_date.text=date
        duty_name.text=name
        duty_phone.text=phone

        if (isToday)
            setColors(R.color.text_card_today,duty_date,duty_name,duty_phone)
        else
            setColors(R.color.text_card,duty_date,duty_name,duty_phone)
    }

    private fun setColors(color: Int,vararg textView: TextView){
        for (it in textView) it.setTextColor(resources.getColor(color))
    }

}
