package com.orels.deepsiam.data

import javax.inject.Inject

class EnvironmentRepository @Inject constructor(){
    val currentEnvironment: Environments = Environments.Dev
}

enum class Environments {
    Production,
    Dev
}