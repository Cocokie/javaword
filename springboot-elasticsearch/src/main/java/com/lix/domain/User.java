package com.lix.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;
import java.util.Map;

@Data
@Document(indexName = "user",type = "docs", shards = 1, replicas = 0)
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private Long id;

    @Field(type = FieldType.Text)
    private List<String> los;

    @Field(type = FieldType.Object)
    private Map<String,String> hashmap;

    @Field(type = FieldType.Object)
    private Item singleItem;

    @Field(type = FieldType.Text)
    private List<Item> items;

}

