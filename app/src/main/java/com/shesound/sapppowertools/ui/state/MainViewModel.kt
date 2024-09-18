package com.shesound.sapppowertools.ui.state

import androidx.lifecycle.ViewModel
import com.shesound.sapppowertools.domain.repository.SoundRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val soundRepository: SoundRepository
) : ViewModel() {

    private var _state = MutableStateFlow(MainState())
    val state = _state.asStateFlow()


    fun onEvent(event: MainEvent) {
        when (event) {
            is MainEvent.OnChangeAppState -> {
                _state.value.copy(
                    appState = event.appState
                )
                    .updateStateUI()
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