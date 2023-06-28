package com.example.contacts.composable.baseScreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import com.example.contacts.ui.theme.ContactsTheme
import com.example.contacts.viewModel.IBaseViewModel
import kotlinx.coroutines.flow.SharedFlow

abstract class BaseScreen<STATE : Any, ACTION : Any, EFFECT : Any, VIEW_MODEL> where VIEW_MODEL : IBaseViewModel<STATE, ACTION, EFFECT>, VIEW_MODEL : ViewModel {

    @Composable
    fun Content(viewModel: VIEW_MODEL) {
        val state = viewModel.uiState.collectAsState().value
        val effect = viewModel.effect
        val proccesUIAction: (ACTION) -> Unit =
            { action: ACTION -> viewModel.processUIAction(action) }
        ContactsTheme {
            Screen(state, effect, proccesUIAction)
        }
    }

    @Composable
    abstract fun Screen(
        state: STATE,
        effect: SharedFlow<EFFECT>,
        processUiAction: (action: ACTION) -> Unit
    )
}
