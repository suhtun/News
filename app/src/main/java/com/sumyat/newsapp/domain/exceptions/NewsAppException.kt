package com.sumyat.newsapp.domain.exceptions

sealed class NewsAppException(errorMessage:String): Exception(errorMessage){
    object InvalidDataException: NewsAppException("Data can't be empty.")
}
