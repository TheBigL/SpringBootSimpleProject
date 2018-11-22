package model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FighterTest
{
    Fighter fighter;
    @Before
    public void setup()
    {
        fighter = new Fighter("01", "Mario");
    }

    @Test
    public void fighterMixin() throws JsonProcessingException
    {
        ObjectMapper objectMapper = buildMapper();
        objectMapper.addMixIn(Fighter.class, FighterMixin.class);
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(fighter);
        Assert.assertTrue (json.contains("Mario"));


    }



    private static ObjectMapper buildMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(objectMapper.getSerializationConfig()
                .getDefaultVisibilityChecker()
                .withFieldVisibility(JsonAutoDetect.Visibility.ANY)
                .withGetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withSetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withCreatorVisibility(JsonAutoDetect.Visibility.NONE));
        return objectMapper;
    }



}