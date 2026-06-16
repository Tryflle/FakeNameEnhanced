package com.github.tryflle.fakenameenhanced.command

import com.mojang.brigadier.CommandDispatcher
//? if >=26.1 {
import net.fabricmc.fabric.api.client.command.v2.ClientCommands.literal
//? } else
//import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal

import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource
import net.minecraft.ChatFormatting
import net.minecraft.network.chat.Component

object FakeNameColorCommand {

    fun register(dispatcher: CommandDispatcher<FabricClientCommandSource>) {
        dispatcher.register(
            literal("fakenamecolor")
                .executes { ctx ->
                    val message = Component.literal(
                        "These are the chat formatting options that are available:"
                    ).withStyle(ChatFormatting.AQUA).apply {
                        append(Component.literal("\n&f - White").withStyle(ChatFormatting.WHITE))
                        append(Component.literal("\n&d - Light Purple").withStyle(ChatFormatting.LIGHT_PURPLE))
                        append(Component.literal("\n&b - Aqua").withStyle(ChatFormatting.AQUA))
                        append(Component.literal("\n&a - Green").withStyle(ChatFormatting.GREEN))
                        append(Component.literal("\n&9 - Blue").withStyle(ChatFormatting.BLUE))
                        append(Component.literal("\n&e - Yellow").withStyle(ChatFormatting.YELLOW))
                        append(Component.literal("\n&c - Red").withStyle(ChatFormatting.RED))
                        append(Component.literal("\n&2 - Dark Green").withStyle(ChatFormatting.DARK_GREEN))
                        append(Component.literal("\n&3 - Dark Aqua").withStyle(ChatFormatting.DARK_AQUA))
                        append(Component.literal("\n&4 - Dark Red").withStyle(ChatFormatting.DARK_RED))
                        append(Component.literal("\n&5 - Dark Purple").withStyle(ChatFormatting.DARK_PURPLE))
                        append(Component.literal("\n&1 - Dark Blue").withStyle(ChatFormatting.DARK_BLUE))
                        append(Component.literal("\n&6 - Gold").withStyle(ChatFormatting.GOLD))
                        append(Component.literal("\n&7 - Gray").withStyle(ChatFormatting.GRAY))
                        append(Component.literal("\n&8 - Dark Gray").withStyle(ChatFormatting.DARK_GRAY))
                        append(Component.literal("\n&0 - Black").withStyle(ChatFormatting.BLACK))
                        append(Component.literal("\n&l - Bold").withStyle(ChatFormatting.BOLD))
                        append(Component.literal("\n&n - Underline").withStyle(ChatFormatting.UNDERLINE))
                        append(Component.literal("\n&o - Italic").withStyle(ChatFormatting.ITALIC))
                        append(Component.literal("\n&m - Strikethrough").withStyle(ChatFormatting.STRIKETHROUGH))
                        append(Component.literal("\n&r - Reset").withStyle(ChatFormatting.RESET))
                    }

                    ctx.source.sendFeedback(message)
                    1
                }
        )
    }
}