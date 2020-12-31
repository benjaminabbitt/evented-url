@file:JvmName("UUIDConverter")

package name.benjaminabbitt.evented

import com.google.protobuf.ByteString
import name.benjaminabbitt.evented.core.Evented
import java.nio.ByteBuffer
import java.util.*

class EnhancedProtoUUID {
    private val id: UUID

    constructor(uuid: UUID) {
        id = uuid
    }

    constructor(networkId: Evented.UUID) {
        id = getUUIDFromBytes(networkId.value.toByteArray())
    }

    fun getNetworkId(): Evented.UUID {
        return Evented.UUID.newBuilder()
            .setValue(ByteString.copyFrom(getBytesFromUUID(id)))
            .build()
    }

    fun getUUID(): UUID {
        return id
    }

    companion object {
        private fun getBytesFromUUID(uuid: UUID): ByteArray {
            val bb = ByteBuffer.wrap(ByteArray(16))
            bb.putLong(uuid.mostSignificantBits)
            bb.putLong(uuid.leastSignificantBits)
            return bb.array()
        }

        private fun getUUIDFromBytes(bytes: ByteArray?): UUID {
            val byteBuffer = ByteBuffer.wrap(bytes)
            val high = byteBuffer.long
            val low = byteBuffer.long
            return UUID(high, low)
        }
    }
}

