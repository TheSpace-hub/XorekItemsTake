package hub.thespace.xorekitemstake;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class MainExecutor implements Listener {

    private final Plugin plugin;

    public MainExecutor(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityPickupItem(@NotNull EntityPickupItemEvent event) {
        if (!(event.getEntity() instanceof Player player) || player.hasPermission("xorekItemsTake.bypass"))
            return;

        GameMode gameMode = player.getGameMode();
        player.sendMessage(gameMode.name());
    }

}
