package com.example.consumerestapi.ui.viewmodel

import android.text.Editable.Factory
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.consumerestapi.MahasiswaAplications

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer { HomeViewModel(MahasiswaApp().container.mahasiswaRepository) }
        initializer { InsertViewModel(MahasiswaApp().container.mahasiswaRepository) }
    }
}

fun CreationExtras.MahasiswaApp():MahasiswaAplications =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MahasiswaAplications)