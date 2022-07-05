package com.baeldung.ls.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor, Ordered {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        BeanDefinition bd = configurableListableBeanFactory.getBeanDefinition("beanA");
        bd.getPropertyValues().add("foo", "bar");
    }


    @Override
    public int getOrder() {
        return 1;
    }
}
// By using the bean factory that the container gives us access to allows
// us to obtain the BeanDefinition of beanA
// We then assign a value bar to the foo property