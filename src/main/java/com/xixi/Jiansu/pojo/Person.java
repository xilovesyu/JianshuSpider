package com.xixi.Jiansu.pojo;

/**
 * 简书人物模型
 * Created by xijiaxiang on 2017/11/11.
 */
public class Person {
    private String id;
    private String name;
    private int followed;
    private int liked;
    private int articleCount=0;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFollowed() {
        return followed;
    }

    public void setFollowed(int followed) {
        this.followed = followed;
    }

    public int getLiked() {
        return liked;
    }

    public void setLiked(int liked) {
        this.liked = liked;
    }

    public int getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(int articleCount) {
        this.articleCount = articleCount;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", followed=" + followed +
                ", liked=" + liked +
                ", articleCount=" + articleCount +
                '}';
    }
}
