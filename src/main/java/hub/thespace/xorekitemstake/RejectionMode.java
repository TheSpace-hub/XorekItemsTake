package hub.thespace.xorekitemstake;

import com.earth2me.essentials.User;
import net.ess3.api.IEssentials;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Режим игрока, запрещающий брать ему предметы.
 */
public enum RejectionMode {
    CREATIVE,
    FLIGHT,
    GOD,
    VANISH;

    /**
     * Получить режим, если игроку нельзя поднимать предмет. Иначе получить null.
     *
     * @return Режим, запрещающий игроку брать предмет или null.
     */
    @Nullable
    public static RejectionMode fromPlayer(@NotNull IEssentials essentials, @NotNull Player player) {
        User user = essentials.getUser(player);
        if (player.getGameMode() == GameMode.CREATIVE)
            return RejectionMode.CREATIVE;
        else if (player.isFlying())
            return RejectionMode.FLIGHT;
        else if (user.isGodModeEnabled())
            return RejectionMode.GOD;
        else if (user.isVanished())
            return RejectionMode.VANISH;
        return null;
    }

}
