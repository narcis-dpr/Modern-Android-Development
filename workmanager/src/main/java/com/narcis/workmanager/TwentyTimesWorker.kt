package com.narcis.workmanager

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.io.IOException

class TwentyTimesWorker(context: Context, params: WorkerParameters):
Worker(context, params){
    override fun doWork(): ListenableWorker.Result {
        repeat(20) {
            try {

            } catch (e: IOException) {
                return ListenableWorker.Result.failure()
            }
        }
        return ListenableWorker.Result.success()
    }
}