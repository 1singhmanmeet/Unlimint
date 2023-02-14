package com.task.domain.usecase.base

interface BaseResponse<Type> where Type:Any{

    fun onSuccess(result: Type)

    fun onError(apiError: Exception?)
}