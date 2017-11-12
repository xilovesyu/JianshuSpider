package com.xixi.Jiansu.service;

import com.xixi.Jiansu.pojo.PersonRelation;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xijiaxiang on 2017/11/12.
 */
public class PersonRelationServiceTest {
    @Test
    public void testInsertRelation(){
        PersonRelationService service=new PersonRelationService();
        PersonRelation pr=new PersonRelation();
        pr.setPid1("test");
        pr.setPid2("test2");
        service.insertPersonReation(pr);
    }

    @Test
    public void testURL(){
        String url="http://www.jianshu.com/u/595ca7c9cfee";
        String sepator="/u/";
String sepator2="";
        int index1=url.indexOf(sepator);
        int index2=0;
        if(sepator2.equals("")){
            index2=url.length();
        }
        else{ index2=url.indexOf(sepator2);}
        String result=url.substring(index1+sepator.length(),index2);
        System.out.println(result);
    }
}