package com.springframework.springmvc.services.security;

/*
PROJECT NAME : 9. JPA Entity Relationships
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 3/2/2022 3:20 PM
*/

public interface EncryptionService {
    String encryptString(String input);
    boolean checkPassword(String plainPassword, String encryptedPassword);
}
