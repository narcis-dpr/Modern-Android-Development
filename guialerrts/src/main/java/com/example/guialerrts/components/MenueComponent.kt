package com.example.guialerrts.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.guialerrts.R
import kotlinx.coroutines.launch

@Composable
fun OurMenu() {
    var expanded by remember {
        mutableStateOf(false)
    }
    val menuItems = listOf("Item 1", "Item 2", "Item 3", "Item 4")
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current

    val snackbarHostState = remember {
        SnackbarHostState()
    }
    Scaffold(snackbarHost = { SnackbarHost(snackbarHostState) }) { scaffoldPadding ->
        Box(
            modifier = Modifier
                .width(200.dp)
                .padding(scaffoldPadding)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .clickable { expanded = true }
                        .width(120.dp)
                        .height(48.dp)
                        .background(color = MaterialTheme.colorScheme.onPrimary)
                ) {
                    Text(stringResource(id = R.string.menu))
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = stringResource(id = R.string.menu_drop_down),
                        modifier = Modifier.align(Alignment.CenterEnd)
                    )
                }
                DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                    menuItems.forEachIndexed { index, item ->
                        DropdownMenuItem(text = { Text(text = item) },
                            onClick = {
                                coroutineScope.launch {
                                    snackbarHostState.showSnackbar(
                                        message = "the selected item is : $item"
                                    )
                                }
                            })
                    }
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ShowMenuComponent(){
    OurMenu()
}