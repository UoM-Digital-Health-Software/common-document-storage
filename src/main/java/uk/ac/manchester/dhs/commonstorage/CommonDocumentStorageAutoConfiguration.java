package uk.ac.manchester.dhs.commonstorage;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ConditionalOnProperty(name = "common-document-storage", havingValue = "true")
@EnableJpaRepositories(basePackages = "uk.ac.manchester.dhs.commonstorage")
public class CommonDocumentStorageAutoConfiguration {

}
