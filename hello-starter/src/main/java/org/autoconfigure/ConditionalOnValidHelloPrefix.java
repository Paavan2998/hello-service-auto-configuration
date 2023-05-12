package org.autoconfigure;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(OnValidHelloPrefixCondition.class)
public @interface ConditionalOnValidHelloPrefix {
}
