
package dto.search;

import lombok.Data;

import java.util.List;

@Data
public class SearchContentResponse {

    private List<Page> pages;
}
