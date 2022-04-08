package com.example.toyboard.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class AESCryptoUtil {

    private static final Logger logger = LoggerFactory.getLogger(AESCryptoUtil.class);

    /**
     *
     * @name : getKey
     * @since : 2022-04-07 오후 4:09
     * @return  javax.crypto.SecretKey
     * 암호화 복호화에 필요한 키 반환
     *
     */
    public static SecretKey getKey(){
        KeyGenerator keyGenerator = null;
        SecretKey secretKey = null;
        try {
            keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            secretKey = keyGenerator.generateKey();
        } catch (NoSuchAlgorithmException e) {
            logger.error(e.getMessage(),e);
        }

        return secretKey;
    }

    /**
     *
     * @name : getIv
     * @since : 2022-04-07 오후 4:11
     * @return  javax.crypto.spec.IvParameterSpec
     * 초기화 벡터 반환환(AES 알고리즘에서 필요한 코드)
    *
     */

    public static IvParameterSpec getIv(){
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }

    /**
     *
     * @name : encrypt
     * @author : Jang You Jung
     * @since : 2022-04-07 오후 4:19
     * @return  java.lang.String
     * 암호화
     *
     */

    public static String encrypt(String specName, SecretKey key, IvParameterSpec iv, String plainText){

        byte[] encrypted = new byte[0];

        try {
            Cipher cipher = Cipher.getInstance(specName);
            cipher.init(Cipher.ENCRYPT_MODE, key, iv);
            encrypted = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));


        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            logger.error(e.getMessage(),e);
        }

        return new String(Base64.getEncoder().encode(encrypted));
    }

    /**
     *
     * @name : decrypt
     * @author : Jang You Jung
     * @since : 2022-04-07 오후 4:20
     * @return  java.lang.String
     * 복호화
     *
     */

    public static String decrypt(String specName, SecretKey key, IvParameterSpec iv, String cipherText){
        byte[] decrypted = new byte[0];
        try{
            Cipher cipher = Cipher.getInstance(specName);
            cipher.init(Cipher.DECRYPT_MODE,key,iv);
            decrypted = cipher.doFinal(Base64.getDecoder().decode(cipherText));
        } catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidAlgorithmParameterException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            logger.error(e.getMessage(),e);
        }

        return new String(decrypted,StandardCharsets.UTF_8);
    }
}
