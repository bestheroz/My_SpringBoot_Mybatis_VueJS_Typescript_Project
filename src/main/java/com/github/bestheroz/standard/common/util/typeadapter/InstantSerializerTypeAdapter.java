package com.github.bestheroz.standard.common.util.typeadapter;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.time.Instant;

public class InstantSerializerTypeAdapter implements JsonSerializer<Instant> {
    @Override
    public JsonElement serialize(final Instant instant, final Type typeOfSrc, final JsonSerializationContext context) {
        return new JsonPrimitive(instant.toEpochMilli());
    }
}
