package by.pvt.hermanovich.airline.managers;

import by.pvt.hermanovich.airline.constants.ConfigConstant;

import java.util.ResourceBundle;

/**
 * Description: This class works with message config-property file.
 * Created by Yauheni Hermanovich on 14.07.2017.
 */
public class ConfigManagerMessages {
    private volatile static ConfigManagerMessages instance;
    public static final ResourceBundle resourceBundle = ResourceBundle.getBundle(ConfigConstant.MESSAGES_PROPERTIES_SOURCE);

    public ConfigManagerMessages() {
    }

    /**
     * Singleton realization with "Double Checked Locking & Volatile" principle for high performance and thread safety.
     *
     * @return      - an instance of the class.
     */
    public static ConfigManagerMessages getInstance() {
        if (instance == null) {
            synchronized (ConfigManagerMessages.class) {
                if (instance == null) {
                    instance = new ConfigManagerMessages();
                }
            }
        }
        return instance;
    }

    /**
     * This method returns path page from messages.properties managers files.
     *
     * @param key   - an incoming key to define a property.
     * @return      - outcoming message.
     */
    public String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
