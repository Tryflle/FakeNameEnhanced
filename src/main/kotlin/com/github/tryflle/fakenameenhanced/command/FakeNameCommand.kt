package com.github.tryflle.fakenameenhanced.command

import com.github.tryflle.fakenameenhanced.util.Config
import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.arguments.StringArgumentType
//? if >=26.1 {
import net.fabricmc.fabric.api.client.command.v2.ClientCommands.argument
import net.fabricmc.fabric.api.client.command.v2.ClientCommands.literal
//? } else {
/*import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.argument
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal
*///? }
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource
import net.minecraft.ChatFormatting
import net.minecraft.client.Minecraft
import net.minecraft.network.chat.Component

object FakeNameCommand {

    private val colorMap = mapOf(
        "&f" to ChatFormatting.WHITE,
        "&d" to ChatFormatting.LIGHT_PURPLE,
        "&b" to ChatFormatting.AQUA,
        "&a" to ChatFormatting.GREEN,
        "&9" to ChatFormatting.BLUE,
        "&e" to ChatFormatting.YELLOW,
        "&c" to ChatFormatting.RED,
        "&7" to ChatFormatting.GRAY,
        "&8" to ChatFormatting.DARK_GRAY,
        "&0" to ChatFormatting.BLACK,
        "&l" to ChatFormatting.BOLD,
        "&n" to ChatFormatting.UNDERLINE,
        "&o" to ChatFormatting.ITALIC,
        "&m" to ChatFormatting.STRIKETHROUGH,
        "&r" to ChatFormatting.RESET,
        "&6" to ChatFormatting.GOLD,
        "&2" to ChatFormatting.DARK_GREEN,
        "&3" to ChatFormatting.DARK_AQUA,
        "&4" to ChatFormatting.DARK_RED,
        "&5" to ChatFormatting.DARK_PURPLE,
        "&1" to ChatFormatting.DARK_BLUE
    )

    fun register(dispatcher: CommandDispatcher<FabricClientCommandSource>) {

        dispatcher.register(
            literal("fakename")
                .executes { ctx ->
                    Config.enabled = false
                    Config.save()
                    //? if >=26.1 {
                    Minecraft.getInstance().player?.sendSystemMessage(Component.literal("Disabled FakeNameEnhanced").withStyle(ChatFormatting.LIGHT_PURPLE))
                    //? } else
                    //Minecraft.getInstance().player?.displayClientMessage(Component.literal("Disabled FakeNameEnhanced").withStyle(ChatFormatting.LIGHT_PURPLE), false)
                    1
                }
                .then(
                    argument("name", StringArgumentType.greedyString())
                        .executes { ctx ->
                            Config.enabled = true

                            var replaceString = StringArgumentType.getString(ctx, "name")

                            for ((code, formatting) in colorMap) replaceString = replaceString.replace(code, formatting.toString())

                            Config.entry = replaceString
                            Config.save()

                            //? if >=26.1 {
                            Minecraft.getInstance().player?.sendSystemMessage(Component.literal("Enabled FakeNameEnhanced with name: $replaceString").withStyle(ChatFormatting.LIGHT_PURPLE))
                            //? } else
                            //Minecraft.getInstance().player?.displayClientMessage(Component.literal("Enabled FakeNameEnhanced with name: $replaceString").withStyle(ChatFormatting.LIGHT_PURPLE), false)
                            1
                        }
                )
        )
    }
}