package com.flany.paging

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.flany.paging.adapter.RepositoryAdapter
import com.flany.paging.base.BaseActivity
import com.flany.paging.vm.RepositoryViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainActivity : BaseActivity() {

    private val adapter = RepositoryAdapter()

    override val viewModel: RepositoryViewModel
        get() = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(RepositoryViewModel::class.java)

    override fun initViews() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        lifecycleScope.launch {
            viewModel.getAndroidRepository().collect {
                adapter.submitData(it)
            }
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }
}