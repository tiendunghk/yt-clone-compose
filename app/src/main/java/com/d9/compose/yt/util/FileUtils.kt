package com.d9.compose.yt.util

import android.graphics.Bitmap
import android.media.MediaMetadataRetriever

object FileUtils {
    fun getThumb(videoUrl: String, frameTimeAt : Long = 1_000_000): Bitmap? {
        val retriever = MediaMetadataRetriever()
        retriever.setDataSource(videoUrl)
        val bitmap = retriever.getFrameAtTime(frameTimeAt)
        return bitmap
    }
}