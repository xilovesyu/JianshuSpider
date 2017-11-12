package com.xixi.Jiansu.spider;

import com.xixi.Jiansu.pojo.Person;
import com.xixi.Jiansu.pojo.PersonRelation;
import com.xixi.Jiansu.util.HrefHelper;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.util.ArrayList;
import java.util.List;

/**主要的抓取策略
 * Created by xijiaxiang on 2017/11/11.
 */
public class JianShuProcessor implements PageProcessor {
    private ArrayList<String[] > addCookie=new ArrayList<>();
    private Site site;

    public JianShuProcessor(ArrayList<String[]> addCookie) {
        this.addCookie = addCookie;
        site=  Site.me().setRetryTimes(3).setSleepTime(1000);
        for(int i=0;i<this.addCookie.size();i++){
            site=site.addCookie(this.addCookie.get(i)[0],this.addCookie.get(i)[1]);
        }
    }

    private String getUserIdFromURL(String url,String sepator,String sepator2){
        int index1=url.indexOf(sepator);
        int index2=0;
        if(sepator2.equals("")){
             index2=url.length();
        }
        else{ index2=url.indexOf(sepator2);}
        return url.substring(index1+sepator.length(),index2);
    }
    public void process(Page page) {
        Html html=page.getHtml();
        if(page.getUrl().toString().contains("following")){
            System.out.println("某个人关注的页面");

            String currentUserId=getUserIdFromURL(page.getUrl().toString(),"users/","/following");
            String beFollowedUserId="";

            List<String> lookedPersonURL=html.css(".user-list li .info").links().all();
            for (String personURL:lookedPersonURL) {
                beFollowedUserId=getUserIdFromURL(personURL,"/u/","");
                page.addTargetRequest(personURL);
            }
            PersonRelation personRelation=new PersonRelation();
            personRelation.setPid1(currentUserId);
            personRelation.setPid2(beFollowedUserId);

            page.putField("personRelation",personRelation);

        }else{
            System.out.println("某个人首页");
            Person person =new Person();
            //获取id，姓名
            String idAndName=html.css(".main-top .title a").all().get(0);


            String name= HrefHelper.Content(idAndName);
            String id=HrefHelper.URL(idAndName).substring(3);

            List<String> fla=html.css(".main-top .info .meta-block  p").all();


            String follow=fla.get(0).replaceAll("<p>|</p>","");
            String like=fla.get(1).replaceAll("<p>|</p>","");
            String article=fla.get(2).replaceAll("<p>|</p>","");
            String characterCount=fla.get(3).replaceAll("<p>|</p>","");
            String HowManyLikes=fla.get(4).replaceAll("<p>|</p>","");
            //String selfIntroduction="";
            // List<String> selfIntroductions=html.css(".description .js-intro").all();
            //if(selfIntroductions.size()!=0){
            //    selfIntroduction=selfIntroductions.get(0).replaceAll("<div class=\"js-intro\">|</div>","").replaceAll("<br>"," ");
            //}

            person.setId(id);

            person.setName(name);
            person.setFollowed(Integer.parseInt(follow));
            person.setLiked(Integer.parseInt(like));
            person.setArticleCount(Integer.parseInt(article));
            person.setCharacterCount(Integer.parseInt(characterCount));
            person.setHowManyLikes(Long.parseLong(HowManyLikes));
           //person.setSelfIntroduction(selfIntroduction);

            page.putField("person",person);


            List<String> list=page.getHtml().css(".main-top .info .meta-block").links().all();
            if(list.size()!=0) {
                //访问他的关注
                page.addTargetRequest(list.get(0));
            }
        }

    }

    public Site getSite() {
        return site;
    }
}
