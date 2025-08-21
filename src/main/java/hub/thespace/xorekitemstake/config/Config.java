package hub.thespace.xorekitemstake.config;

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

}
