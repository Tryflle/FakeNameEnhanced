package com.github.tryflle.fakenameenhanced.command

import com.github.tryflle.fakenameenhanced.util.Config
import net.minecraft.client.Minecraft
import net.minecraft.command.CommandBase
import net.minecraft.command.ICommandSender
import net.minecraft.util.ChatComponentText
import net.minecraft.util.EnumChatFormatting

class FakeNameCommand : CommandBase() {

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
            val replaceString = args?.joinToString(" ") ?: "something died"
            Config.entry = replaceString
            Config.save()
            Minecraft.getMinecraft()?.thePlayer?.addChatMessage(ChatComponentText(EnumChatFormatting.LIGHT_PURPLE.toString() + "Enabled FakeNameEnhanced with name: " + replaceString))
        }
    }
}