package net.swade;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerChatEvent;
import cn.nukkit.utils.Config;

public class EventListener implements Listener {

    @SuppressWarnings("unused")
    @EventHandler(priority = EventPriority.NORMAL)
    public void playerChat(PlayerChatEvent event) {
        if (event.isCancelled()) return;
        Config config = new Config(Main.getInstance().getDataFolder().getPath() + "/config.yml", Config.YAML);
        String message = event.getMessage();
        if (!message.startsWith(config.getString("prefix"))) return;
        Player player = event.getPlayer();
        if (!player.hasPermission(config.getString("permission"))) return;
        event.setCancelled(true);
        String format = config.getString("format");
        format = format.replace("%player%", player.getName());
        message = message.substring(config.getString("prefix").length());
        format = format.replace("%message%", message);
        for (Player value : Server.getInstance().getOnlinePlayers().values()) {
            if (value.hasPermission(config.getString("permission"))) {
                value.sendMessage(format);
            }
        }
    }
}
