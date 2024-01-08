# ProcessKt

ProcessKt is a versatile open-source project designed to simplify and enhance the execution of shell commands, providing
a seamless experience for developers working with Kotlin. This project empowers users to effortlessly integrate and
manage shell commands within their Kotlin applications, fostering efficiency and flexibility in command-line operations.

## Maven

```xml

<dependency>
    <groupId>dev.junsung</groupId>
    <artifactId>process-kt</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Gradle

```kotlin
implementation("dev.junsung:process-kt:1.0.0")
```

## Quickstart

### Run command

```kotlin
Process.run("ls", "-la")
```

### Read Output

`Process.run()` returns `BufferedReader`.

```kotlin
// read all output into single String
val text: String = Process.run("ls", "-la").readText()

// read all output but split into lines
val lines: List<String> = Process.run("ls", "-la").readLines()

// read the first line of output
val firstLine: String = Process.run("ls", "-la").readLine()
```

### Set Directory

The default directory is current directory (`File(".")`).

```kotlin
Process.run("ls", "-la", directory = File("/"))
```

### Set Timeout

Set timeout using `kotlin.time.Duration`.

```kotlin
Process.run("ls", "-la", timeout = 1.minutes)
```