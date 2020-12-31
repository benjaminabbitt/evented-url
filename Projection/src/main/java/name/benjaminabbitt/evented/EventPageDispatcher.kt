package name.benjaminabbitt.evented

import name.benjaminabbitt.evented.core.Evented
import name.benjaminabbitt.evented.exceptions.UnmatchedEvent

interface EventPageDispatcher {
    @Throws(UnmatchedEvent::class)
    fun dispatch(cover: Evented.Cover, message: Evented.EventPage)
}