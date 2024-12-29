package com.example.consumerestapi

import android.app.Application
import com.example.consumerestapi.Repository.AppContainer
import com.example.consumerestapi.Repository.MahasiswaContainer

class MahasiswaAplications:Application(){
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container=MahasiswaContainer()
    }
}