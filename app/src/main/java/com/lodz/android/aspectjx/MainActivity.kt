package com.lodz.android.aspectjx

import android.os.Bundle
import android.view.View
import com.lodz.android.aspectjx.aop.checklogin.LoginHelper
import com.lodz.android.aspectjx.aop.fastclick.FastClickLimit
import com.lodz.android.aspectjx.databinding.ActivityMainBinding
import com.lodz.android.corekt.anko.append
import com.lodz.android.corekt.utils.DateUtils
import com.lodz.android.pandora.base.activity.BaseActivity
import com.lodz.android.pandora.utils.viewbinding.bindingLayout

class MainActivity : BaseActivity() {

    private val mBinding: ActivityMainBinding by bindingLayout(ActivityMainBinding::inflate)

    override fun getViewBindingLayout(): View = mBinding.root

    override fun findViews(savedInstanceState: Bundle?) {
        super.findViews(savedInstanceState)
        getTitleBarLayout().needBackButton(false)
        getTitleBarLayout().setTitleName(R.string.app_name)
    }

    override fun onClickBackBtn() {
        super.onClickBackBtn()
        finish()
    }

    override fun setListeners() {
        super.setListeners()

        mBinding.loginProxyBtn.setOnClickListener {
//            goAttentionActivity()
        }

        mBinding.cleanBtn.setOnClickListener {
            mBinding.logTv.text = ""
        }

        mBinding.fastClickAnnotationBtn.setOnClickListener @FastClickLimit(2000) {
            addLog(DateUtils.getCurrentFormatString(DateUtils.TYPE_10).append("：FastClick Annotation"))
        }

        mBinding.fastClickObjectBtn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                addLog(DateUtils.getCurrentFormatString(DateUtils.TYPE_10).append("：FastClick Object"))
            }
        })

        mBinding.fastClickLambdaBtn.setOnClickListener {
            addLog(DateUtils.getCurrentFormatString(DateUtils.TYPE_10).append("：FastClick Lambda"))
        }
    }

//    @CheckLogin
//    private fun goAttentionActivity() {
//        AopAttentionActivity.start(getContext())
//    }

    override fun initData() {
        super.initData()
        showStatusCompleted()
    }

    override fun onResume() {
        super.onResume()
        mBinding.loginStatusTv.text = getString(R.string.aop_login_status).append(LoginHelper.isLogin)
    }

    private fun addLog(log: String) {
        if (log.isEmpty()) {
            return
        }
        mBinding.logTv.text = log.append("\n").append(mBinding.logTv.text)
    }
}