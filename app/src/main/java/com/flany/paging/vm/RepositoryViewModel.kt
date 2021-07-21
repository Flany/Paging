package com.flany.paging.vm

import androidx.paging.PagingData
import com.flany.paging.base.BaseViewModel
import com.flany.paging.bean.RepositoryBean
import com.flany.paging.paging.Repository
import kotlinx.coroutines.flow.*

/**
 * @author: hec@shuyilink.com
 * @date:   2021/7/15
 * @since:
 */
class RepositoryViewModel : BaseViewModel() {

    fun getAndroidRepository(): Flow<PagingData<RepositoryBean>> {
        return Repository.getAndroidRepository()
    }
}