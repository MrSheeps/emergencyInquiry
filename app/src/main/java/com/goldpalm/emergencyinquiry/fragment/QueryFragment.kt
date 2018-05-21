package com.goldpalm.emergencyinquiry.fragment

import com.goldpalm.emergencyinquiry.R
import com.goldpalm.emergencyinquiry.app.BaseFragment
import kotlinx.android.synthetic.main.fragment_query.*

class QueryFragment: BaseFragment(){
    override fun getLayout(): Int {
        return R.layout.fragment_query
    }

    override fun init() {
        setToolbar(0,"应急查询目录")

        query_contract.setOnClickListener {  }
    }
}