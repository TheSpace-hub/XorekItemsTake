package hub.thespace.xorekitemstake;

import hub.thespace.xorekitemstake.executor.MainExecutor;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class XorekItemsTake extends JavaPlugin {

    private final MainExecutor mainExecutor = new MainExecutor(this);

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(mainExecutor, this);
        Bukkit.getScheduler().runTaskTimer(this, mainExecutor, 10L, 10L);
    }
}
