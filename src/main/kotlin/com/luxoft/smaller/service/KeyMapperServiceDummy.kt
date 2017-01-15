package com.luxoft.smaller.service

import com.luxoft.smaller.exception.KeyNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.concurrent.atomic.AtomicLong

//@Component
class KeyMapperServiceDummy : KeyMapperService {

    @Autowired lateinit private var converter: KeyConverterService

    private val counter = AtomicLong(100000L)
    private val map: MutableMap<Long, String> = mutableMapOf()

    override fun get(key: String) = map
            .getOrElse(converter.keyToId(key), { -> throw KeyNotFoundException()})

    override fun add(link: String): String {
        val id = counter.andIncrement
        map.put(id, link)
        return converter.idToKey(id)
    }

}


