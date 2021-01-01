package name.benjaminabbitt.wwwwwh.where.url.businesslogic.bookmarks

import io.micronaut.context.annotation.ConfigurationProperties

@ConfigurationProperties("url")
class BookmarkConfig {
    var message: String? = null
}