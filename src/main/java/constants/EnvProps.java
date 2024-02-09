package constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EnvProps {

    CLIENT_ID("client_id", "WIKI_CLIENT_ID"),
    CLIENT_SECRET("client_secret", "WIKI_CLIENT_SECRET");

    private final String apiFormKey;
    private final String envKey;
}
