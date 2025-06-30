package com.github.tryflle.fakenameenhanced.util

import net.minecraft.client.Minecraft

object NameUtil {

    fun replaceString(input: String): String? {
        return if (!Config.enabled || Minecraft.getMinecraft().thePlayer == null) {
            input
        } else {
            val originalName = Minecraft.getMinecraft().thePlayer.displayNameString
            val index = input.indexOf(originalName)
            if (index == -1) return input
            val formattingAfter = input.substring(index + originalName.length)
                .takeWhile { it == '§' || it in '0'..'9' || it in 'a'..'f' || it in 'k'..'o' || it == 'r' }
            input.replace(Minecraft.getMinecraft().thePlayer.displayNameString, Config.entry + formattingAfter)
        }
    }
}