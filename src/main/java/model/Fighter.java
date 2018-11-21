package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Fighter
{
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    public Fighter(String id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
