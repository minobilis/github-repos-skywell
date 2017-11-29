package net.mino.githubrepofinder.data.mapper

import io.reactivex.functions.Function
import net.mino.githubrepofinder.data.datasource.entity.Item
import net.mino.githubrepofinder.data.datasource.entity.RetrofitItem

class RetrofitItemToModelMapper : Function<RetrofitItem, Item> {
    override fun apply(retrofitItem: RetrofitItem): Item {
        return Item(
                id = retrofitItem.id,
                fullName = retrofitItem.fullName,
                htmlUrl = retrofitItem.htmlUrl,
                retrofitOwner = retrofitItem.retrofitOwner
        )
    }
}