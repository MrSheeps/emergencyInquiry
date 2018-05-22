package com.goldpalm.emergencyinquiry.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import com.goldpalm.emergencyinquiry.R
import com.goldpalm.emergencyinquiry.app.BaseActivity
import com.goldpalm.emergencyinquiry.fragment.CountFragment
import com.goldpalm.emergencyinquiry.fragment.HomeFragment
import com.goldpalm.emergencyinquiry.fragment.MineFragment
import com.goldpalm.emergencyinquiry.fragment.QueryFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {

    private val images:Array<IntArray> = arrayOf(intArrayOf(R.mipmap.ic_home_unselected, R.mipmap.ic_home_selected)
            , intArrayOf(R.mipmap.ic_query_unselected, R.mipmap.ic_query_selected)
            , intArrayOf(R.mipmap.ic_count_unselected, R.mipmap.ic_count_selected)
            , intArrayOf(R.mipmap.ic_mine_unselected, R.mipmap.ic_mine_selected)
    )

    lateinit var transient: FragmentTransaction

    var currenterFragment:Fragment?=null

    lateinit var homeFragment: HomeFragment
    lateinit var queryFragment: QueryFragment
    lateinit var countFragment: CountFragment
    lateinit var mineFragment: MineFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mImmersionBar.statusBarColor(R.color.colorPrimary)
        homeFragment= HomeFragment()
        queryFragment= QueryFragment()
        countFragment= CountFragment()
        mineFragment= MineFragment()
        setCurrentFragment(homeFragment)
        setCrrentTab(0)

        menu_hone.setOnClickListener {
            if (currenterFragment==homeFragment)return@setOnClickListener
            setCurrentFragment(homeFragment)
            setCrrentTab(0)
        }
        menu_query.setOnClickListener {
            if (currenterFragment==queryFragment)return@setOnClickListener
            setCurrentFragment(queryFragment)
            setCrrentTab(1)
        }
        menu_count.setOnClickListener {
            if (currenterFragment==countFragment)return@setOnClickListener
            setCurrentFragment(countFragment)
            setCrrentTab(2)
        }
        menu_mine.setOnClickListener {
            if (currenterFragment==mineFragment)return@setOnClickListener
            setCurrentFragment(mineFragment)
            setCrrentTab(3)
        }




    }


    /**
     * 动态加载fragment
     */
    fun setCurrentFragment(fragment: Fragment){

        transient=supportFragmentManager.beginTransaction()

        if (!fragment.isAdded){
            if (currenterFragment!=null){
                transient.hide(currenterFragment)
            }
            transient.add(R.id.container,fragment)
        }else{
            transient.hide(currenterFragment)
            transient.show(fragment)
        }
        currenterFragment= fragment
        transient.commit()

    }

    fun setCrrentTab(position: Int){
        when(position){
            0->{ menu_hone.setTab(images[0][1], R.string.menu_home,true)
                menu_query.setTab(images[1][0], R.string.menu_query,false)
                menu_count.setTab(images[2][0], R.string.menu_count,false)
                menu_mine.setTab(images[3][0], R.string.menu_mine,false)
            }
            1->{ menu_hone.setTab(images[0][0], R.string.menu_home,false)
                menu_query.setTab(images[1][1], R.string.menu_query,true)
                menu_count.setTab(images[2][0], R.string.menu_count,false)
                menu_mine.setTab(images[3][0], R.string.menu_mine,false)
            }
            2->{ menu_hone.setTab(images[0][0], R.string.menu_home,false)
                menu_query.setTab(images[1][0], R.string.menu_query,false)
                menu_count.setTab(images[2][1], R.string.menu_count,true)
                menu_mine.setTab(images[3][0], R.string.menu_mine,false)
            }
            3->{ menu_hone.setTab(images[0][0], R.string.menu_home,false)
                menu_query.setTab(images[1][0], R.string.menu_query,false)
                menu_count.setTab(images[2][0], R.string.menu_count,false)
                menu_mine.setTab(images[3][1], R.string.menu_mine,true)
            }
        }
    }
}
