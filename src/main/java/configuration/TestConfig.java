package configuration;

import org.aeonbits.owner.ConfigCache;

public class TestConfig {
    public static synchronized Configuration getConfig() {
        return ConfigCache.getOrCreate(Configuration.class);
    }
}
