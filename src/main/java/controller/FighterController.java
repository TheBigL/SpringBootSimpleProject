package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.util.JSONPObject;
import model.Fighter;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import service.FighterService;

import java.util.List;

import static org.springframework.http.MediaType.*;

@RestController
public class FighterController
{

    FighterService fighterService;

    @RequestMapping( value = "/fighters", method = RequestMethod.GET)
    public String getFighters()
    {
        fighterService.getFighters();
        return "index";

    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Fighter> createFighter(@RequestBody Fighter fighter)
    {
        fighterService.createFighter(fighter);
        return fighterService.getFighters();


    }

    @RequestMapping("/fighters/{name}")
    public String fighterDetails(@PathVariable String name) throws JsonProcessingException {
        try
        {
            Fighter selectedFighter = fighterService.getFighterByName(name);

            String jsonFighter = selectedFighter.toString();

            return jsonFighter;
        } catch (Exception e)
        {
            e.getMessage();

        }

        return null;


    };


}
