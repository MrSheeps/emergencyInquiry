package com.goldpalm.emergencyinquiry.app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.goldpalm.emergencyinquiry.R
import com.gyf.barlibrary.ImmersionBar
import kotlinx.android.synthetic.main.layout_toolbar.*

abstract class BaseActivity : AppCompatActivity() {
    lateinit var mImmersionBar: ImmersionBar

    val TAG: String=javaClass.name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (isImmersionBar()){
            mImmersionBar= ImmersionBar.with(this)
            mImmersionBar.init()
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        if (mImmersionBar!=null){
            mImmersionBar.destroy()
        }
    }

    fun isImmersionBar():Boolean{
        return true
    }


    /**
     * 设置toolbar
     */
    fun setToolbar(back:Int= R.mipmap.arrow_left, title:String, right:Int=0){
        if (back==0){
            back_iv.visibility=View.INVISIBLE
        }else{
            back_iv.visibility=View.VISIBLE
            back_iv.setImageResource(back)
        }

        if (right==0){
            right_iv.visibility=View.INVISIBLE
        }else{
            right_iv.visibility=View.VISIBLE
            right_iv.setImageResource(right)
        }

        title_tv.text=title
    }

}