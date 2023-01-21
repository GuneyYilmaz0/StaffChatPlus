package net.swade;

import cn.nukkit.plugin.PluginBase;
import lombok.Getter;
import lombok.Setter;

public class Main extends PluginBase {

    @Getter
    @Setter
    private static Main instance;
    @Override
    public void onLoad() {
        setInstance(this);
    }

    @Override
    public void onEnable() {
        saveResource("config.yml");
        getServer().getPluginManager().registerEvents(new EventListener(), this);
        getLogger().info("§aSuccessfully loaded.\n§cAuthor: §bGuneyYilmaz0\n§cDiscord: §bGüney#0001");
    }
}