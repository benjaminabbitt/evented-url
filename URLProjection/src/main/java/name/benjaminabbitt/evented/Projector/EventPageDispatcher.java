package name.benjaminabbitt.evented.Projector;

import name.benjaminabbitt.evented.core.Evented;

public interface EventPageDispatcher {
    void dispatch(Evented.Cover cover, Evented.EventPage message);
}
