package inm.or.common;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableCaching
public class CacheConfig {

//    @Bean
//    public CaffeineCacheManager cacheManager() {
//        CaffeineCacheManager cacheManager = new CaffeineCacheManager("myCache");
//        cacheManager.setCaffeine(caffeineCacheBuilder());
//        return cacheManager;
//    }

    @Bean
    public Cache<String, Object> caffeineCache() {
        return Caffeine.newBuilder()
                .initialCapacity(100)
                .maximumSize(500)
                .expireAfterWrite(10, java.util.concurrent.TimeUnit.MINUTES)
                .build();
    }

//    @Bean
//    public Caffeine<Object, Object> caffeineCacheBuilder() {
//        return Caffeine.newBuilder()
//                .initialCapacity(100)
//                .maximumSize(500)
//                .expireAfterWrite(10, java.util.concurrent.TimeUnit.MINUTES)
//                .weakKeys()
//                .recordStats();
//    }
}