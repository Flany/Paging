package com.flany.paging.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.flany.paging.ui.LoadingDialog

/**
 * @author: hec@shuyilink.com
 * @date:   2021/7/19
 * @since:
 */
abstract class BaseActivity : AppCompatActivity() {

    abstract val viewModel: BaseViewModel

    private val loadingDialog by lazy {
        LoadingDialog(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initViewModel()
        initViews()
    }

    abstract fun initViews()

    abstract fun getLayoutId(): Int

    private fun initViewModel() {
        viewModel.commonEvent.showLoading.observe(this) {
            if (it) {
                loadingDialog.show()
            } else {
                loadingDialog.dismiss()
            }
        }
    }
}