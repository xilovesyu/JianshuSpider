package com.xixi.Jiansu;

import com.xixi.Jiansu.spider.JianShuProcessor;
import us.codecraft.webmagic.Spider;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //String cookie="remember_user_token=W1s4MDA3Nzk5XSwiJDJhJDExJGQ0bEE4SDdIdWRzejB3OXQuZDRFOU8iLCIxNTEwMzg4MTE3LjAyMDQyOTYiXQ%3D%3D--3745ca7341d2bfd65f25f8877e361ec0679806eb; _ga=GA1.2.542881680.1483497256; _gid=GA1.2.1927760544.1510126112; Hm_lvt_0c0e9d9b1e7d617b3e6842e85b9fb068=1510284518,1510291737,1510301010,1510365688; Hm_lpvt_0c0e9d9b1e7d617b3e6842e85b9fb068=1510388196; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%228007799%22%2C%22%24device_id%22%3A%2215f3ee33dc8d-001388bfe4ee8-3b3e5906-1049088-15f3ee33dc93dd%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_referrer%22%3A%22%22%2C%22%24latest_referrer_host%22%3A%22%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%7D%2C%22first_id%22%3A%2215f3ee33dc8d-001388bfe4ee8-3b3e5906-1049088-15f3ee33dc93dd%22%7D; _m7e_session=88ef2e858ae0410e4537910ca51be371";
        ArrayList<String[]> cookies=new ArrayList<>();
        cookies.add(new String[]{"remember_user_token","W1s4MDA3Nzk5XSwiJDJhJDExJGQ0bEE4SDdIdWRzejB3OXQuZDRFOU8iLCIxNTEwMzg4MTE3LjAyMDQyOTYiXQ%3D%3D--3745ca7341d2bfd65f25f8877e361ec0679806eb"});
        cookies.add(new String[]{"_ga","GA1.2.542881680.1483497256"});
        cookies.add(new String[]{"_gid","GA1.2.1927760544.1510126112"});
        cookies.add(new String[]{"Hm_lvt_0c0e9d9b1e7d617b3e6842e85b9fb068","1510284518,1510291737,1510301010,1510365688"});
        cookies.add(new String[]{"Hm_lpvt_0c0e9d9b1e7d617b3e6842e85b9fb068","1510388196"});
        cookies.add(new String[]{"sensorsdata2015jssdkcross","%7B%22distinct_id%22%3A%228007799%22%2C%22%24device_id%22%3A%2215f3ee33dc8d-001388bfe4ee8-3b3e5906-1049088-15f3ee33dc93dd%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_referrer%22%3A%22%22%2C%22%24latest_referrer_host%22%3A%22%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%7D%2C%22first_id%22%3A%2215f3ee33dc8d-001388bfe4ee8-3b3e5906-1049088-15f3ee33dc93dd%22%7D"});
        cookies.add(new String[]{"_m7e_session","88ef2e858ae0410e4537910ca51be371"});

        String seedUser="http://www.jianshu.com/u/2b3ad4f2a058";
        Spider.create(new JianShuProcessor(cookies)).addUrl(seedUser).thread(1).run();
    }
}
