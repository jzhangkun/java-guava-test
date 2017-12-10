package com.kun.guava.reflection;

import com.google.common.reflect.TypeToken;

abstract class IKnowType<T> {
    TypeToken<T> type = new TypeToken<T>(getClass()){};
}
