package com.ganhq;

public class ByteBitDemo {
    public static void main(String[] args) {
        String a = "尚";
        byte[] bytes = a.getBytes();
        for (byte b : bytes) {
            System.out.print(b + "   ");
            String s = Integer.toBinaryString(b);
            System.out.println(s);
        }
    }
}
