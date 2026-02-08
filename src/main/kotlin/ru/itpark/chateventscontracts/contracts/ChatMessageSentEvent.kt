package ru.itpark.chateventscontracts.contracts

import java.time.Instant
import java.util.*

data class ChatMessageSentEvent(
    val eventVersion: Int = 1,
    val eventType: String = "ChatMessageSent",
    val chatId: Long,
    val senderId: Long,
    val text: String,
    val createdAt: Instant = Instant.now(),
    val message_id: UUID
)
