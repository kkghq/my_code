package com.ganhq.desaes;

import com.sun.org.apache.xml.internal.security.utils.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.imageio.stream.ImageInputStream;

public class DesDemo {

    public static void main(String[] args) throws Exception {
        String input ="硅谷";
        // DES加密算法，key的大小必须是8个字节
        String key = "12345678";

        String transformation = "DES"; // 9PQXVUIhaaQ=
        // 指定获取密钥的算法
        String algorithm = "DES";
        String encryptDES = encryptDES(input, key, transformation, algorithm);
        System.out.println("加密:" + encryptDES);
        String s = decryptDES(encryptDES, key, transformation, algorithm);
        System.out.println("解密:" + s);
    }

    /**
     *
     * @param input 明文
     * @param key 密钥(DES,密钥的长度必须是8个字节)
     * @param transformation 获取Cipher对象的算法
     * @param algorithm 获取密钥的算法
     * @return 密文
     * @throws Exception
     */
    private static String encryptDES(String input, String key, String transformation, String algorithm) throws Exception {

        // 获取加密对象
        Cipher cipher = Cipher.getInstance(transformation);

        // 创建加密规则
        // 第一个参数key的字节
        // 第二个参数表示加密算法
        SecretKeySpec sks = new SecretKeySpec(key.getBytes(), algorithm);

        // ENCRYPT_MODE：加密模式
        // DECRYPT_MODE: 解密模式
        // 初始化加密模式和算法
        cipher.init(Cipher.ENCRYPT_MODE,sks);
        // 加密
        byte[] bytes = cipher.doFinal(input.getBytes());

        String encode = Base64.encode(bytes);
        return encode;
    }

    private static String decryptDES(String input, String key, String transformation, String algorithm) throws Exception {
        // 1,获取Cipher对象
        Cipher cipher = Cipher.getInstance(transformation);
        // 指定密钥规则
        SecretKeySpec sks = new SecretKeySpec(key.getBytes(), algorithm);
        cipher.init(Cipher.DECRYPT_MODE,sks);
        byte[] bytes = cipher.doFinal(Base64.decode(input));
        return new String(bytes);
    }
}
