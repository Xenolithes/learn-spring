package com.baeldung.ls;

import com.baeldung.ls.persistence.repository.IProjectRepository;
import com.baeldung.ls.persistence.repository.impl.ProjectRepositoryImpl;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class LsAppConfig {

    //     These two annotations do the exact same thing
//    @Bean
//    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
//    public IProjectRepository singletonBean() {
//        return new ProjectRepositoryImpl();
//    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public IProjectRepository prototypeBean() {
        return new ProjectRepositoryImpl();
    }


}