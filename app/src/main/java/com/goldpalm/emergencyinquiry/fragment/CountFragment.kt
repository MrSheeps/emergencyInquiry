package com.goldpalm.emergencyinquiry.fragment

import com.goldpalm.emergencyinquiry.R
import com.goldpalm.emergencyinquiry.app.BaseFragment
import kotlinx.android.synthetic.main.fragment_count.*

/**
 * 舆情统计
 * @author yqh 2018/05/21
 */
class CountFragment: BaseFragment(){

    override fun getLayout(): Int {
        return R.layout.fragment_count
    }

    override fun init() {
        setToolbar(0, "舆情监测")


        top_bg.setOnClickListener {

        }
    }

}