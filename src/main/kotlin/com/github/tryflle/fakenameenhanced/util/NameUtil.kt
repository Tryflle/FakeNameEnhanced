package com.github.tryflle.fakenameenhanced.util

import net.minecraft.client.Minecraft

object NameUtil {

    fun replaceString(input: String): String? {
        return if (!Config.enabled || Minecraft.getMinecraft().thePlayer == null) { input }
        else {
            input.replace(Minecraft.getMinecraft().thePlayer.displayNameString, Config.entry)
        }
    }
}