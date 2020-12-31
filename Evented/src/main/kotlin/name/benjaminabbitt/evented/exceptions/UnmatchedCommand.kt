package name.benjaminabbitt.evented.exceptions

class UnmatchedCommand(var command: Any) : Unhandlable() {
}