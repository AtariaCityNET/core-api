package de.lukas.coreapi.utils.sql;

public interface Callback<T> {
    void onSucces(T done);
}
