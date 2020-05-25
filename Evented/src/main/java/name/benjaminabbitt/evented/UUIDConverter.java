package name.benjaminabbitt.evented;

import com.google.protobuf.ByteString;
import name.benjaminabbitt.evented.core.Evented;

import java.nio.ByteBuffer;
import java.util.UUID;

public class UUIDConverter {
    public static Evented.UUID uuidToNetwork(UUID uuid) {
        return Evented.UUID.newBuilder().setValue(ByteString.copyFrom(getBytesFromUUID(uuid))).build();
    }

    public static Evented.UUID generate() {
        return uuidToNetwork(UUID.randomUUID());
    }

    public static byte[] getBytesFromUUID(UUID uuid) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());

        return bb.array();
    }

    public static UUID getUUIDFromBytes(byte[] bytes) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        Long high = byteBuffer.getLong();
        Long low = byteBuffer.getLong();

        return new UUID(high, low);
    }
}
