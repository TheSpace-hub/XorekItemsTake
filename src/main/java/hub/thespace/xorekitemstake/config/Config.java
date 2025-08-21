package hub.thespace.xorekitemstake.config;

import org.bukkit.ChatColor;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Получение данных из конфига.
 */
public class Config {
    private final ConfigManager configManager;

    public Config(ConfigManager configManager) {
        this.configManager = configManager;
    }

    /**
     * Получения префикса.
     *
     * @return Префикс для сообщения.
     */
    public String getPrefix() {
        return configManager.getString("prefix", "");
    }

    /**
     * Получение основного сообщения.
     *
     * @return Основное сообщение.
     */
    public String getMessage() {
        return configManager.getString("message", "");
    }

    /**
     * Получения сообщения в босс-баре.
     *
     * @return Сообщения для босс-бара.
     */
    public String getBossBar() {
        return configManager.getString("bossbar", "");
    }

    /**
     * Получение поля mode.creative.
     *
     * @return Поле mode.creative.
     */
    public String getCreativePlaceholder() {
        return configManager.getString("mode.creative", "");
    }

    /**
     * Получение поля mode.flight.
     *
     * @return Поле mode.flight.
     */
    public String getFlightPlaceholder() {
        return configManager.getString("mode.flight", "");
    }

    /**
     * Получение поля mode.god.
     *
     * @return Поле mode.god.
     */
    public String getGodPlaceholder() {
        return configManager.getString("mode.god", "");
    }

    /**
     * Получение поля mode.vanish.
     *
     * @return Поле mode.vanish.
     */
    public String getVanishPlaceholder() {
        return configManager.getString("mode.vanish", "");
    }

    /**
     * Преобразование сообщения, содержащее hex.
     *
     * @param message Исходное сообщение.
     * @return Отформатированное сообщение.
     */
    @NotNull
    public static String hex(String message) {
        Pattern pattern = Pattern.compile("#([a-fA-F0-9]{6})");
        Matcher matcher = pattern.matcher(message);
        StringBuffer result = new StringBuffer();

        while (matcher.find()) {
            String hexCode = matcher.group(1); // RRGGBB без #
            String minecraftHex = "§x§" + String.join("§", hexCode.split(""));
            matcher.appendReplacement(result, minecraftHex);
        }

        matcher.appendTail(result);
        return result.toString().replace("&", "");
    }

}
