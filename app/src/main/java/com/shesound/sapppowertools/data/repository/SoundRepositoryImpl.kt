package com.shesound.sapppowertools.data.repository

import android.app.Application
import android.media.MediaPlayer
import com.shesound.sapppowertools.domain.repository.SoundRepository
import javax.inject.Inject

class SoundRepositoryImpl
@Inject constructor(
    private val application: Application,
): SoundRepository {

    private var mediaPlayer: MediaPlayer? = null
    override fun playSound(soundId: Int) {
        if (mediaPlayer!=null&& mediaPlayer!!.isPlaying) {
           stopSound()
        } else {
            mediaPlayer?.stop()
            mediaPlayer?.release()
            mediaPlayer = MediaPlayer.create(application, soundId)
            mediaPlayer?.start()
        }
    }

    override fun stopSound() {
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}