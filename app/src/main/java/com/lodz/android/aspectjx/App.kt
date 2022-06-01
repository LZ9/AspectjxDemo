package com.lodz.android.aspectjx

import com.lodz.android.pandora.base.application.BaseApplication

/**
 *
 * @author zhouL
 * @date 2022/6/1
 */
class App :BaseApplication(){
    override fun onStartCreate() {
        getBaseLayoutConfig().getTitleBarLayoutConfig().backgroundColor = R.color.teal_200
    }


    override fun onExit() {}
}
