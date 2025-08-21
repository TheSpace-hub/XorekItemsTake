package hub.thespace.xorekitemstake;

import hub.thespace.xorekitemstake.config.ConfigManager;
import hub.thespace.xorekitemstake.executor.MainExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public final class XorekItemsTake extends JavaPlugin {

    private final ConfigManager configManager = new ConfigManager(this);

    @Override
    public void onEnable() {
        configManager.loadConfig();
        getServer().getPluginManager().registerEvents(new MainExecutor(this), this);
    }
}
