package com.github.tryflle.fakenameenhanced

import com.github.tryflle.fakenameenhanced.command.FakeNameColorCommand
import com.github.tryflle.fakenameenhanced.command.FakeNameCommand
import com.github.tryflle.fakenameenhanced.util.Config
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback

class FakeNameEnhanced : ClientModInitializer {

    override fun onInitializeClient() {
        Config.load()

        ClientCommandRegistrationCallback.EVENT.register { dispatcher, _ ->
            FakeNameCommand.register(dispatcher)
            FakeNameColorCommand.register(dispatcher)
        }
    }
}
