package com.goldpalm.emergencyinquiry.fragment

import com.goldpalm.emergencyinquiry.R
import com.goldpalm.emergencyinquiry.app.BaseFragment

/**
 * 个人中心
 * @author y_qh  2018/05/21
 */
class MineFragment: BaseFragment() {



    override fun getLayout(): Int {
        return R.layout.frgament_mine
    }

    override fun init() {
        setToolbar(0,"个人中心")
    }
}