package com.os.operando.stardust;

import com.squareup.okhttp.*;

import java.io.IOException;
import java.net.URI;

public class Stardust {

    public static void getChannelsList(String token, Callback callback) {
        Request request = createRequest("https://slack.com/api/channels.list", token);
        OkHttpClient client = new OkHttpClient();
        client.newCall(request).enqueue(callback);
    }

    public static String getChannelsList(String token) throws IOException {
        Request request = createRequest("https://slack.com/api/channels.list", token);
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public static void getUsersList(String token, Callback callback) throws IOException {
        Request request = createRequest("https://slack.com/api/users.list", token);
        OkHttpClient client = new OkHttpClient();
        client.newCall(request).enqueue(callback);
    }

    public static String getUsersList(String token) throws IOException {
        Request request = createRequest("https://slack.com/api/users.list", token);
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    private static Request createRequest(String url, String token) {
        HttpUrl httpUrl = HttpUrl.get(URI.create(url))
                .newBuilder()
                .addQueryParameter("token", token)
                .build();
        return new Request.Builder()
                .url(httpUrl)
                .build();
    }
}
