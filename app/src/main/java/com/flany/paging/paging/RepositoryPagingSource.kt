package com.flany.paging.paging

import androidx.paging.PagingSource
import com.flany.paging.bean.RepositoryBean
import com.flany.paging.network.ApiService

/**
 * @author: hec@shuyilink.com
 * @date:   2021/7/15
 * @since:
 */
class RepositoryPagingSource(private val apiService: ApiService) :
    PagingSource<Int, RepositoryBean>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RepositoryBean> {
        return try {
            val page = params.key ?: 1
            val pageSize = params.loadSize
            val response = apiService.searchRepository(page, pageSize)
            val items = response.items
            val preKey = if (page > 1) page - 1 else null
            val nextKey = if (items.isNotEmpty() && items.size == pageSize) page + 1 else null
            LoadResult.Page(items, preKey, nextKey)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}