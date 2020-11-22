package rybas.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

public class SerializeService<T> {
    //TODO: кто ходит, FxService
    public String serialize(T element) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(element);
    }

    public T deserialize(String json, T instanceOfClass) {
        Gson gson = new Gson();
        return gson.fromJson(json, (Type) instanceOfClass.getClass());
    }
}
