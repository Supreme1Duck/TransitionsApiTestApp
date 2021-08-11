package com.example.transitionsapitestapp.data

import com.example.transitionsapitestapp.domain.IRepository

class RepositoryImpl(
    private val database: Database
): IRepository {

    override fun getData(name: String):String{
        return "Hello $name"
    }

    fun getDatabase(): String {
        return database.name
    }
}