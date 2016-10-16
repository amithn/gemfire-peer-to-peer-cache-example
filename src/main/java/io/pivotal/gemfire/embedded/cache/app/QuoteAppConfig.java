package io.pivotal.gemfire.embedded.cache.app;

import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.GemFireCache;
import org.kohsuke.randname.RandomNameGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.CacheFactoryBean;
import org.springframework.data.gemfire.PartitionedRegionFactoryBean;
import org.springframework.data.gemfire.support.GemfireCacheManager;

import java.util.Properties;
import java.util.UUID;

/**
 * Created by anambiar on 9/10/2016.
 */
@Configuration
public class QuoteAppConfig {

    @Bean
    QuoteService quoteService(RandomNameGenerator randomNameGenerator) {
        return new QuoteService(randomNameGenerator);
    }

    @Bean
    Properties gemfireProperties() {
        Properties gemfireProperties = new Properties();
        gemfireProperties.setProperty("name", "DataGemFireCachingApplication-" + UUID.randomUUID().toString());
        // gemfireProperties.setProperty("mcast-port", "0");
        gemfireProperties.setProperty("mcast-address", "239.192.81.1");
        gemfireProperties.setProperty("mcast-port", "10334");
        gemfireProperties.setProperty("log-level", "info");
        return gemfireProperties;
    }

    @Bean
    CacheFactoryBean gemfireCache() {
        CacheFactoryBean gemfireCache = new CacheFactoryBean();
        gemfireCache.setClose(true);
        gemfireCache.setProperties(gemfireProperties());
        return gemfireCache;
    }

    @Bean
    PartitionedRegionFactoryBean<Long, String> quotesRegion(GemFireCache cache) {
        PartitionedRegionFactoryBean<Long, String> quotesRegion = new PartitionedRegionFactoryBean<>();
        quotesRegion.setCache(cache);
        quotesRegion.setClose(false);
        quotesRegion.setName("Quotes");
        quotesRegion.setPersistent(false);
        return quotesRegion;
    }

    @Bean
    GemfireCacheManager cacheManager(Cache gemfireCache) {
        GemfireCacheManager cacheManager = new GemfireCacheManager();
        cacheManager.setCache(gemfireCache);
        return cacheManager;
    }

    @Bean
    RandomNameGenerator randomNameGenerator() {
        return new RandomNameGenerator(0);
    }
}
