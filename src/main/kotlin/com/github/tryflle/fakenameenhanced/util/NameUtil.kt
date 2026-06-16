package com.github.tryflle.fakenameenhanced.util

import net.minecraft.client.Minecraft

object NameUtil {

    fun replaceString(input: String): String? {
        return if (!Config.enabled || Minecraft.getInstance().player == null) {
            input
        } else {
            val originalName = Minecraft.getInstance().player?.gameProfile?.name ?: return input
            if (!input.contains(originalName, ignoreCase = true)) return input

            val regex = Regex(Regex.escape(originalName), RegexOption.IGNORE_CASE)
            input.replace(regex, Config.entry)
        }
    }
}