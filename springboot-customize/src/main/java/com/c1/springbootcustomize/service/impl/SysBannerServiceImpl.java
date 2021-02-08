package com.c1.springbootcustomize.service.impl;

import com.c1.springbootcustomize.dao.SysBannerDao;
import com.c1.springbootcustomize.entity.SysBanner;
import com.c1.springbootcustomize.service.SysBannerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 轮播图表(SysBanner)表服务实现类
 *
 * @author makejava
 * @since 2021-01-21 14:57:03
 */
@Service("sysBannerService")
public class SysBannerServiceImpl implements SysBannerService {
    @Resource
    private SysBannerDao sysBannerDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysBanner queryById(String id) {
        return this.sysBannerDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<SysBanner> queryAllByLimit(int offset, int limit) {
        return this.sysBannerDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysBanner 实例对象
     * @return 实例对象
     */
    @Override
    public SysBanner insert(SysBanner sysBanner) {
        this.sysBannerDao.insert(sysBanner);
        return sysBanner;
    }

    /**
     * 修改数据
     *
     * @param sysBanner 实例对象
     * @return 实例对象
     */
    @Override
    public SysBanner update(SysBanner sysBanner) {
        this.sysBannerDao.update(sysBanner);
        return this.queryById(sysBanner.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.sysBannerDao.deleteById(id) > 0;
    }

    @Override
    public List<SysBanner> getAll() {
        return sysBannerDao.getAll();
    }
}