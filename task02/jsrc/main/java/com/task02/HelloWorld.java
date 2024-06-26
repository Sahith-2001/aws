package com.task02;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.syndicate.deployment.annotations.lambda.LambdaHandler;
import com.syndicate.deployment.annotations.lambda.LambdaUrlConfig;
import com.syndicate.deployment.model.RetentionSetting;
import com.syndicate.deployment.model.lambda.url.AuthType;
import com.syndicate.deployment.model.lambda.url.InvokeMode;
import java.util.LinkedHashMap;
import java.util.Map;

@LambdaHandler(lambdaName = "hello_world", roleName = "hello_world-role", isPublishVersion = true, logsExpiration = RetentionSetting.SYNDICATE_ALIASES_SPECIFIED)
@LambdaUrlConfig(authType = AuthType.NONE, invokeMode = InvokeMode.BUFFERED)
public class HelloWorld implements RequestHandler<Object, Map<String, Object>> {

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
