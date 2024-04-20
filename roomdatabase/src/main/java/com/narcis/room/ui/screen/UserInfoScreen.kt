package com.narcis.room.ui.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.narcis.room.R
import com.narcis.room.UserInfoViewModel
import com.narcis.room.data.UserInfo
import com.narcis.room.ui.screen.components.SaveButton
import com.narcis.room.ui.screen.components.UserInfoTextField

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun UserInfoScreen(userInfoViewModel: UserInfoViewModel) {
    val firstName = remember {
        mutableStateOf("")
    }
    val lastName = remember {
        mutableStateOf("")
    }
    val dateOfBirth = remember {
        mutableStateOf("")
    }
    val gender = remember {
        mutableStateOf("")
    }
    val city = remember {
        mutableStateOf("")
    }

    val profession = remember {
        mutableStateOf("")
    }
    val scrollState = rememberScrollState()


    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(color = colorResource(id = R.color.purple_700))
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = null)
        }
        Card(
            shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .background(color = colorResource(id = R.color.purple_700))
                .weight(5.0f), elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
                    .scrollable(scrollState, Orientation.Vertical),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                UserInfoTextField(text = firstName.value,
                    onFieldChange = { firstName.value = it },
                    label = { Text(text = stringResource(id = R.string.enter_first_name)) })

                UserInfoTextField(text = lastName.value,
                    onFieldChange = { lastName.value = it },
                    label = { Text(text = stringResource(id = R.string.enter_last_name)) })

                UserInfoTextField(text = dateOfBirth.value,
                    onFieldChange = { dateOfBirth.value = it },
                    label = { Text(text = stringResource(id = R.string.enter_third_task)) })

                UserInfoTextField(text = gender.value, onFieldChange = { gender.value = it },
                    label = { Text(text = stringResource(id = R.string.enter_gender)) })

                UserInfoTextField(text = city.value, onFieldChange = { city.value = it },
                    label = { Text(text = stringResource(id = R.string.enter_city)) })

                UserInfoTextField(text = profession.value,
                    onFieldChange = { profession.value = it },
                    label = { Text(text = stringResource(id = R.string.enter_profession)) })


                SaveButton(onClick = {
                    val userInfo = UserInfo(
                        firstName = firstName.value,
                        lastName = lastName.value,
                        dateOfBirth = dateOfBirth.value.toInt(),
                        gender = gender.value,
                        city = city.value,
                        profession = profession.value
                    )
                    userInfoViewModel.saveUserInformationData(userInfo)
                }, text = stringResource(id = R.string.save))

            }
        }
    }
    }