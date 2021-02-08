package com.c1.springbootcustomize.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 轮播图表(SysBanner)实体类
 *
 * @author makejava
 * @since 2021-01-21 14:57:02
 */
public class SysBanner implements Serializable {
    private static final long serialVersionUID = 807655155362195194L;
    /**
     * ID
     */
    private String id;
    /**
     * 图片地址，非空
     */
    private String picture;
    /**
     * 跳转链接
     */
    private String link;
    /**
     * 归属页面，0：首页 1：专题 默认0
     */
    private String position;
    /**
     * 归属专题，归属页面为专题时填写
     */
    private String topicId;
    /**
     * 发布时间
     */
    private String publishTime;
    /**
     * 状态，0：停用 1：启用
     */
    private String status;
    /**
     * 创建人
     */
    private String creatorId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改人
     */
    private String modifyUserId;
    /**
     * 修改时间
     */
    private Date modifyTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(String modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

}