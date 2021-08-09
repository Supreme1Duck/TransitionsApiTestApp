package com.example.transitionsapitestapp.data

import com.example.transitionsapitestapp.domain.IRepository

class RepositoryImpl: IRepository {

    override fun getData(name: String):String{
        return "Hello $name"
    }
}