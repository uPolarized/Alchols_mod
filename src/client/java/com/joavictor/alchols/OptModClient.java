package com.joavictor.alchols;

import net.fabricmc.api.ClientModInitializer;

public class OptModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        System.out.println("[Alchols] Client carregado com sucesso!");
    }
}
