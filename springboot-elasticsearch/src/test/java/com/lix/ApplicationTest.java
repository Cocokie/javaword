package com.lix;


import com.lix.domain.Item;

import com.lix.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ApplicationTest {
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    ElasticsearchTemplate esTemplate;
    @Test
    public void createIndex() {
//        // 创建索引，会根据Item类的@Document注解信息来创建
//        esTemplate.createIndex(Item.class);
//        // 配置映射，会根据Item类中的id、Field等字段来自动完成映射
//        esTemplate.putMapping(Item.class);

        //新增一个
       /* Item item = new Item(1L, "小米手机7", " 手机","小米", 3499.00, "http://image.leyou.com/13123.jpg");
        Item save = itemRepository.save(item);*/
       //新增多个
        List<Item> list = new ArrayList<Item>();
        list.add(new Item(2L, "坚果手机R1", " 手机", "锤子", 3699.00, "http://image.leyou.com/123.jpg"));
        list.add(new Item(3L, "华为META10", " 手机", "华为", 4499.00, "http://image.leyou.com/3.jpg"));
        // 接收对象集合，实现批量新增
        itemRepository.saveAll(list);

    }
}
