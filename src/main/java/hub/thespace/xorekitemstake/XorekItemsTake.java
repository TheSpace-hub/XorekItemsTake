package hub.thespace.xorekitemstake;

import hub.thespace.xorekitemstake.executor.MainExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public final class XorekItemsTake extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new MainExecutor(this), this);
    }
}
