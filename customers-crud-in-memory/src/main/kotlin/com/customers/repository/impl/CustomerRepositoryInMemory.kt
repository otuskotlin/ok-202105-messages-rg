package com.customers.repository.impl

import com.customers.model.CustomerContext
import com.customers.model.CustomerRow
import com.customers.repository.CustomersRepository
import org.ehcache.Cache
import org.ehcache.CacheManager
import org.ehcache.config.builders.CacheConfigurationBuilder
import org.ehcache.config.builders.CacheManagerBuilder
import org.ehcache.config.builders.ExpiryPolicyBuilder
import org.ehcache.config.builders.ResourcePoolsBuilder
import org.springframework.stereotype.Repository
import java.time.Duration
import java.util.*

@Repository
class CustomerRepositoryInMemory: CustomersRepository {

    private val ttl: Duration = Duration.ofMinutes(5)
    private val cache: Cache<UUID, CustomerRow> = let {
        val cacheManager: CacheManager = CacheManagerBuilder
            .newCacheManagerBuilder()
            .build(true)

        cacheManager.createCache(
            "customers-cache",
            CacheConfigurationBuilder
                .newCacheConfigurationBuilder(
                    UUID::class.java,
                    CustomerRow::class.java,
                    ResourcePoolsBuilder.heap(100)
                )
                .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(ttl))
                .build()
        )
    }

    override fun create(value:CustomerRow):UUID {
        cache.put(value.uuid,value)
        return value.uuid
    }

    override fun read(customerContext: CustomerContext): CustomerRow{
       return cache.get(customerContext.customerModel?.uuid)
    }

    override fun update(value:CustomerRow) {
       cache.replace(value.uuid,value)
    }

    override fun delete(uuid:UUID) {
        cache.remove(uuid)
    }

    override fun size(): Int {
        return cache.count()
    }

    override fun search(customerContext: CustomerContext): List<Cache.Entry<UUID, CustomerRow>> {
        return cache.filter { customerContext.customerModel?.email == it.value.email }
    }
}