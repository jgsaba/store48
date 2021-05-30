package com.jorge.backend.shoppingapi.service;

import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;


class ShopServiceTest {

    public class Example{
        ZonedDateTime date = ZonedDateTime.now();

        public ZonedDateTime getDate() {
            return date;
        }

        public void setDate(ZonedDateTime date) {
            this.date = date;
        }
    }

    @Test
    public void test(){
        Example example = new Example();
        ZonedDateTime today = example.getDate();

        System.out.println(today);
        System.out.println(example.getDate());

        example.setDate(ZonedDateTime.now().plusDays(1));

        System.out.println(today);
        System.out.println(example.getDate());
    }
}