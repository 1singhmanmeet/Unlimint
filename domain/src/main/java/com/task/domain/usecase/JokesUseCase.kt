package com.task.domain.usecase

import com.task.domain.repository.JokesRepo
import com.task.domain.usecase.base.BaseUseCase

class JokesUseCase constructor(
    private val jokesRepo: JokesRepo
) : BaseUseCase<List<String>>() {

    var isFirst=true
    override suspend fun run()=jokesRepo.getJokes(isFirst)

}