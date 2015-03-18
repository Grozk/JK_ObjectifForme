package gro.perso.jk_objectifforme.JsonTrainingParser;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "type", "intitule", "nombre", "unite", "enchainementnum" })
public class Item {

	@JsonProperty("type")
	private String type;
	@JsonProperty("intitule")
	private String intitule;
	@JsonProperty("nombre")
	private String nombre;
	@JsonProperty("unite")
	private String unite;
	@JsonProperty("enchainementnum")
	private String enchainementnum;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}

	@JsonProperty("intitule")
	public String getIntitule() {
		return intitule;
	}

	@JsonProperty("intitule")
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	@JsonProperty("nombre")
	public String getNombre() {
		return nombre;
	}

	@JsonProperty("nombre")
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@JsonProperty("unite")
	public String getUnite() {
		return unite;
	}

	@JsonProperty("unite")
	public void setUnite(String unite) {
		this.unite = unite;
	}

	@JsonProperty("enchainementnum")
	public String getEnchainementnum() {
		return enchainementnum;
	}

	@JsonProperty("enchainementnum")
	public void setEnchainementnum(String enchainementnum) {
		this.enchainementnum = enchainementnum;
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
