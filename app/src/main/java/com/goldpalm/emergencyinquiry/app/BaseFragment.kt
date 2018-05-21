package com.goldpalm.emergencyinquiry.app

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.goldpalm.emergencyinquiry.R
import com.gyf.barlibrary.ImmersionBar
import kotlinx.android.synthetic.main.layout_toolbar.*

abstract class BaseFragment : Fragment(){

    lateinit var mImmersionBar:ImmersionBar


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return layoutInflater.inflate(getLayout(),container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (isImmersionBar()){
            mImmersionBar=ImmersionBar.with(this).statusBarView(top_view)
            mImmersionBar.init()
        }
        init()
    }

    abstract fun getLayout(): Int

    abstract fun init()

    /**
     * 是否在fragment中使用沉浸式状态栏
     * @return boolean
     */
    fun isImmersionBar():Boolean{
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mImmersionBar!=null){
            mImmersionBar.destroy()
        }
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (!hidden && mImmersionBar != null)
            mImmersionBar.init()
    }


    /**
     * 设置toolbar
     */
    protected fun setToolbar(back:Int= R.mipmap.arrow_left, title:String, right:Int=0){
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