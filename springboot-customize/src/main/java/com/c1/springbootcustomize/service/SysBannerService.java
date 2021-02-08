package com.c1.springbootcustomize.service;

import com.c1.springbootcustomize.entity.SysBanner;

import java.util.List;

/**
 * 轮播图表(SysBanner)表服务接口
 *
 * @author makejava
 * @since 2021-01-21 14:57:02
 */
public interface SysBannerService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysBanner queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SysBanner> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sysBanner 实例对象
     * @return 实例对象
     */
    SysBanner insert(SysBanner sysBanner);

    /**
     * 修改数据
     *
     * @param sysBanner 实例对象
     * @return 实例对象
     */
    SysBanner update(SysBanner sysBanner);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

    List<SysBanner> getAll();
}