package com.example.consumerestapi.ui.view

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.consumerestapi.ui.customwidget.CostumeTopAppBar
import com.example.consumerestapi.ui.navigation.DestinasiNavigasi
import com.example.consumerestapi.ui.viewmodel.PenyediaViewModel
import com.example.consumerestapi.ui.viewmodel.UpdateViewModel
import kotlinx.coroutines.launch


object DestinasiUpdate : DestinasiNavigasi {
    override val route = "update_view"
    override val titleRes = "Update Mahasiswa"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateScreen(
    nim: String,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: UpdateViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    val coroutineScope = rememberCoroutineScope()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    LaunchedEffect(nim) {
        viewModel.getMahasiswaById(nim)
    }

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection).padding(horizontal = 8.dp),
        topBar = {
            CostumeTopAppBar(
                title = DestinasiUpdate.titleRes,
                canNavigateBack = true,
                scrollBehavior = scrollBehavior,
                navigateUp = navigateBack
            )
        }
    ) { innerPadding ->
        UpdateBody(
            updateUiState = viewModel.updateUiState,
            onSiswaValueChange = viewModel::updateMhsState,
            onSaveClick = {
                coroutineScope.launch {
                    viewModel.updateMhs()
                    navigateBack()
                }
            },
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
        )
    }
}