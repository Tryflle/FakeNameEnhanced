package com.github.tryflle.fakenameenhanced.util

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.File

@Serializable
data class ConfigData(
    var enabled: Boolean = false,
    var entry: String = "placeholder"
)

object Config {
    private val configDir = File("config")
    private val configFile = File(configDir, "fakenameenhanced.json")
    private val json = Json { prettyPrint = true }

    var data = ConfigData()

    fun load() {
        if (configFile.exists()) {
            data = json.decodeFromString(ConfigData.serializer(), configFile.readText())
        }
    }

    fun save() {
        if (!configDir.exists()) configDir.mkdirs()
        configFile.writeText(json.encodeToString(ConfigData.serializer(), data))
    }

    var enabled: Boolean
        get() = data.enabled
        set(value) { data.enabled = value }

    var entry: String
        get() = data.entry
        set(value) { data.entry = value }
}