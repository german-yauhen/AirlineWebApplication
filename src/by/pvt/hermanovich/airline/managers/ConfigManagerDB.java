package by.pvt.hermanovich.airline.managers;

import by.pvt.hermanovich.airline.constants.ConfigConstant;
import java.util.ResourceBundle;

/**
 * Description: This class works with database config-property file.
 *
 * Created by Yauheni Hermanovich on 11.07.2017.
 */
public class ConfigManagerDB {
    public volatile static ConfigManagerDB instance;
    private final ResourceBundle dbProp = ResourceBundle.getBundle(ConfigConstant.DATABASE_PROPERTIES_SOURCE);

    public ConfigManagerDB() {
    }

    /**
     * Singleton realization with "Double Checked Locking & Volatile" principle for high performance and thread safety.
     *
     * @return - an instance of the class.
     */
    public static ConfigManagerDB getInstance() {
        if (instance == null) {
            synchronized (ConfigManagerDB.class) {
                if (instance == null) {
                    instance = new ConfigManagerDB();
                }
            }
        }
        return instance;
    }

    /**
     * This method provides getting a property from property file according to the incoming value.
     *
     * @param key   - incoming value of the key for getting a property.
     * @return      - a property value.
     */
    public String getProperty(String key) {
        return dbProp.getString(key);
    }

}
