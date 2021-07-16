package com.flany.paging.network

import com.flany.paging.bean.RepositoryBean
import com.google.gson.annotations.SerializedName

/**
 * @author: hec@shuyilink.com
 * @date:   2021/7/15
 * @since:
 */
class ApiResponse(@SerializedName("items") val items: List<RepositoryBean> = emptyList())