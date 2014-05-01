package com.devro.currency.utils;

import com.devro.currency.uuid.UUIDFetcher;

import java.util.UUID;

/**
 * Programmed by: DevRo_ (Erik Rosemberg)
 * Creation Date: 28, 04, 2014
 * Programmed for the Currency+ project.
 */
public class UUIDUtil {
        public static UUID getUUIDFromPlayer(String name){
            try {
                return UUIDFetcher.getUUIDOf(name);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
}
