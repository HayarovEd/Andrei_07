package com.shesound.sapppowertools.ui.state

import com.shesound.sapppowertools.domain.model.AppState


sealed class MainEvent {
    class OnChangeAppState(val appState: AppState) : MainEvent()
    class PlaySound(val sound: Int) : MainEvent()
}
