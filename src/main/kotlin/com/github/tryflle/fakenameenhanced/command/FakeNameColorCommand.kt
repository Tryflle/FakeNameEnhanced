package com.github.tryflle.fakenameenhanced.command

import net.minecraft.command.CommandBase
import net.minecraft.command.ICommandSender
import net.minecraft.util.ChatComponentText
import net.minecraft.util.EnumChatFormatting

class FakeNameColorCommand : CommandBase() {

    override fun getCommandName(): String? {
        return "fakenamecolor"
    }

    override fun getCommandUsage(sender: net.minecraft.command.ICommandSender?): String {
        return "Usage: /fakenamecolor <color_code>"
    }

    override fun getRequiredPermissionLevel(): Int {
        return 0
    }

    override fun processCommand(sender: ICommandSender?, args: Array<out String?>?) {
        sender?.addChatMessage(ChatComponentText(
            EnumChatFormatting.AQUA.toString() + "These are the chat formatting options that are available:"
            + "\n" + EnumChatFormatting.WHITE + " &f - White"
            + "\n" + EnumChatFormatting.LIGHT_PURPLE + " &d - Light Purple"
            + "\n" + EnumChatFormatting.AQUA + " &b - Aqua"
            + "\n" + EnumChatFormatting.GREEN + " &a - Green"
            + "\n" + EnumChatFormatting.BLUE + " &9 - Blue"
            + "\n" + EnumChatFormatting.YELLOW + " &e - Yellow"
            + "\n" + EnumChatFormatting.RED + " &c - Red"
            + "\n" + EnumChatFormatting.DARK_GREEN + " &2 - Dark Green"
            + "\n" + EnumChatFormatting.DARK_AQUA + " &3 - Dark Aqua"
            + "\n" + EnumChatFormatting.DARK_RED + " &4 - Dark Red"
            + "\n" + EnumChatFormatting.DARK_PURPLE + " &5 - Dark Purple"
            + "\n" + EnumChatFormatting.DARK_BLUE + " &1 - Dark Blue"
            + "\n" + EnumChatFormatting.GOLD + " &6 - Gold"
            + "\n" + EnumChatFormatting.GRAY + " &7 - Gray"
            + "\n" + EnumChatFormatting.DARK_GRAY + " &8 - Dark Gray"
            + "\n" + EnumChatFormatting.BLACK + " &0 - Black"
            + "\n" + EnumChatFormatting.BOLD + " &l - Bold"
            + "\n" + EnumChatFormatting.UNDERLINE + " &n - Underline"
            + "\n" + EnumChatFormatting.ITALIC + " &o - Italic"
            + "\n" + EnumChatFormatting.STRIKETHROUGH + " &m - Strikethrough"
            + "\n" + EnumChatFormatting.RESET + " &r - Reset"
        ))
    }
}