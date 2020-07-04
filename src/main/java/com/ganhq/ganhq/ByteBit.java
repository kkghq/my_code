package com.ganhq.ganhq;

import javafx.beans.binding.IntegerBinding;

public class ByteBit {
    public static void main(String[] args) {
        String a = "a";
        byte[] bytes = a.getBytes();
        for (byte b : bytes) {
            int c=b;
            // 打印发现byte实际上就是ascii码
            System.out.println(c);
            String s = Integer.toBinaryString(c);
            System.out.println(s);
        }
    }
}
