package name.benjaminabbitt.wwwwwh.where.url.projection.sample.consul

import com.ecwid.consul.v1.ConsulClient
import com.ecwid.consul.v1.Response
import com.ecwid.consul.v1.kv.model.GetValue

class ConsulConfig<T>(host: String) {
    private val client: ConsulClient = ConsulClient("localhost")
    fun enhanceConfiguration(configuration: T): T {
        // get list of KVs for key prefix (recursive)
        val keyValuesResponse: Response<List<GetValue>> = client.getKVValues("com.my")
        keyValuesResponse.value.forEach { value -> println(value.key.toString() + ": " + value.decodedValue) } // prints "com.my.app.foo: foo" and "com.my.app.bar: bar"
        return configuration;
    }

}