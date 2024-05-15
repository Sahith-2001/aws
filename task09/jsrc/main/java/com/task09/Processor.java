package com.task09;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.syndicate.deployment.annotations.events.DynamoDbTriggerEventSource;
import com.syndicate.deployment.annotations.lambda.LambdaHandler;
import com.syndicate.deployment.annotations.lambda.LambdaUrlConfig;
import com.syndicate.deployment.model.RetentionSetting;
import com.syndicate.deployment.model.lambda.url.AuthType;
import com.syndicate.deployment.model.lambda.url.InvokeMode;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@LambdaHandler(lambdaName = "processor",
	roleName = "processor-role",
	isPublishVersion = true,
	logsExpiration = RetentionSetting.SYNDICATE_ALIASES_SPECIFIED
)
@LambdaUrlConfig(authType = AuthType.NONE, invokeMode = InvokeMode.BUFFERED)
@DynamoDbTriggerEventSource(batchSize = 10, targetTable = "Weather")
public class Processor implements RequestHandler<Object, Map<String, Object>> {
	private final Table eventsTable;

public Processor() {
	AmazonDynamoDB client = AmazonDynamoDBClientBuilder.defaultClient();
	DynamoDB dynamoDB = new DynamoDB(client);
	eventsTable = dynamoDB.getTable("cmtr-ecf0d511-Weather-test");
}

	public Map<String, Object> handleRequest(Object request, Context context) {

		OpenMeteoAPI openMeteoObj = new OpenMeteoAPI();
		String weather = null;


			weather = (String) openMeteoObj.getWeatherForecast();

		  Item item = new Item().withPrimaryKey("id", UUID.randomUUID().toString()).withJSON("forecast", weather);
		  eventsTable.putItem(item);
		Map<String, Object> resultMap = new HashMap<String, Object>();

		resultMap.put("statusCode", 200);

		resultMap.put("body", weather);

		return resultMap;

	}
}
