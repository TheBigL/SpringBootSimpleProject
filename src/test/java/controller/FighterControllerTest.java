package controller;

import model.Fighter;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.PathVariable;
import repository.FighterRepository;
import service.FighterService;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FighterController.class)
public class FighterControllerTest {

    @MockBean
    FighterService fighterService;
    Fighter mario, dk, link;
    @Before
    public void setUp() throws Exception
    {
        fighterService = new FighterService();
        mario = new Fighter("01", "Mario");
        dk = new Fighter("02", "Donkey Kong");
        link = new Fighter("03", "Link");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addFighter()
    {
        fighterService.createFighter(mario);
    }

    @Test
    public void getFighters() {
    }

    @Test
    public void create()
    {

    }

    @Test
    public void testFighterSizeNumber()
    {

        Fighter samus = new Fighter("04", "Samus");
        fighterService.createFighter(samus);

        Assert.assertEquals(4, fighterService.getFighters().size());

    }

    @Test
    public void getFighter() {
    }

    @Test
    public void getFighterTest() throws Exception
    {
        String jsonFighter = mario.toString();

        org.springframework.util.Assert.isTrue(jsonFighter.contains(mario.getName()), "Name doesn't match!");

    }
}