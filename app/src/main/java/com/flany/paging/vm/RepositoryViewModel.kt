package com.flany.paging.vm

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.flany.paging.bean.RepositoryBean
import com.flany.paging.paging.Repository
import kotlinx.coroutines.flow.Flow

/**
 * @author: hec@shuyilink.com
 * @date:   2021/7/15
 * @since:
 */
class RepositoryViewModel : ViewModel() {

    fun getAndroidRepository(): Flow<PagingData<RepositoryBean>> {
        return Repository.getAndroidRepository()
    }
}