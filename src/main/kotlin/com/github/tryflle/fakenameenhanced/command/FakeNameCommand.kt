package com.github.tryflle.fakenameenhanced.command

import com.github.tryflle.fakenameenhanced.util.Config
import net.minecraft.client.Minecraft
import net.minecraft.command.CommandBase
import net.minecraft.command.ICommandSender
import net.minecraft.util.ChatComponentText
import net.minecraft.util.EnumChatFormatting

class FakeNameCommand : CommandBase() {

    private val colorMap = hashMapOf<String, String>(
        Pair("&f", EnumChatFormatting.WHITE.toString()),
        Pair("&d", EnumChatFormatting.LIGHT_PURPLE.toString()),
        Pair("&b", EnumChatFormatting.AQUA.toString()),
        Pair("&a", EnumChatFormatting.GREEN.toString()),
        Pair("&9", EnumChatFormatting.BLUE.toString()),
        Pair("&e", EnumChatFormatting.YELLOW.toString()),
        Pair("&c", EnumChatFormatting.RED.toString()),
        Pair("&7", EnumChatFormatting.GRAY.toString()),
        Pair("&8", EnumChatFormatting.DARK_GRAY.toString()),
        Pair("&0", EnumChatFormatting.BLACK.toString()),
        Pair("&l", EnumChatFormatting.BOLD.toString()),
        Pair("&n", EnumChatFormatting.UNDERLINE.toString()),
        Pair("&o", EnumChatFormatting.ITALIC.toString()),
        Pair("&m", EnumChatFormatting.STRIKETHROUGH.toString()),
        Pair("&r", EnumChatFormatting.RESET.toString()),
        Pair("&6", EnumChatFormatting.GOLD.toString()),
        Pair("&2", EnumChatFormatting.DARK_GREEN.toString()),
        Pair("&3", EnumChatFormatting.DARK_AQUA.toString()),
        Pair("&4", EnumChatFormatting.DARK_RED.toString()),
        Pair("&5", EnumChatFormatting.DARK_PURPLE.toString()),
        Pair("&1", EnumChatFormatting.DARK_BLUE.toString())
        )

    override fun getCommandName(): String {
        return "fakename"
    }

    override fun getCommandUsage(sender: ICommandSender): String {
        return "/fakename name"
    }

    override fun getRequiredPermissionLevel(): Int {
        return 0
    }

    override fun processCommand(sender: ICommandSender?, args: Array<out String?>?) {
        if (args != null && args.isEmpty()) {
            Config.enabled = false
            Config.save()
            Minecraft.getMinecraft()?.thePlayer?.addChatMessage(ChatComponentText(EnumChatFormatting.LIGHT_PURPLE.toString() + "Disabled FakeNameEnhanced"))
        } else {
            Config.enabled = true
            var replaceString = args?.joinToString(" ") ?: "something died"
            for ((code, formatting) in colorMap) {
                replaceString = replaceString.replace(code, formatting)
            }
            Config.entry = replaceString
            Config.save()
            Minecraft.getMinecraft()?.thePlayer?.addChatMessage(ChatComponentText(EnumChatFormatting.LIGHT_PURPLE.toString() + "Enabled FakeNameEnhanced with name: " + replaceString))
        }
    }
}