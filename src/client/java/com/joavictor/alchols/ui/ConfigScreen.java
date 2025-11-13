package com.joavictor.alchols.ui;

import com.joavictor.alchols.OptMod;
import com.joavictor.alchols.OptModConfig;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class ConfigScreen {

    public static Screen create(Screen parent) {
        OptModConfig config = OptMod.CONFIG;

        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(Component.literal("Alchols — Configurações"));

        ConfigCategory general = builder.getOrCreateCategory(Component.literal("Geral"));
        ConfigEntryBuilder entry = builder.entryBuilder();

        general.addEntry(entry
                .startIntField(Component.literal("Máximo de Threads"), config.maxThreads)
                .setDefaultValue(4)
                .setMin(1)
                .setMax(Runtime.getRuntime().availableProcessors())
                .setSaveConsumer(v -> config.maxThreads = v)
                .build());

        general.addEntry(entry
                .startIntField(Component.literal("RAM Alocada (MB)"), config.allocatedRamMB)
                .setDefaultValue(2048)
                .setMin(512)
                .setMax(32768)
                .setSaveConsumer(v -> config.allocatedRamMB = v)
                .build());

        general.addEntry(entry
                .startBooleanToggle(Component.literal("Ativar Multithreading"), config.enableMultithreading)
                .setSaveConsumer(v -> config.enableMultithreading = v)
                .build());

        general.addEntry(entry
                .startBooleanToggle(Component.literal("Pré-gerar Chunks"), config.enableChunkPreGen)
                .setSaveConsumer(v -> config.enableChunkPreGen = v)
                .build());

        builder.setSavingRunnable(() -> {
            try {
                java.nio.file.Path cfg = java.nio.file.Path.of("config", "alchols-config.json");
                com.google.gson.Gson gson = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
                java.nio.file.Files.createDirectories(cfg.getParent());
                java.nio.file.Files.writeString(cfg, gson.toJson(config));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        return builder.build();
    }
}
