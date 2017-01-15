package com.luxoft.smaller.service

import com.luxoft.smaller.exception.KeyNotFoundException
import com.luxoft.smaller.model.LinkEntity
import com.luxoft.smaller.model.LinkRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
open class KeyMapperServiceImpl : KeyMapperService {

    @Autowired lateinit private var repo: LinkRepository

    @Autowired lateinit private var converter: KeyConverterService

    @Transactional
    override fun add(link: String) = converter.idToKey(repo.save(LinkEntity(link)).id)

    override fun get(key: String) = repo.findOne(converter.keyToId(key))
            .orElseThrow{KeyNotFoundException()}.text

}