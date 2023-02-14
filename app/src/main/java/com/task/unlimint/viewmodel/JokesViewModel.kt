package com.task.unlimint.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.domain.usecase.JokesUseCase
import com.task.domain.usecase.base.BaseResponse
import com.task.unlimint.addToStart

class JokesViewModel constructor(private val jokesUseCase: JokesUseCase) : ViewModel() {

    var jokesList: MutableList<String> = mutableListOf()
    private val jokesData_ = MutableLiveData<List<String>>()
    val jokesData = jokesData_

    fun getJokes() {
        jokesUseCase.invoke(
            viewModelScope,
            object : BaseResponse<List<String>> {
                override fun onSuccess(result: List<String>) {
                    Log.e("ViewModel","listSize: ${result.size}")
                    jokesList = result.toMutableList()
                    jokesData_.value = jokesList
                }

                override fun onError(apiError: Exception?) {
                    getJokes()
                    Log.i("Exception:", "Error occurred" + apiError?.message.toString())
                }
            }

        )
    }

}