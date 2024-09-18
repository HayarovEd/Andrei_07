package com.shesound.sapppowertools.data.repository

import android.app.Application
import android.media.SoundPool
import com.shesound.sapppowertools.domain.repository.SoundRepository
import javax.inject.Inject

class SoundRepositoryImpl
@Inject constructor(
    private val application: Application,
    private val soundPool: SoundPool
): SoundRepository {

    override fun playSound(soundId: Int) {
        soundPool.play(soundId, 1.0f, 1.0f, 1, 0, 1.0f)
    }

    override fun stopSound() {
        soundPool.release()
    }

}