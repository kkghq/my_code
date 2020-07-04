package com.ganhq.kaiser;

public class KaiserDemo {

    public static void main(String[] args) {
        String input = "Hello world!!";
        int key = 3;
        StringBuffer sb = new StringBuffer();

        char[] chars = input.toCharArray();

        for (char c : chars) {
            int asciiCode = c;
            asciiCode += 3;
            char newChar = (char)asciiCode;
            sb.append(newChar);
        }

        System.out.println(chars.toString());
    }

    /**
     *
     * @param encryptedData  密文
     * @param key  密钥
     * @return 源数据
     */
    public static String decrypt(String encryptedData, int key) {
        char[] chars = encryptedData.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (char aChar : chars) {
            // 获取字符的ASCII编码
            int asciiCode = aChar;
            // 偏移数据
            asciiCode -= key;
            // 将偏移后的数据转为字符
            char result = (char) asciiCode;
            // 拼接数据
            sb.append(result);
        }
        return sb.toString();
    }

    /**
     *
     * @param orignal 明文
     * @param key 密钥
     * @return 密文
     */
    public static String encrypt(String orignal, int key) {
        char[] chars = orignal.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (char aChar : chars) {
            // 获取字符的ASCII编码
            int asciiCode = aChar;
            // 偏移数据
            asciiCode += key;
            // 将偏移后的数据转为字符
            char result = (char) asciiCode;
            // 拼接数据
            sb.append(result);
        }
        return sb.toString();
    }
}
