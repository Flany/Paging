package com.flany.paging.ui

import android.app.Dialog
import android.content.Context
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import com.flany.paging.R

/**
 * 自定义弹窗
 */
class LoadingDialog constructor(context: Context) :
    Dialog(context, R.style.AppDialog) {

    var tvLoadingTx: TextView?
    var ivLoading: ImageView?

    init {
        setCanceledOnTouchOutside(false)//点击其他区域时   true  关闭弹窗  false  不关闭弹窗
        setOnCancelListener { dismiss() }
        setContentView(R.layout.loading_dialog)
        tvLoadingTx = findViewById(R.id.tv_loading_tx)
        ivLoading = findViewById(R.id.iv_loading)

        window?.attributes?.gravity = Gravity.CENTER//居中显示
        window?.attributes?.dimAmount = 0.5f//背景透明度  取值范围 0 ~ 1
    }

    fun show(title: String?) {
        title?.let {
            tvLoadingTx?.text = it
        }
        setOnDismissListener {
            ivLoading?.clearAnimation()
        }
        show()
    }
}
