package com.example.transitionsapitestapp.domain

class UseCase(
    private val repository: IRepository
) : IUseCase {

    override fun execute(name: String): String {
        return repository.getData(name)
    }
}