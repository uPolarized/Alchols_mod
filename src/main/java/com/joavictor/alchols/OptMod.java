package com.joavictor.alchols;

import net.fabricmc.api.ModInitializer;

public class OptMod implements ModInitializer {

    public static OptModConfig CONFIG = new OptModConfig();

    @Override
    public void onInitialize() {
        System.out.println("[Alchols] Inicializado com sucesso.");
    }
}
