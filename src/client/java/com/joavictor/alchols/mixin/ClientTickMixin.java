package com.joavictor.alchols.mixin;

import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class ClientTickMixin {

    
    @Inject(method = "tick", at = @At("HEAD"))
    public void alchols$optimizeClientTicks(CallbackInfo ci) {
        Minecraft client = (Minecraft) (Object) this;

        
        if (client.player == null || client.isPaused()) {
            client.levelRenderer.needsUpdate(); 
        }
    }
}
