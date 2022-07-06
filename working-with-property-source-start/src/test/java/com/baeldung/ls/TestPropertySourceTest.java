package com.baeldung.ls;

import com.baeldung.ls.spring.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = TestConfig.class)
@TestPropertySource("classpath:test.properties")
public class TestPropertySourceTest {

    @Value("${testproperty}")
    private String testProperty;

    @Value("${additional.info}")
    private String additionalInformation;

    @Test
    public void testPropertiesConnection (){
        assert(testProperty).equals("Goblins");
    }

    @Test
    public void testAdditionalProperties (){
        assert(additionalInformation).equals("Additional Info From Test");
    }
}
