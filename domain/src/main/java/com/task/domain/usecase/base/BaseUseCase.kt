package com.task.domain.usecase.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

abstract class BaseUseCase<T> where T : Any {
    private val delayTime=1000*60L
    abstract suspend fun run(isFirst:Boolean): T
    open fun invoke(scope: CoroutineScope, onResult: BaseResponse<T>?) {
        scope.launch {
            try {
                var isFirst=true
                while(true) {
                    val result = run(isFirst)
                    isFirst=false
                    onResult?.onSuccess(result)
                    delay(delayTime)
                }
            }
            catch (e: Exception) {
                e.printStackTrace()
                onResult?.onError(e)
            }
        }
    }
}