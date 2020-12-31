package name.benjaminabbitt.evented.projector

import com.google.protobuf.InvalidProtocolBufferException
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoCollection
import com.mongodb.client.model.Filters
import com.mongodb.client.model.Updates
import name.benjaminabbitt.evented.EnhancedProtoUUID
import name.benjaminabbitt.evented.EventPageDispatcher
import name.benjaminabbitt.evented.bookmarks.Bookmarks.BookmarkCreated
import name.benjaminabbitt.evented.bookmarks.Bookmarks.BookmarkDeleted
import name.benjaminabbitt.evented.core.Evented
import name.benjaminabbitt.evented.exceptions.UnmatchedEvent
import org.bson.Document

class BookmarkProjector(client: MongoClient) : EventPageDispatcher {
    private val collection: MongoCollection<Document>

    @Throws(UnmatchedEvent::class)
    override fun dispatch(cover: Evented.Cover, message: Evented.EventPage) {
        val event = message.event
        try {
            when {
                event.`is`(BookmarkCreated::class.java) -> {
                    this.handle(cover, message, event.unpack(BookmarkCreated::class.java))
                }
                event.`is`(BookmarkDeleted::class.java) -> {
                    this.handle(cover, message, event.unpack(BookmarkDeleted::class.java))
                }
                else -> {
                    throw UnmatchedEvent(event)
                }
            }
        } catch (e: InvalidProtocolBufferException) {
            e.printStackTrace()
        }
    }

    private fun handle(cover: Evented.Cover, page: Evented.EventPage, bookmarkCreated: BookmarkCreated) {
        collection.insertOne(
            Document("name", bookmarkCreated.name)
                .append("url", bookmarkCreated.url)
                .append("deleted", false)
                .append("sequence", page.sequenceCase.number)
                .append("_id", EnhancedProtoUUID(cover.root).toString())
        )
    }

    private fun handle(cover: Evented.Cover, page: Evented.EventPage, bookmarkDeleted: BookmarkDeleted) {
        collection.updateOne(
            Filters.eq("_id", EnhancedProtoUUID(cover.root).toString()),
            Updates.combine(
                Updates.set("deleted", true),
                Updates.set("sequence", page.sequenceCase.number)
            )
        )
    }

    init {
        val db = client.getDatabase("projection")
        collection = db.getCollection("test")
    }
}