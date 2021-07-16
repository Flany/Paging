package com.flany.paging.bean

import com.google.gson.annotations.SerializedName

/**
 * @author: hec@shuyilink.com
 * @date:   2021/7/15
 * @since:
 */
data class RepositoryBean(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String?,
    @SerializedName("stargazers_count") val starCount: Int
)

