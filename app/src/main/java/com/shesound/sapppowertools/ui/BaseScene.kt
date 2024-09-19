package com.shesound.sapppowertools.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.shesound.sapppowertools.domain.model.AppState
import com.shesound.sapppowertools.ui.state.MainEvent
import com.shesound.sapppowertools.ui.state.MainViewModel

@Composable
fun BaseScene(
    viewModel: MainViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState()
    val onEvent = viewModel::onEvent
    when (val rs = state.value.appState) {
        is AppState.CurrentTool -> {
            CurrentToolScreen(
                tool = rs.tool,
                onClick = {
                    onEvent(MainEvent.PlaySound(rs.tool.sound))
                },
                onBackClick = {
                    onEvent(MainEvent.OnChangeAppState(AppState.Tools))
                }
            )
        }

        AppState.Start -> {
            StartScreen(
                onClick = {
                    onEvent(MainEvent.OnChangeAppState(AppState.Tools))
                }
            )
        }

        AppState.Tools -> {
            ToolsScreen(
                onEvent = onEvent
            )
        }

        AppState.Web -> {
            WebViewScreen (
                onEvent = onEvent
            )
        }
    }
}