package dev.junsung.process

import java.io.BufferedReader
import java.io.File
import java.util.concurrent.TimeUnit
import kotlin.time.Duration

object Process {
    fun run(
        vararg command: String,
        directory: File = File("."),
        timeout: Duration = Duration.INFINITE,
    ): BufferedReader {
        val process =
            ProcessBuilder(*command)
                .directory(directory)
                .redirectOutput(ProcessBuilder.Redirect.PIPE)
                .redirectError(ProcessBuilder.Redirect.PIPE)
                .start()

        if (timeout.isInfinite()) {
            process.waitFor()
        } else {
            process.waitFor(timeout.inWholeMilliseconds, TimeUnit.MILLISECONDS)
        }

        return process.inputStream.bufferedReader()
    }
}
