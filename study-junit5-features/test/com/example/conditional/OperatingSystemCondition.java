package com.example.conditional;

import java.util.Arrays;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.util.AnnotationUtils;

public class OperatingSystemCondition implements ExecutionCondition {

	@Override
	public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext ec) {
		var result = ConditionEvaluationResult.enabled("@ConditionalTestOnOperatingSystem is not present.");
		var element = ec.getElement();
		var condition = AnnotationUtils.findAnnotation(element, ConditionalTestOnOperatingSystem.class);
		if (condition.isPresent()) {
			var os = OperatingSystemEnum.determineOs();
			var values = condition.get().value();
			var found = Arrays.stream(values)
					          .filter( value -> value.equals(os))
					          .findFirst();
			if (found.isPresent())
				result = ConditionEvaluationResult.enabled("@ConditionalTestOnOperatingSystem is present and enabled.");
			else
				result = ConditionEvaluationResult.disabled("@ConditionalTestOnOperatingSystem is present and disabled.");
		}
		return result;
	}

}
