// Here we are customizing the Cache configuration --> its just overriding the methods present in CacheManagerCusstomizer class to customize
//how the values are stored in cache ,or cache name, or 

package com.caching.LibraryApplication.config;

import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfiguration {

    CacheManagerCustomizer<ConcurrentMapCacheManager> customizer(){
        return new ConcurrentCustomizer();
    }

    class ConcurrentCustomizer implements CacheManagerCustomizer<ConcurrentMapCacheManager>{

        @Override
        public void customize(ConcurrentMapCacheManager cacheManager) {

            cacheManager.setAllowNullValues(true);
        }
    }
}
