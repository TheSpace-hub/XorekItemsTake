/**
 * Обрабатывает событие поднятие предмета игроком и решает, что стоит предпринять.
 */
package hub.thespace.xorekitemstake.executor;

import hub.thespace.xorekitemstake.RejectionMode;
import hub.thespace.xorekitemstake.config.Config;
import hub.thespace.xorekitemstake.config.ConfigManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class MainExecutor implements Listener {

    private final Plugin plugin;
    private final Config config;

    public MainExecutor(Plugin plugin) {
        this.plugin = plugin;
        config = new Config(new ConfigManager(plugin));
    }

    /**
     * Срабатывает при поднятии предмета.
     * Проверяет что поднял игрок и у него нет прав для обхода.
     *
     * @param event -
     */
    @EventHandler
    public void onEntityPickupItem(@NotNull EntityPickupItemEvent event) {
        if (!(event.getEntity() instanceof Player player) || player.hasPermission("xorekItemsTake.bypass"))
            return;

        if (canPickup(player)) {
            sendRejectionMessage(player);
            event.setCancelled(true);
        }
    }

    /**
     * Решает, может ли игрок поднять предмет.
     *
     * @param player Игрок, поднявший предмет.
     * @return Может ли игрок поднять предмет.
     */
    private boolean canPickup(@NotNull Player player) {
        RejectionMode mode = RejectionMode.fromPlayer(player);
        return mode != null;
    }

    /**
     * Отправляет сообщение игроку, если тот не может поднять предмет.
     *
     * @param player Игрок, который не может поднять предмет.
     */
    private void sendRejectionMessage(Player player) {
        RejectionMode mode = RejectionMode.fromPlayer(player);
        assert mode != null;

        String placeholder = switch (mode) {
            case CREATIVE -> config.getCreativePlaceholder();
            case FLIGHT -> config.getFlightPlaceholder();
            case GOD -> config.getGodPlaceholder();
            case VANISH -> config.getVanishPlaceholder();
        };

        player.sendMessage(Config.hex(config.getMessage()
                .replace("{prefix}", config.getPrefix())
                .replace("{mode}", placeholder)
        ));
    }
}
