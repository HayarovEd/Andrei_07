package com.shesound.sapppowertools.ui.state

import com.shesound.sapppowertools.domain.model.AppState


data class MainState(
    val appState: AppState = AppState.Start,
)
