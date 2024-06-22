package io.github.wkktoria.jokez.api;

import com.fasterxml.jackson.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "type",
        "setup",
        "punchline",
        "id"
})
public class JokeApiResponse {
    @JsonProperty("type")
    private String type;
    @JsonProperty("setup")
    private String setup;
    @JsonProperty("punchline")
    private String punchline;
    @JsonProperty("id")
    private Integer id;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("setup")
    public String getSetup() {
        return setup;
    }

    @JsonProperty("setup")
    public void setSetup(String setup) {
        this.setup = setup;
    }

    @JsonProperty("punchline")
    public String getPunchline() {
        return punchline;
    }

    @JsonProperty("punchline")
    public void setPunchline(String punchline) {
        this.punchline = punchline;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
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
