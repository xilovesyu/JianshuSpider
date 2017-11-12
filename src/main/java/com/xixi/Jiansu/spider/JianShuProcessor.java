package com.xixi.Jiansu.spider;

import com.xixi.Jiansu.pojo.Person;
import com.xixi.Jiansu.service.PersonService;
import com.xixi.Jiansu.util.HrefHelper;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**主要的抓取策略
 * Created by xijiaxiang on 2017/11/11.
 */
public class JianShuProcessor implements PageProcessor {
    private ArrayList<String[] > addCookie=new ArrayList<>();

    private PersonService personService=new PersonService();

    private Site site;

    public JianShuProcessor(ArrayList<String[]> addCookie) {
        this.addCookie = addCookie;
        site=  Site.me().setRetryTimes(3).setSleepTime(1000);
        for(int i=0;i<this.addCookie.size();i++){
            site=site.addCookie(this.addCookie.get(i)[0],this.addCookie.get(i)[1]);
        }
    }

    public void process(Page page) {
       // String looked=page.getHtml().xpath("/main-top/info/meta-block").toString();
        Html html=page.getHtml();
        if(page.getUrl().toString().contains("following")){
            System.out.println("某个人关注的页面");
            List<String> lookedPersonURL=html.css(".user-list li .info").links().all();
            for (String personURL:lookedPersonURL
                 ) {
                //System.out.println(personURL);
                page.addTargetRequest(personURL);
            }
            System.out.println("----");
        }else{
            System.out.println("某个人首页");
            Person person =new Person();
            //获取id，姓名
            String idAndName=html.css(".main-top .title a").all().get(0);
            String name= HrefHelper.Content(idAndName);
            String id=HrefHelper.URL(idAndName).substring(3);
            List<String> fla=html.css(".main-top .info .meta-block a p").all();
            String follow=fla.get(0).replaceAll("<p>|</p>","");
            String like=fla.get(1).replaceAll("<p>|</p>","");
            String article=fla.get(2).replaceAll("<p>|</p>","");

            person.setId(id);
            person.setName(name);
            person.setFollowed(Integer.parseInt(follow));
            person.setLiked(Integer.parseInt(like));
            person.setArticleCount(Integer.parseInt(article));


            System.out.println(person);
            personService.insertPerson(person);
            List<String> list=page.getHtml().css(".main-top .info .meta-block").links().all();
            if(list.size()!=0) {
                //System.out.println(list.get(0));
                page.addTargetRequest(list.get(0));
            }
        }

    }

    public Site getSite() {
        return site;
    }
}
