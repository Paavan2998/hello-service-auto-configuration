package org.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionMessage;
import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

class OnValidHelloPrefixCondition extends SpringBootCondition {
    @Override
    public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {
        ConditionMessage.Builder condition = ConditionMessage.forCondition(ConditionalOnValidHelloPrefix.class);
        if(context.getEnvironment().containsProperty("hello.prefix")){
            String value = context.getEnvironment().getProperty("hello.prefix");
            if(Character.isUpperCase(value.charAt(0))){
                return ConditionOutcome.match(condition.available(String.format("valid prefix ('%s')", value)));
            }
            return ConditionOutcome.noMatch(condition.because(
                    String.format("rejected the prefix '%s' as it does not start with an upper-case character", value)
            ));
        }
        return ConditionOutcome.noMatch(condition.didNotFind("property", "properties").items("'hello.prefix'"));
    }
}
