package dto.page;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GetPageResponse{

	private License license;
	private int id;
	private String title;
	private String key;
	private Latest latest;

	@JsonProperty("content_model")
	private String contentModel;

	@JsonProperty("html_url")
	private String htmlUrl;
}