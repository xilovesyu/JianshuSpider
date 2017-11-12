package com.xixi.Jiansu.service;

import com.xixi.Jiansu.pojo.Person;
import org.junit.Test;

import static org.junit.Assert.*;

/**测试person service
 * Created by xijiaxiang on 2017/11/12.
 */
public class PersonServiceTest {
    @Test
    public void testInsert(){
        Person person=new Person();
        person.setId("test2");
        person.setName("xijiaxiang2");
        person.setFollowed(2);
        person.setLiked(2);
        person.setArticleCount(2);

        PersonService personService=new PersonService();
        personService.insertPerson(person);
    }
}