package io.cucumber.kotlin.name.benjaminabbitt.wwwwwh.where.url

import com.google.protobuf.Any
import io.cucumber.java8.En
import name.benjaminabbitt.wwwwwh.where.url.projection.sample.EnhancedProtoUUID
import name.benjaminabbitt.wwwwwh.where.url.projection.sample.bookmarks.Bookmarks
import name.benjaminabbitt.wwwwwh.where.url.projection.sample.core.Evented
import name.benjaminabbitt.wwwwwh.where.url.businesslogic.BookmarkConfig
import name.benjaminabbitt.wwwwwh.where.url.businesslogic.BookmarkService
import name.benjaminabbitt.wwwwwh.where.url.businesslogic.statemachine.states.Bookmark
import org.junit.jupiter.api.Assertions.*
import java.util.*

class UnitStepDefinitions : En {
    private lateinit var service: BookmarkService

    init {
        Given("Empty State$") {
            service = BookmarkService(BookmarkConfig())
        }

        Given("No Bookmark Exists$") {
            assertTrue(true)
        }

        When("I create a bookmark with name \"{string}\" and URL \"{string}\"") { name: String, url: String ->
            val id = EnhancedProtoUUID(UUID.nameUUIDFromBytes(url.encodeToByteArray()))
            val createBookmark = Bookmarks.CreateBookmark.newBuilder()
                .setName(name)
                .setUrl(url)
                .build()
            val commandBook: Evented.CommandBook = Evented.CommandBook.newBuilder()
                .setCover(
                    Evented.Cover.newBuilder()
                        .setRoot(id.getNetworkId())
                        .setDomain(Bookmark::class.toString())
                        .build()
                )
                .addPages(
                    Evented.CommandPage.newBuilder()
                        .setCommand(Any.pack(createBookmark))
                        .setSequence(0)
                        .build()
                )
                .build()
            val command: Evented.ContextualCommand =
                Evented.ContextualCommand.newBuilder().setCommand(commandBook).build()
            service.handle(command, StreamObserverStub())
        }

    }
}
