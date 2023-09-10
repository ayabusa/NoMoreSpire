package dev.ayabusa.nomorespire.event;

import com.mojang.authlib.GameProfile;
import net.fabricmc.fabric.api.client.message.v1.ClientReceiveMessageEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.message.MessageType;
import net.minecraft.network.message.SignedMessage;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

import java.time.Instant;
import java.util.regex.Pattern;

public class ChatMessageHandler implements ClientReceiveMessageEvents.AllowGame {

    @Override
    public boolean allowReceiveGameMessage(Text message, boolean overlay) {
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
