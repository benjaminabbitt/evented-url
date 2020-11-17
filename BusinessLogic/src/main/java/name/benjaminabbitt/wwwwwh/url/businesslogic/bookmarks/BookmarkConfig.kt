package name.benjaminabbitt.wwwwwh.url.businesslogic.bookmarks

import io.micronaut.context.annotation.ConfigurationProperties

@ConfigurationProperties("url")
class BookmarkConfig {
    var message: String? = null
}