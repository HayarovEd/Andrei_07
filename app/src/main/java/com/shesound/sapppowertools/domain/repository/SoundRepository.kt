package com.shesound.sapppowertools.domain.repository



interface SoundRepository {
    fun playSound(soundId: Int)
    fun stopSound()
}