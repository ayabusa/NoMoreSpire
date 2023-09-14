package dev.ayabusa.nomorespire;

import dev.ayabusa.nomorespire.event.ChatMessageHandler;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.message.v1.ServerMessageEvents;

public class NoMoreSpire implements ModInitializer {
    /**
     * Runs the mod initializer.
     */
    @Override
    public void onInitialize() {
        System.out.println("[NoMoreSpire] Mod Loaded !");
        // ServerMessageEvents.ALLOW_GAME_MESSAGE.register(new ChatMessageHandler());
    }
}
