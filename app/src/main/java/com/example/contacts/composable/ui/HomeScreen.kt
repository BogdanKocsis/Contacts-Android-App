package com.example.contacts.composable.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.contacts.R
import com.example.contacts.composable.baseScreen.BaseScreen
import com.example.contacts.model.Contact
import com.example.contacts.util.CommonUtils
import com.example.contacts.viewModelImpl.home.HomeScreenAction
import com.example.contacts.viewModelImpl.home.HomeScreenEffect
import com.example.contacts.viewModelImpl.home.HomeScreenState
import com.example.contacts.viewModelImpl.home.HomeScreenViewModel
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage
import kotlinx.coroutines.flow.SharedFlow

object HomeScreen :
    BaseScreen<HomeScreenState, HomeScreenAction, HomeScreenEffect, HomeScreenViewModel>() {

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    override fun Screen(
        state: HomeScreenState,
        effect: SharedFlow<HomeScreenEffect>,
        processUiAction: (action: HomeScreenAction) -> Unit
    ) {
        when (state) {
            HomeScreenState.LoadingState -> {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    CircularProgressIndicator()
                }
            }

            is HomeScreenState.ShowContactsState -> {
                Column(modifier = Modifier.fillMaxSize()) {
                    Text(
                        text = stringResource(R.string.contacts),
                        style = MaterialTheme.typography.headlineLarge,
                        modifier = Modifier.padding(16.dp)
                    )
                    LazyColumn(
                        modifier = Modifier
                            .weight(1f)
                            .background(Color(234, 240, 246))
                    ) {
                        stickyHeader {
                            Text(
                                text = stringResource(R.string.my_contacts),
                                style = MaterialTheme.typography.titleSmall.copy(
                                    color = Color(
                                        153,
                                        170,
                                        191,
                                        255
                                    )
                                ),
                                modifier = Modifier.padding(16.dp),
                            )
                        }
                        items(state.contactsList) { contact ->
                            ContactListItem(contact, processUiAction)
                            Divider(thickness = 1.dp, color = Color(243, 246, 249))
                        }
                    }
                }

            }
        }

    }


    @Composable
    fun ContactListItem(
        contact: Contact,
        processUiAction: (action: HomeScreenAction) -> Unit
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(vertical = 16.dp)
                .clickable { processUiAction(HomeScreenAction.NavigateToContactDetails(contact.id.toString())) },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp)
            ) {
                if (contact.id % 2 != 0) {
                    GlideImage(
                        modifier = Modifier
                            .width(50.dp)
                            .height(50.dp)
                            .clip(CircleShape),
                        imageModel = "https://avatars.githubusercontent.com/u/27887884?v=4",
                        contentScale = ContentScale.Crop,
                        circularReveal = CircularReveal(duration = 250),
                    )
                } else {
                    Text(
                        modifier = Modifier
                            .drawBehind {
                                drawCircle(
                                    color = Color(188, 200, 211),
                                    radius = 60f
                                )
                            }
                            .padding(16.dp),
                        text = CommonUtils.provideNameInitials(contact.name),
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Text(
                    text = contact.name,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(end = 120.dp)
                )
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 16.dp)
                )
            }
        }
    }
}