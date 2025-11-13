package com.joavictor.alchols;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;

public class AlcholsClient implements ClientModInitializer {

    private boolean sentMessage = false;

    @Override
    public void onInitializeClient() {

        ClientTickEvents.END_CLIENT_TICK.register(client -> {

            
            if (client.player != null && !sentMessage) {
                sentMessage = true;

                
                client.gui.getChat().addMessage(
                        Component.literal("§a[Alchols] Mod carregado e funcionando com sucesso!")
                );
            }

            
            if (client.player == null) {
                sentMessage = false;
            }
        });
    }
}
