package org.bupt.cad.fedraft.utils;

import com.google.protobuf.ByteString;

public class DataTypeTransformer {

    /**
     * 高性能转换double和byteString
     *
     * @param d double value
     * @return byteString
     */
    public static ByteString doubleToByteString(double d) {
        // double 一共8字节
        byte[] buffer = new byte[8];

        // double 转 bit 位
        long bits = Double.doubleToLongBits(d);
        for (int i = 0; i < 8; i++) {
            buffer[i] = (byte) ((bits >> 8 * i) & 0xff);
        }
        return ByteString.copyFrom(buffer);
    }

    /**
     * 高性能转换double和byteString
     *
     * @param byteString bytes
     * @return double value
     */
    public static double byteStringToDouble(ByteString byteString) {
        byte[] buffer = byteString.toByteArray();

        long bits = 0;
        for (int i = 0; i < 8; i++) {
            bits |= ((long) (buffer[i] & 0xff)) << (8 * i);
        }

        return Double.longBitsToDouble(bits);
    }


}
