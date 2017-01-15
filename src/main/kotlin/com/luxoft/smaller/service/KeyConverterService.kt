package com.luxoft.smaller.service

interface KeyConverterService {

    fun idToKey(id: Long): String
    fun keyToId(key: String): Long

}