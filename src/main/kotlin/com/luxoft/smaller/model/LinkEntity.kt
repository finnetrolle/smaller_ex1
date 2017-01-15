package com.luxoft.smaller.model

import javax.persistence.*
import org.springframework.data.repository.Repository
import java.util.*

@Entity
@Table(name = "links")
data class LinkEntity (
        var text: String = "",
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "links_sequence")
        @SequenceGenerator(name = "links_sequence", sequenceName = "links_seq")
        var id: Long = 0
)

interface LinkRepository : Repository<LinkEntity, Long> {
    fun findOne(id: Long?): Optional<LinkEntity>
    fun save(link: LinkEntity): LinkEntity
}