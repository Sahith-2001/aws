package com.task03;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.syndicate.deployment.annotations.lambda.LambdaHandler;
import com.syndicate.deployment.model.RetentionSetting;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@LambdaHandler(lambdaName = "api-handler",
	roleName = "api-handler-role",
	isPublishVersion = true,
	aliasName = "${lambdas_alias_name}",
	logsExpiration = RetentionSetting.SYNDICATE_ALIASES_SPECIFIED
)
public class ApiHandler implements RequestHandler<Object, Map<String, Object>> {

	public Map<String, Object> handleRequest(Object request, Context context) {
		Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
		Map<String, Object> bodyMap = new LinkedHashMap<>();
		bodyMap.put("message", "Hello from Lambda");
		bodyMap.put("statusCode", 200);
		resultMap.put("body", bodyMap);
		resultMap.put("statusCode", 200);
		return resultMap;
	}
}
