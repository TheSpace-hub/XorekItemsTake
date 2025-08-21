package hub.thespace.xorekitemstake;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Режим игрока, запрещающий брать ему предметы.
 */
public enum Mode {
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
    public static Mode fromPlayer(@NotNull Player player) {
        if (player.getGameMode() == GameMode.CREATIVE)
            return Mode.CREATIVE;
        else if (player.isFlying())
            return Mode.FLIGHT;
        return null;
    }
}
