package com.example.transitionsapitestapp.domain

interface IUseCase {
    fun execute(name: String): String
}