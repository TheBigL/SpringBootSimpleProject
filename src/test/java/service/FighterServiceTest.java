package service;

import model.Fighter;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import repository.FighterRepository;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/ApplicationContext.xml" })
public class FighterServiceTest {

    @Autowired
    FighterRepository fighterRepository;
    Fighter mario;

    @Before
    public void setUp() throws Exception
    {
        mario = new Fighter("01", "Mario");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getFighters() {
    }

    @Test
    public void createFighter()
    {
        fighterRepository.save(mario);
        Assert.assertEquals(1, fighterRepository.count());
    }

    @Test
    public void getFighterByName() {
    }
}