package com.c1.springbootcustomize.controller;

import com.c1.springbootcustomize.entity.SysBanner;
import com.c1.springbootcustomize.service.SysBannerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 轮播图表(SysBanner)表控制层
 *
 * @author makejava
 * @since 2021-01-21 14:57:03
 */
@RestController
@RequestMapping("sysBanner")
public class SysBannerController {
    /**
     * 服务对象
     */
    @Resource
    private SysBannerService sysBannerService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SysBanner selectOne(String id) {
        return this.sysBannerService.queryById(id);
    }
    @GetMapping("getAll")
    public List<SysBanner> getAll() {
        List<SysBanner> all = this.sysBannerService.getAll();
        return all;
    }
}