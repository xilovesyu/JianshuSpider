package com.xixi.Jiansu.spider;

import com.xixi.Jiansu.pojo.Person;
import com.xixi.Jiansu.pojo.PersonRelation;
import com.xixi.Jiansu.service.PersonRelationService;
import com.xixi.Jiansu.service.PersonService;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * 构建结果记录的类，从爬取模块抽离
 * Created by xijiaxiang on 2017/11/12.
 */
public class JiansuPipeline implements Pipeline{

    private PersonService personService=new PersonService();

    private PersonRelationService personRelationService=new PersonRelationService();


    @Override
    public void process(ResultItems resultItems, Task task) {
        //ResultItems保存了抽取结果，它是一个Map结构，
        // 在page.putField(key,value)中保存的数据，可以通过ResultItems.get(key)获取
        PersonRelation personRelation=resultItems.get("personRelation");
        System.out.println(personRelation);
        if(personRelation!=null) {
            personRelationService.insertPersonReation(personRelation);
        }
        Person person= resultItems.get("person");
        System.out.println(person);
        if(person!=null) {
            personService.insertPerson(person);
        }
    }
}
