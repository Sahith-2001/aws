package com.task10.pojo;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperFieldModel;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTyped;

import lombok.Data;

@Data
@DynamoDBTable(tableName = "cmtr-ecf0d511-Tables-test")
public class Tables {
    @DynamoDBHashKey
    private int id;
    private int number;
    private int places;
    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.BOOL)
    private boolean isVip;
    private int minOrder;
}