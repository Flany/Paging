package com.flany.paging.paging

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.flany.paging.bean.RepositoryBean
import com.flany.paging.network.ApiService
import kotlinx.coroutines.flow.Flow

/**
 * @author: hec@shuyilink.com
 * @date:   2021/7/15
 * @since:
 */
object Repository {
    private const val PAGE_SIZE = 20

    private val apiService = ApiService.create()

    fun getAndroidRepository(): Flow<PagingData<RepositoryBean>> {
        return Pager(
            config = PagingConfig(PAGE_SIZE),
            pagingSourceFactory = { RepositoryPagingSource(apiService) }
        ).flow
    }
}