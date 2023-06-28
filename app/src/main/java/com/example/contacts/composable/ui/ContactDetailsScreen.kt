package com.example.contacts.composable.ui


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.contacts.R
import com.example.contacts.composable.baseScreen.BaseScreen
import com.example.contacts.util.CommonUtils
import com.example.contacts.viewModelImpl.contactDetails.ContactDetailsScreenAction
import com.example.contacts.viewModelImpl.contactDetails.ContactDetailsScreenEffect
import com.example.contacts.viewModelImpl.contactDetails.ContactDetailsScreenState
import com.example.contacts.viewModelImpl.contactDetails.ContactDetailsScreenViewModel
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage
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

            when (state) {
                ContactDetailsScreenState.LoadingState -> {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        CircularProgressIndicator()
                    }
                }

                is ContactDetailsScreenState.ShowContactState -> {

                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(padding)
                        ) {
                            if (state.contact.id % 2 != 0) {
                                GlideImage(
                                    modifier = Modifier
                                        .width(50.dp)
                                        .height(50.dp)
                                        .clip(CircleShape),
                                    imageModel = "https://picsum.photos/200/200",
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
                                    text = CommonUtils.provideNameInitials(state.contact.name),
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                            Spacer(modifier = Modifier.padding(8.dp))
                            Text(
                                text = state.contact.name,
                                style = TextStyle(textAlign = TextAlign.Center)
                            )
                            Spacer(modifier = Modifier.padding(8.dp))
                            Text(text = state.contact.email, color = Color.Gray)
                            Spacer(modifier = Modifier.padding(8.dp))
                        }
                    }
                }
            }

        }
    }
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .background(Color.White)
//                    .padding(vertical = 16.dp),
//            ) {
//                Box(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(padding)
//                ) {
//                    if (2548892 % 2 != 0) {
//                        GlideImage(
//                            modifier = Modifier
//                                .width(50.dp)
//                                .height(50.dp)
//                                .clip(CircleShape),
//                            imageModel = "https://avatars.githubusercontent.com/u/27887884?v=4",
//                            contentScale = ContentScale.Crop,
//                            circularReveal = CircularReveal(duration = 250),
//                        )
//                    } else {
//                        Text(
//                            modifier = Modifier
//                                .drawBehind {
//                                    drawCircle(
//                                        color = Color(188, 200, 211),
//                                        radius = 60f
//                                    )
//                                }
//                                .padding(16.dp),
//                            text = CommonUtils.provideNameInitials("Kocsis Bogdan"),
//                            fontWeight = FontWeight.SemiBold
//                        )
//                    }
//
//                    Text(
//                        text = "Kocsis Bogdan",
//                        style = MaterialTheme.typography.bodyMedium,
//                        modifier = Modifier
//                            .align(Alignment.Center)
//                            .padding(end = 120.dp)
//                    )
//
//                }
//            }
//        }
//    }
}

