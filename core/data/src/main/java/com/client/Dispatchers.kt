package com.client

import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME

@Qualifier
@Retention(RUNTIME)
annotation class Dispatcher(val employDispatcher: EmployDispatchers)

enum class EmployDispatchers {
    Default,
    IO
}
