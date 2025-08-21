package hub.thespace.xorekitemstake;

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
    public static RejectionMode fromPlayer(@NotNull Player player) {
        if (player.getGameMode() == GameMode.CREATIVE)
            return RejectionMode.CREATIVE;
        else if (player.isFlying())
            return RejectionMode.FLIGHT;
        return null;
    }

    /**
     * Возвращает запрещающее сообщение.
     *
     * @param mode Запрещающий режим игры.
     * @return Сообщение, преобразованное с поддержкой hex.
     */
    @NotNull
    public static String getRejectionMessage(@NotNull RejectionMode mode) {
        return "";
    }

}
