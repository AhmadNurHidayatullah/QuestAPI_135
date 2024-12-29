package com.example.consumerestapi.ui.viewmodel

import com.example.consumerestapi.model.Mahasiswa

data class InsertUiEvent(
    val nim:String="",
    val nama:String="",
    val alamat:String="",
    val jenisKelamin:String="",
    val kelas:String="",
    val angkatan:String=""
)

fun InsertUiEvent.toMhs(): Mahasiswa = Mahasiswa(
    nim = nim,
    nama = nama,
    alamat = alamat,
    jenisKelamin = jenisKelamin,
    kelas = kelas,
    angkatan = angkatan
)

fun Mahasiswa.toUiStateMhs(): InsertUiState = InsertUiState(
    insertUiEvent = toInsertUiEvent()
)

fun Mahasiswa.toInsertUiEvent(): InsertUiEvent = InsertUiEvent(
    nim = nim,
    nama = nama,
    alamat = alamat,
    jenisKelamin = jenisKelamin,
    kelas = kelas,
    angkatan = angkatan
)