package net.mino.githubrepofinder.data.mapper

import io.reactivex.functions.Function
import net.mino.githubrepofinder.data.datasource.entity.Owner
import net.mino.githubrepofinder.data.datasource.entity.RetrofitOwner

class RetrofitOwnerToModelMapper : Function<RetrofitOwner, Owner> {
    override fun apply(retrofitOwner: RetrofitOwner): Owner {
        return Owner(
                login = retrofitOwner.login
        )
    }
}