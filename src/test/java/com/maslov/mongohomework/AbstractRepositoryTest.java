package com.maslov.mongohomework;

import com.maslov.mongohomework.utils.RawResultPrinterImpl;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@DataMongoTest
@EnableConfigurationProperties
@ComponentScan({"com.maslov.mongohomework.config", "com.maslov.mongohomework.repository"})
@Import(RawResultPrinterImpl.class)
public abstract class AbstractRepositoryTest {
}
