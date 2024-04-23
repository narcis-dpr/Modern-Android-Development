package com.narcis.workmanager

import android.content.Context
import android.webkit.WebChromeClient.FileChooserParams
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class DownloadWorkManager @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted workerParameters: WorkerParameters,
//    private val viewModel: NotificationViewModel
) : CoroutineWorker(context, workerParameters) {
    override suspend fun doWork(): Result {
        val file = inputData.getString("name") ?: ""

        if (file.isEmpty()) {
            Result.failure()
        }

        val uri = ""
        return if (uri != null) {
            Result.success(
                workDataOf(
                    uri to 2
                )
            )
        } else {
            Result.failure()
        }
    }
}