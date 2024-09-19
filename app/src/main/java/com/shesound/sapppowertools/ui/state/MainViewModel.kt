package com.shesound.sapppowertools.ui.state

import androidx.lifecycle.ViewModel
import com.shesound.sapppowertools.domain.model.AppState
import com.shesound.sapppowertools.domain.repository.ServiceRepository
import com.shesound.sapppowertools.domain.repository.SoundRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val soundRepository: SoundRepository,
    repository: ServiceRepository
) : ViewModel() {

    private var _state = MutableStateFlow(MainState())
    val state = _state.asStateFlow()

    init {
        if (repository.isNetworkConnected()) {
            _state.value.copy(
                appState = AppState.Web
            )
                .updateStateUI()
        } else {
            _state.value.copy(
                appState = AppState.Start
            )
                .updateStateUI()
        }
    }


    fun onEvent(event: MainEvent) {
        when (event) {
            is MainEvent.OnChangeAppState -> {
                _state.value.copy(
                    appState = event.appState
                )
                    .updateStateUI()
                soundRepository.stopSound()
            }

            is MainEvent.PlaySound -> {
                soundRepository.playSound(event.sound)
            }
        }
    }


    private fun MainState.updateStateUI() {
        _state.update {
            this
        }
    }
}