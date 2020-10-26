package com.chenlw.spring.example;

/**
 * @author chenlw
 * @since 2020-10-26
 */
public class HelloWorld {
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public void getMessage() {
        System.out.println("Your Message : " + message);
    }
}