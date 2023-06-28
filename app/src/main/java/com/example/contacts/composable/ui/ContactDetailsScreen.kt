package com.example.contacts.composable.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import com.example.contacts.R
import com.example.contacts.composable.baseScreen.BaseScreen
import com.example.contacts.viewModelImpl.contactDetails.ContactDetailsScreenAction
import com.example.contacts.viewModelImpl.contactDetails.ContactDetailsScreenEffect
import com.example.contacts.viewModelImpl.contactDetails.ContactDetailsScreenState
import com.example.contacts.viewModelImpl.contactDetails.ContactDetailsScreenViewModel
import kotlinx.coroutines.flow.SharedFlow

object ContactDetailsScreen :
    BaseScreen<ContactDetailsScreenState, ContactDetailsScreenAction, ContactDetailsScreenEffect, ContactDetailsScreenViewModel>() {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Screen(
        state: ContactDetailsScreenState,
        effect: SharedFlow<ContactDetailsScreenEffect>,
        processUiAction: (action: ContactDetailsScreenAction) -> Unit
    ) {
        val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                TopAppBar(
                    scrollBehavior = scrollBehavior,
                    title = {
                        Text(
                            text = stringResource(R.string.contact_detail),
                            modifier = Modifier.fillMaxWidth(),
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            processUiAction(ContactDetailsScreenAction.TopBarBackButton)
                        }) {
                            Icon(Icons.Filled.ArrowBack, "backIcon")
                        }
                    },
                )
            }
        ) { padding ->
            Column(
                modifier = Modifier
                    .padding(top = padding.calculateTopPadding())
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.contact_detail),
                )
            }
        }
    }
}