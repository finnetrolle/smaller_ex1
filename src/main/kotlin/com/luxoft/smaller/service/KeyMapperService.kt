package com.luxoft.smaller.service

interface KeyMapperService  {
    fun add(link: String): String
    fun get(key: String): String
}