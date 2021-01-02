package name.benjaminabbitt.wwwwwh.where.url.projection.sample

import name.benjaminabbitt.wwwwwh.where.url.projection.sample.core.Evented
import name.benjaminabbitt.wwwwwh.where.url.projection.sample.exceptions.UnmatchedEvent

interface EventPageDispatcher {
    @Throws(UnmatchedEvent::class)
    fun dispatch(cover: Evented.Cover, message: Evented.EventPage)
}