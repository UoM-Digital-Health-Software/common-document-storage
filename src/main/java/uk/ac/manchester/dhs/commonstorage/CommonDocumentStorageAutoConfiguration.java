package uk.ac.manchester.dhs.commonstorage;

import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import uk.ac.manchester.dhs.commonstorage.repository.CommonDocumentRepository;
import uk.ac.manchester.dhs.commonstorage.web.CommonDocumentResource;

@Configuration
@ConditionalOnProperty(name = "common-document-storage", havingValue = "true")
@EnableJpaRepositories(basePackages = "uk.ac.manchester.dhs.commonstorage")
public class CommonDocumentStorageAutoConfiguration {

    @Bean
    public CommonDocumentResource commonDocumentResource(CommonDocumentRepository commonDocumentRepository){
        return new CommonDocumentResource(commonDocumentRepository);
    }

}
