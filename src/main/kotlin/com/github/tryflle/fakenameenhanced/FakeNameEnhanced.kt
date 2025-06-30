package com.github.tryflle.fakenameenhanced

import com.github.tryflle.fakenameenhanced.command.FakeNameColorCommand
import com.github.tryflle.fakenameenhanced.command.FakeNameCommand
import com.github.tryflle.fakenameenhanced.util.Config
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.client.ClientCommandHandler

@Mod(modid = "fakenameenhanced", useMetadata = true)
class FakeNameEnhanced {

    @Mod.EventHandler
    fun init(event: FMLInitializationEvent) {
        Config.load()
        ClientCommandHandler.instance.registerCommand(FakeNameCommand())
        ClientCommandHandler.instance.registerCommand(FakeNameColorCommand())
    }
}
