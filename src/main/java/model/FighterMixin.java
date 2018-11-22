package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class FighterMixin
{
    @JsonCreator
    public  FighterMixin(@JsonProperty String id, @JsonProperty String name)
    {

    }
}
