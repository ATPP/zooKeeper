package com.pattern;

import java.util.HashMap;
import java.util.Map;

public class Favorites {

    //    private Map<Class<T>, T> map = new HashMap<Class<T>, T>();
    private Map<Class<?>, Object> map = new HashMap<>();

    public <T> void putFavorite(Class<T> type, T instance) {
        if (type == null) {
            throw new NullPointerException("type is null");
        }
        map.put(type, type.cast(instance));
    }


    public <T> T getFavorite(Class<T> type) {
        return type.cast(map.get(type));
    }


    public static void main(String[] args) {
        Favorites favorites = new Favorites();
        favorites.putFavorite(String.class, "wing");
        favorites.putFavorite(Integer.class, 1);
        favorites.putFavorite(Class.class, Favorites.class);
        String str = favorites.getFavorite(String.class);
        Integer integer = favorites.getFavorite(Integer.class);
        Class<?> clzss = favorites.getFavorite(Class.class);
        System.out.println(str + "  " + integer + "  " + clzss.getName());
    }
}
