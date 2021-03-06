package gro.perso.jk_objectifforme.JsonTrainingParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "entrainement", "items" })
public class Entrainement {

	@JsonProperty("entrainement")
	private String entrainement;
	@JsonProperty("items")
	private List<Item> items = new ArrayList<Item>();
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("entrainement")
	public String getEntrainement() {
		return entrainement;
	}

	@JsonProperty("entrainement")
	public void setEntrainement(String entrainement) {
		this.entrainement = entrainement;
	}

	@JsonProperty("items")
	public List<Item> getItems() {
		return items;
	}

	@JsonProperty("items")
	public void setItems(List<Item> items) {
		this.items = items;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
