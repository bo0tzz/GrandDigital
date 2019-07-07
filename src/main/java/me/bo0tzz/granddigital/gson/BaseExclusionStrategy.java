package me.bo0tzz.granddigital.gson;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

import java.util.ArrayList;
import java.util.List;

public class BaseExclusionStrategy implements ExclusionStrategy {

    final List<String> wantedFields;

    public BaseExclusionStrategy() {
        wantedFields = new ArrayList<>();
        wantedFields.add("title");
        wantedFields.add("url");
        wantedFields.add("products");
    }


    @Override
    public boolean shouldSkipField(FieldAttributes f) {
        return !wantedFields.contains(f.getName());
    }

    @Override
    public boolean shouldSkipClass(Class<?> clazz) {
        return false;
    }
}
