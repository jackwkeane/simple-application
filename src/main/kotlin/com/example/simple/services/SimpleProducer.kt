package com.example.simple.services

import com.example.simple.models.SimpleModel
import com.google.gson.Gson
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import java.util.*

@Service
class SimpleProducer(
    private val kafkaTemplate: KafkaTemplate<String, String>
) {
    private val gson = Gson()

    companion object {
        private val logger = LoggerFactory.getLogger(SimpleProducer::class.java)
        private const val TOPIC = "simple-model-fact"
    }

    fun sendMessage(simpleModel: SimpleModel?, key: UUID) {
        logger.info(String.format("#### -> Producing message -> %s", simpleModel))
        val message = simpleModel?.let{gson.toJson(it)}
        kafkaTemplate.send(TOPIC, key.toString(), message)
    }
}