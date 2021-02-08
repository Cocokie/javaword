package com.c1.springbootcustomize.dao;

import com.c1.springbootcustomize.entity.SysBanner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 轮播图表(SysBanner)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-21 14:57:02
 */
public interface SysBannerDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysBanner queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SysBanner> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysBanner 实例对象
     * @return 对象列表
     */
    List<SysBanner> queryAll(SysBanner sysBanner);
    List<SysBanner> getAll();

    /**
     * 新增数据
     *
     * @param sysBanner 实例对象
     * @return 影响行数
     */
    int insert(SysBanner sysBanner);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysBanner> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SysBanner> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysBanner> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<SysBanner> entities);

    /**
     * 修改数据
     *
     * @param sysBanner 实例对象
     * @return 影响行数
     */
    int update(SysBanner sysBanner);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}