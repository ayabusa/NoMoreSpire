package dev.ayabusa.nomorespire;

import dev.ayabusa.nomorespire.event.ChatMessageHandler;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.message.v1.ClientReceiveMessageEvents;

public class NoMoreSpire implements ModInitializer {
    /**
     * Runs the mod initializer.
     */
    @Override
    public void onInitialize() {
        System.out.println("[NoMoreSpire] Mod Loaded !");
        ClientReceiveMessageEvents.ALLOW_GAME.register(new ChatMessageHandler());
    }
}
