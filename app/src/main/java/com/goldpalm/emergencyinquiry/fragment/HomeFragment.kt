package com.goldpalm.emergencyinquiry.fragment

import com.goldpalm.emergencyinquiry.R
import com.goldpalm.emergencyinquiry.app.BaseFragment

/**
 * 首页
 */
class HomeFragment : BaseFragment(){
    override fun init() {
        setToolbar(0,title = "首页")
    }

    override fun getLayout(): Int {
        return R.layout.fragment_home
    }
}