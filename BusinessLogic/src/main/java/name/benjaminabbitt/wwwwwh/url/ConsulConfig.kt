package name.benjaminabbitt.wwwwwh.url

import com.ecwid.consul.v1.ConsulClient
import com.ecwid.consul.v1.Response
import com.ecwid.consul.v1.kv.model.GetValue

class ConsulConfig<T> {
    private val client: ConsulClient = ConsulClient("localhost")
    fun enhanceConfiguration(configuration: T): T {
        // get list of KVs for key prefix (recursive)
        val keyValuesResponse: Response<List<GetValue>> = client.getKVValues("com.my")
        keyValuesResponse.value.forEach { value -> println(value.key.toString() + ": " + value.decodedValue) } // prints "com.my.app.foo: foo" and "com.my.app.bar: bar"
        return configuration;
    }

}