package com.nm.cascade.web.category.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Entry implements Serializable {

	public static final long serialVersionUID = 1L;

	@JsonProperty(value = "API", required = true)
	private String api;

	@JsonProperty(value = "Description", required = true)
	private String description;

	@JsonProperty(value = "Auth", required = true)
	private String auth;

	@JsonProperty(value = "HTTPS", required = true)
	private String https;

	@JsonProperty(value = "Link", required = true)
	private String link;

	@JsonProperty(value = "Cors", required = true)
	private String cors;

	@JsonProperty(value = "Category", required = true)
	private String category;




}
