package com.shesound.sapppowertools.domain.model

sealed interface AppState {
    data object Start : AppState
    data object Tools : AppState
    class CurrentTool(val tool: Tool) : AppState
    data object Web : AppState
}