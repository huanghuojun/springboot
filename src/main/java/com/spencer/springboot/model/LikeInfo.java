package com.spencer.springboot.model;

/**
 * @Author Spencer
 * @Date 2018/12/20 17:12
 * @Description
 */
public class LikeInfo {

    /**
     * fav_nums : 1
     * id : 1
     * like_status : 1
     */

    private int favNums;
    private int id;
    private int likeStatus;

    public int getFavNums() {
        return favNums;
    }

    public void setFavNums(int favNums) {
        this.favNums = favNums;
    }

    public int getLikeStatus() {
        return likeStatus;
    }

    public void setLikeStatus(int likeStatus) {
        this.likeStatus = likeStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
