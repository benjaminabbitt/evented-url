package name.benjaminabbitt.wwwwwh.where.url.businesslogic

import io.micronaut.context.annotation.ConfigurationProperties

@ConfigurationProperties("url")
class BookmarkConfig {
    var message: String? = null
}