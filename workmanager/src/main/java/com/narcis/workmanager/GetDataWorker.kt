package com.narcis.workmanager

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.Data
import androidx.work.WorkerParameters
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class GetDataWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted workerParameters: WorkerParameters,
//    private val viewModel: NotificationViewModel
): CoroutineWorker(context, workerParameters) {
    override suspend fun doWork(): Result {
        val ourEndPoint = inputData.getString(
            "EndPoint_Req"
        )
        if (ourEndPoint != null) {
//            getData(ourEndPoint)
        }
    val dataToOutput = Data.Builder()
        .putString("", "data")
        .build()
    return Result.success()
    }

}