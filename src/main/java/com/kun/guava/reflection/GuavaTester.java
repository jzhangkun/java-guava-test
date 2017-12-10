package com.kun.guava.reflection;

import com.google.common.reflect.TypeParameter;
import com.google.common.reflect.TypeToken;

import java.math.BigInteger;
import java.util.Map;
import java.util.Queue;
import java.util.function.Function;

public class GuavaTester {
    public static void main(String... args) {
        GuavaTester t = new GuavaTester();
        t.testTypeToken();
        t.testResolveType();
        //FIXME - TBC
    }

    // deal with generic type
    void testTypeToken() {
        TypeToken<String> stringTok = TypeToken.of(String.class);
        TypeToken<Integer> intTok = TypeToken.of(Integer.class);
        System.out.println("String getType() " + stringTok.getType());
        System.out.println("Integer getType() " + intTok.getType());
        System.out.println("String getTypes() " + stringTok.getTypes());
        System.out.println("Integer getTypes() " + stringTok.getTypes());

        TypeToken<Map<String, BigInteger>> mapToken = mapToken(
            TypeToken.of(String.class),
            TypeToken.of(BigInteger.class));
        TypeToken<Map<Integer, Queue<String>>> complexToken = mapToken(
            TypeToken.of(Integer.class),
            new TypeToken<Queue<String>>() {});

        System.out.println(mapToken.getType());

        // anonymous subclass
        TypeToken type = new IKnowType<String>(){}.type;
        System.out.println(type.getType());
    }

    static <K, V> TypeToken<Map<K, V>> mapToken(TypeToken<K> keyToken, TypeToken<V> valueToken) {
        return new TypeToken<Map<K, V>>() {}
                .where(new TypeParameter<K>() {}, keyToken)
                .where(new TypeParameter<V>() {}, valueToken);
    }

    void testResolveType() {
        TypeToken<Function<Integer, String>> funToken = new TypeToken<Function<Integer, String>>() {};

        TypeToken<?> funResultToken = funToken.resolveType(Function.class.getTypeParameters()[1]);
        // returns a TypeToken<String>
        System.out.println(funResultToken.getType());

        TypeToken<Map<String, Integer>> mapToken = new TypeToken<Map<String, Integer>>() {};
        try {
            TypeToken<?> entrySetToken = mapToken.resolveType(Map.class.getMethod("entrySet").getGenericReturnType());
            // returns a TypeToken<Set<Map.Entry<String, Integer>>>
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
