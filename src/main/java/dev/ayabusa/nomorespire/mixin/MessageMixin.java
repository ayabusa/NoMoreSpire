package dev.ayabusa.nomorespire.mixin;

import net.fabricmc.tinyremapper.extension.mixin.common.Logger;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.network.message.MessageHandler;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.regex.Pattern;

@Mixin(MessageHandler.class)
public class MessageMixin {
    @Shadow @Final private MinecraftClient client;

    @Inject(at = @At("HEAD"), method = "onGameMessage", cancellable = true)
    private void onGameMessage(Text message, boolean overlay, CallbackInfo ci) { // If you read that note that I hate using Mixin

        String serverAddress = client.getCurrentServerEntry().address;

        if(Pattern.compile(Pattern.quote("spire"), Pattern.CASE_INSENSITIVE).matcher(message.getString()).find() &&
           Pattern.compile(Pattern.quote("originrealms"), Pattern.CASE_INSENSITIVE).matcher(serverAddress).find()
        ){ // check if spire is in the message and if connected to OR server
            try {
                System.out.println("[No More Spire] Cancelling following message : "+message.getString());
                ci.cancel(); // cancel method to block message from being displayed
            }
            catch (Exception e) {
                System.out.println(e); // Just in case something goes wrong
            }
        }
    }
}