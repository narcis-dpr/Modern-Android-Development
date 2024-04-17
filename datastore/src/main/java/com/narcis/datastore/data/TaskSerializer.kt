package com.narcis.datastore.data

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.google.protobuf.InvalidProtocolBufferException
import com.narcis.datastore.TaskPreference
import java.io.InputStream
import java.io.OutputStream

object TaskSerializer : Serializer<TaskPreference> {
    override val defaultValue: TaskPreference
        get() = TaskPreference.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): TaskPreference {
        try {
            return TaskPreference.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto", exception)
        }
    }

    override suspend fun writeTo(t: TaskPreference, output: OutputStream) = t.writeTo(output)

}