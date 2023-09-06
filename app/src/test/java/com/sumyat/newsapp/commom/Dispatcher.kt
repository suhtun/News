package com.sumyat.newsapp.commom

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val dispatcher: NewsDispatchers)

enum class NewsDispatchers {
    IO
}
