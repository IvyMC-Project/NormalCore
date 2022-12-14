package io.github.ivymc.normalcore.config.punish;

import com.google.gson.JsonObject;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

public class TempBan extends MessageUpdating {
    @Override
    public void accept(JsonObject json) throws Exception {
        super.accept(json);
    }

    @Override
    public void review(ServerPlayerEntity player) {

    }

    @Override
    public void onDeath(ServerPlayerEntity player) {
        super.onDeath(player);
        player.networkHandler.disconnect(Text.Serializer.fromLenientJson(death_message.ctx.replaceAll("%time%", getUseTime(player))));
    }

    public void join(ServerPlayerEntity player) {
        player.networkHandler.disconnect(Text.of(update_message.ctx.replaceAll("%time%",  getUseTime(player))));
    }
}
