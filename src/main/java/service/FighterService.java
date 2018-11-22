package service;

import model.Fighter;
import org.aspectj.lang.annotation.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Service;
import repository.FighterRepository;

import java.util.List;

@Service
public class FighterService
{
    ClassPathXmlApplicationContext ctx;

    FighterRepository fighterRepository;


    @BeforeClass
    public void setUp() throws Exception
    {
        ctx = new ClassPathXmlApplicationContext();
    }

    public List<Fighter> getFighters()
    {
        return (List<Fighter>) fighterRepository.findAll();
    }

    public void createFighter(Fighter fighter)
    {
        fighterRepository.save(fighter);
    }

    public Fighter getFighterByName(String name)
    {
        for (Fighter fighter: getFighters())
        {
            if(fighter.getName().equals(name))
            {
                return  fighter;
            }

        }

        return null;
    }


}
