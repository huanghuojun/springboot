package com.spencer.springboot.model.response;

/**
 * @Author Spencer
 * @Date 2019/1/7 17:23
 * @Description
 */
public class FavorResp {
    private int favNums;
    private long id;
    private int likeStatus;

    public int getFavNums() {
        return favNums;
    }

    public void setFavNums(int favNums) {
        this.favNums = favNums;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getLikeStatus() {
        return likeStatus;
    }

    public void setLikeStatus(int likeStatus) {
        this.likeStatus = likeStatus;
    }
}
