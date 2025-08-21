package hub.thespace.xorekitemstake.config;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

/**
 * Безопасное получение данных из config.yml.
 */
public class ConfigManager {
    private final Plugin plugin;
    private FileConfiguration config;

    public ConfigManager(Plugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Загрузка config.yml.
     */
    public void loadConfig() {
        plugin.saveDefaultConfig();
        plugin.reloadConfig();
        config = plugin.getConfig();
    }

    public String getString(String path, String defaultValue) {
        try {
            String value = config.getString(path);
            if (value == null || value.trim().isEmpty()) {
                plugin.getLogger().warning("Значение для пути '" + path + "' не найдено или пустое. Используется значение по умолчанию: " + defaultValue);
                return defaultValue;
            }
            return ChatColor.translateAlternateColorCodes('&', value);
        } catch (Exception e) {
            plugin.getLogger().warning("Ошибка при чтении строки из конфига по пути: " + path);
            return defaultValue;
        }
    }

}
