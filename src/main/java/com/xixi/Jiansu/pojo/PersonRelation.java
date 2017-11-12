package com.xixi.Jiansu.pojo;

/**
 * Created by xijiaxiang on 2017/11/12.
 */
public class PersonRelation {
    private long id;
    private String pid1;
    private String pid2;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPid1() {
        return pid1;
    }

    public void setPid1(String pid1) {
        this.pid1 = pid1;
    }

    public String getPid2() {
        return pid2;
    }

    public void setPid2(String pid2) {
        this.pid2 = pid2;
    }

    @Override
    public String toString() {
        return "PersonRelation{" +
                "id=" + id +
                ", pid1='" + pid1 + '\'' +
                ", pid2='" + pid2 + '\'' +
                '}';
    }
}
