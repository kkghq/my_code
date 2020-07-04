package com.ganhq.desaes;

import com.sun.org.apache.xml.internal.security.utils.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES/CBC/NoPadding (128)
 * AES/CBC/PKCS5Padding (128)
 * AES/ECB/NoPadding (128)
 * AES/ECB/PKCS5Padding (128)
 * DES/CBC/NoPadding (56)
 * DES/CBC/PKCS5Padding (56)
 * DES/ECB/NoPadding (56)
 * DES/ECB/PKCS5Padding (56)
 * DESede/CBC/NoPadding (168)
 * DESede/CBC/PKCS5Padding (168)
 * DESede/ECB/NoPadding (168)
 * DESede/ECB/PKCS5Padding (168)
 * RSA/ECB/PKCS1Padding (1024, 2048)
 * RSA/ECB/OAEPWithSHA-1AndMGF1Padding (1024, 2048)
 * RSA/ECB/OAEPWithSHA-256AndMGF1Padding (1024, 2048)
 */
public class DesAesDemo {

    /**
     *  无iv 8LqU6bY0Wgo=
     */
    public static void main(String[] args) throws Exception {
        //原文
        String input = "硅谷";
        //des加密必须是8位
        String key = "12345678";
        //算法
        String algorithm = "DES";
        String transformation = "DES/CBC/PKCS5Padding";
        String encrypt = encrypt(input, key, transformation, algorithm);
        // 打印密文
        System.out.println("密文：" + encrypt);

        String decrypt = decrypt(encrypt, key, transformation, algorithm);
        System.out.println("明文：" + decrypt);


    }

    private static String encrypt(String input, String key, String transformation, String algorithm) throws Exception {

        Cipher cipher = Cipher.getInstance(transformation);

        // 指定秘钥规则
        // 第一个参数表示：密钥，key的字节数组
        // 第二个参数表示：算法
        SecretKeySpec sks = new SecretKeySpec(key.getBytes(), algorithm);

        //初始向量，参数表示跟谁进行异或，初始向量的长度必须是8位
        IvParameterSpec iv = new IvParameterSpec("12345678".getBytes());

        // 对加密进行初始化
        // 第一个参数：表示模式，有加密模式和解密模式
        // 第二个参数：表示秘钥规则
        cipher.init(Cipher.ENCRYPT_MODE,sks,iv);

        // 进行加密
        byte[] bytes = cipher.doFinal(input.getBytes());

        String encode = Base64.encode(bytes);
        // 打印密文
        return encode;
    }

    private static String decrypt(String input, String key, String transformation, String algorithm) throws Exception {
        Cipher cipher = Cipher.getInstance(transformation);
        // 指定秘钥规则
        // 第一个参数表示：密钥，key的字节数组
        // 第二个参数表示：算法
        SecretKeySpec sks = new SecretKeySpec(key.getBytes(), algorithm);
        //初始向量，参数表示跟谁进行异或，初始向量的长度必须是8位
        IvParameterSpec iv = new IvParameterSpec("12345678".getBytes());
        // 对加密进行初始化
        // 第一个参数：表示模式，有加密模式和解密模式
        // 第二个参数：表示秘钥规则
        cipher.init(Cipher.DECRYPT_MODE,sks,iv);
        byte[] bytes = cipher.doFinal(Base64.decode(input));
        return new String(bytes);
    }

}
