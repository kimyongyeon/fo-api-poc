package inm.or.biz.service;

import com.github.benmanes.caffeine.cache.Cache;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class CaffeinCacheService {

    private final Cache<String, Object> caffeineCache;

    public Object getData(String id) {
        // 캐시에서 데이터 가져오기
        Object data = caffeineCache.getIfPresent(id);
        if (data == null) {
            // 실제 데이터베이스나 외부 API 호출
            data = fetchDataFromSource(id);
            // 캐시에 데이터 저장 (동적으로 TTL 설정)
            caffeineCache.put(id, data);
        }
        return data;
    }

    public void putDataWithCustomTTL(String id, Object data, long ttl, TimeUnit unit) {
        caffeineCache.put(id, data);
        caffeineCache.policy().expireVariably().ifPresent(expiry ->
                expiry.setExpiresAfter(id, ttl, unit)
        );
    }

    public Object fetchDataFromSource(String id) {
        // 실제 데이터베이스나 외부 API 호출
        return "Data for " + id;
    }
}
