//package io.cucumber.kotlin.name.benjaminabbitt.wwwwwh.url
//
//import com.google.protobuf.Any
//import io.cucumber.datatable.DataTable
//import io.cucumber.java8.En
//import io.cucumber.java8.Scenario
//import name.benjaminabbitt.evented.bookmarks.Bookmarks.CreateBookmarkIntent
//import name.benjaminabbitt.evented.core.Evented
//import name.benjaminabbitt.wwwwwh.url.businesslogic.bookmarks.BookmarkConfig
//import name.benjaminabbitt.wwwwwh.url.businesslogic.bookmarks.BookmarkService
//import org.junit.jupiter.api.Assertions.*
//import org.opentest4j.TestAbortedException
//
//var lastInstance: LambdaStepDefinitions? = null
//
//class OldLambdaStepDefinitions : En {
//
//    init {
//        DataTableType { entry: Map<String, String> ->
//            Person(entry["first"], entry["last"])
//        }
//
//        Before { scenario: Scenario ->
//            assertNotSame(this, lastInstance)
//            lastInstance = this
//        }
//
//        BeforeStep { scenario: Scenario ->
//            assertSame(this, lastInstance)
//            lastInstance = this
//        }
//
//        AfterStep { scenario: Scenario ->
//            assertSame(this, lastInstance)
//            lastInstance = this
//        }
//
//        After { scenario: Scenario ->
//            assertSame(this, lastInstance)
//            lastInstance = this
//        }
//
//        Given("this data table:") { peopleTable: DataTable ->
//            val people: List<Person> = peopleTable.asList(Person::class.java)
//            assertEquals("Aslak", people[0].first)
//            assertEquals("Hellesøy", people[0].last)
//        }
//
//        val alreadyHadThisManyCukes = 1
//        Given("I have {long} cukes in my belly") { n: Long ->
//            assertEquals(1, alreadyHadThisManyCukes)
//            assertEquals(42L, n)
//        }
//
//        val localState = "hello"
//        Then("I really have {int} cukes in my belly") { i: Int ->
//            assertEquals(42, i)
//            assertEquals("hello", localState)
//        }
//
//        Given("A statement with a body expression") { assertTrue(true) }
//
//        Given("A statement with a simple match", { assertTrue(true) })
//
//        Given("something that is skipped") { throw TestAbortedException("skip this!") }
//
//        val localInt = 1
//        Given("A statement with a scoped argument", { assertEquals(2, localInt + 1) })
//
//        Given("I will give you {int} and {float} and {word} and {int}") { a: Int, b: Float, c: String, d: Int ->
//            assertEquals(1, a)
//            assertEquals(2.2f, b)
//            assertEquals("three", c)
//            assertEquals(4, d)
//        }
//
//        // Code here
//        Given("Empty State$") {
//            service = BookmarkService(BookmarkConfig())
//        }
//
//        Given("No Bookmark Exists$") {
//            assertTrue(true)
//        }
//
//        When("I create a bookmark with name \"{string}\"") { name: String ->
//            var service = BookmarkService(BookmarkConfig())
//            val test = CreateBookmarkIntent.newBuilder().setName("test").setUrl("http://test.example").build()
//            val commandBook: Evented.CommandBook = name.benjaminabbitt.evented.core.Evented.CommandBook.newBuilder().setCover(name.benjaminabbitt.evented.core.Evented.Cover.newBuilder().setRoot(name.benjaminabbitt.evented.core.Evented.UUID.newBuilder().build()).setDomain("").build()).addPages(name.benjaminabbitt.evented.core.Evented.CommandPage.newBuilder().setCommand(Any.pack(test)).setSequence(0).build()).build()
//            val command: Evented.ContextualCommand = name.benjaminabbitt.evented.core.Evented.ContextualCommand.newBuilder().setCommand(commandBook).build()
//            service.handle(command, StreamObserverStub<Evented.EventBook>())
//        }
//
//        Then("A bookmark with name \"{string}\" exists") { name: String ->
//
//        }
//    }
//}
//
//data class Person(val first: String?, val last: String?)