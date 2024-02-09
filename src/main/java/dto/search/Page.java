
package dto.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Page {


    private String description;
    private String excerpt;
    private Long id;
    private String key;
    private Thumbnail thumbnail;
    private String title;

    @JsonProperty("matched_title")
    private Object matchedTitle;
}
