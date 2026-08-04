package com.krizaldis.distributedsystem.kafka.configuration

import com.fasterxml.jackson.databind.ObjectMapper
import com.krizaldis.distributedsystem.common.serialization.EventDeserializer
import com.krizaldis.distributedsystem.common.serialization.EventSerializer
import com.krizaldis.distributedsystem.common.serialization.JacksonEventDeserializer
import com.krizaldis.distributedsystem.common.serialization.JacksonEventSerializer
import com.krizaldis.distributedsystem.common.serialization.ObjectMapperFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SerializationConfiguration {

    @Bean
    fun objectMapper(): ObjectMapper = ObjectMapperFactory.create()

    @Bean
    fun eventSerializer(mapper: ObjectMapper): EventSerializer =
        JacksonEventSerializer(mapper)

    @Bean
    fun eventDeserializer(mapper: ObjectMapper): EventDeserializer =
        JacksonEventDeserializer(mapper)
}