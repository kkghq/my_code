package com.ganhq.ascii;

public class AsciiDemo {

    public static void main(String[] args) {
        char a = 'A';
        int b = a;
        System.out.println(b);

        String c = "AaZ";
        char[] chars = c.toCharArray();
        for (char d : chars) {

            int asciiCode = d;
            System.out.println(asciiCode);
        }
    }
}

