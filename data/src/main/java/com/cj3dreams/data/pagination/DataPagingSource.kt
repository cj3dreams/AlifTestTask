package com.cj3dreams.data.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.cj3dreams.domain.model.PreDataEntity
import com.cj3dreams.domain.usecase.GetAllDataFromLocalWithPagingUseCase
import kotlinx.coroutines.delay

class DataPagingSource(
    private val getAllDataFromLocalWithPagingUseCase: GetAllDataFromLocalWithPagingUseCase
) : PagingSource<Int, PreDataEntity>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PreDataEntity> {
        val page = params.key ?: 0
        return try {
            val entities = getAllDataFromLocalWithPagingUseCase.invoke(params.loadSize, page * params.loadSize)

            if (page != 0) delay(1000)

            LoadResult.Page(
                data = entities,
                prevKey = if (page == 0) null else page - 1,
                nextKey = if (entities.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, PreDataEntity>) =
        state.anchorPosition?.let { anchorPosition ->
        val anchorPage = state.closestPageToPosition(anchorPosition)
        anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
    }
}