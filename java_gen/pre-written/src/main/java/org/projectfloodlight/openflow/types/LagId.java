package org.projectfloodlight.openflow.types;

import org.jboss.netty.buffer.ChannelBuffer;
import javax.annotation.concurrent.Immutable;

@Immutable
public class LagId {
    static final int LENGTH = 4;
    private final int rawValue;

    private LagId(final int rawValue) {
        this.rawValue = rawValue;
    }

    public static LagId of(final int raw) {
        return new LagId(raw);
    }

    public int getInt() {
        return rawValue;
    }

    public int getLength() {
        return LENGTH;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + rawValue;
        return result;
    }

    @Override
    public String toString() {
        return Integer.toString(rawValue);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LagId other = (LagId) obj;
        if (rawValue != other.rawValue)
            return false;
        return true;
    }

    public void write4Bytes(ChannelBuffer c) {
        c.writeInt(rawValue);
    }

    public static LagId read4Bytes(ChannelBuffer c) {
        return LagId.of(c.readInt());
    }
}
