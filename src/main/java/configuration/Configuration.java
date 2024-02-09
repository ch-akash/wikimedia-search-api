package configuration;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:config.properties"})
public interface Configuration extends Config {

    @Key("base.uri")
    String baseUri();

    @Key("auth.server.uri")
    String authServerUri();
}
