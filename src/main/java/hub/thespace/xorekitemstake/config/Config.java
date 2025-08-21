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

    /**
     * Получение основного сообщения.
     *
     * @return Основное сообщение.
     */
    public String getMessages() {
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

}
