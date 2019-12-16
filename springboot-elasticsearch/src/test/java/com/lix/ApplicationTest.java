package com.lix;


import com.lix.domain.Item;

import com.lix.domain.User;
import com.lix.repository.ItemRepository;
import com.lix.repository.UserRepository;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;

import java.util.*;

@SpringBootTest
public class ApplicationTest {
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ElasticsearchTemplate esTemplate;

    @Test
    public void createIndex() {
        //createIndexMapping();
        //insertOne();
//        insertMany();
//        basicQuery();
        complexInsert();
        //customizeQueryMethod();
       // complexQueryCondition();


    }

    private void complexQueryCondition() {
        // 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();

        // 添加基本分词查询
        queryBuilder.withQuery(QueryBuilders.matchQuery("title", "小米手机"));
        // 搜索，获取结果
        Page<Item> items = this.itemRepository.search(queryBuilder.build());

        // 总条数
        long total = items.getTotalElements();
        List<Item> content = items.getContent();
        System.out.println("total = " + total);
        for (Item item : content) {
            System.out.println(item);
        }
    }

    private void customizeQueryMethod() {
        //自定义查询方法
        List<Item> byPriceBetween = itemRepository.findByPriceBetween(3000, 4000);
        for (Item item : byPriceBetween) {
            System.out.println(item);
        }
    }

    private void complexInsert() {
        Map<String,String> hash = new HashMap<String, String>();
        hash.put("name","lixin");
        hash.put("kof","八稚女");

        List<String> strings = Arrays.asList("xiexie,lol");
        Item item = new Item(66L, "小米手机7", "手机","小米", 3499.00, "http://image.leyou.com/13123.jpg");

        List<Item> list = new ArrayList<Item>();
        list.add(new Item(77L, "坚果手s机R1", " 手机", "锤子", 3699.00, "http://image.leyou.com/123.jpg"));
        list.add(new Item(935L, "华为META1s0", " 手机", "华为", 4499.00, "http://image.leyou.com/3.jpg"));

        User u = new User(12l, strings,hash,item,list);
        userRepository.save(u);
    }

    private void basicQuery() {
        //基本查询
        // 查询全部，并安装价格降序排序
        Iterable<Item> price = itemRepository.findAll(Sort.by("price").descending());
        for (Item item : price) {
            System.out.println(item);
        }
    }

    private void insertMany() {
        //新增多个
        List<Item> list = new ArrayList<Item>();
        list.add(new Item(2L, "坚果手机R1", " 手机", "锤子", 3699.00, "http://image.leyou.com/123.jpg"));
        list.add(new Item(3L, "华为META10", " 手机", "华为", 4499.00, "http://image.leyou.com/3.jpg"));
        // 接收对象集合，实现批量新增
        itemRepository.saveAll(list);
    }

    private void insertOne() {
        //新增一个
        Item item = new Item(1L, "小米手机7", " 手机","小米", 3499.00, "http://image.leyou.com/13123.jpg");
        Item save = itemRepository.save(item);
        System.out.println(save);
    }

    private void createIndexMapping() {
        //创建索引，会根据Item类的@Document注解信息来创建
        esTemplate.createIndex(User.class);
        //配置映射，会根据Item类中的id、Field等字段来自动完成映射
        esTemplate.putMapping(User.class);
    }
}
