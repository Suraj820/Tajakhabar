package com.example.tajakhabar.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.tajakhabar.domain.model.Article

class SearchNewsPagingSource(
    private val newsAPI: NewsAPI,
    private val searchQuery:String,
    private val sources:String,
    ):PagingSource<Int,Article>() {

    private var totalNewsCount = 0
    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return  state.anchorPosition?.let {
            val anchorPage = state.closestPageToPosition(it)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val page = params.key ?: 1
        return try {
            val response = newsAPI.searchNews(searchQuery,page,sources)

            totalNewsCount += response.articles.size

            val articles = response.articles.distinctBy { it.title }
            LoadResult.Page(
                data = articles,
                prevKey = null,
                nextKey = if (totalNewsCount >= response.totalResults) null else page + 1
            )
        }catch (e:Exception){
            LoadResult.Error(e)
        }
    }
}