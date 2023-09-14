package dev.ayabusa.nomorespire.event;

import com.mojang.authlib.GameProfile;
import net.fabricmc.fabric.api.message.v1.ServerMessageEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.message.MessageType;
import net.minecraft.network.message.SignedMessage;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.filter.FilteredMessage;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.registry.RegistryKey;
import org.jetbrains.annotations.Nullable;

import java.time.Instant;
import java.util.regex.Pattern;

public class ChatMessageHandler implements ServerMessageEvents.AllowGameMessage {


    @Override
    public boolean allowGameMessage(MinecraftServer server, Text message, boolean overlay) {
        System.out.println("nooooooooooooooooooooooooooooooo");
        String serverName = MinecraftClient.getInstance().getCurrentServerEntry().address;

        if(!Pattern.compile(Pattern.quote("originrealms"), Pattern.CASE_INSENSITIVE).matcher(serverName).find()){
            return true;
        }

        if(Pattern.compile(Pattern.quote("spire"), Pattern.CASE_INSENSITIVE).matcher(message.getString()).find()){
            System.out.println("Blocked the message : " + message.getString());
            return false;
        }else {
            return true;
        }
    }
}
