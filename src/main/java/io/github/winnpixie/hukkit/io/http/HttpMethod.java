package io.github.winnpixie.hukkit.io.http;

import io.github.winnpixie.hukkit.io.IOHelper;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.function.Consumer;

public class HttpMethod {
    private final String verb;
    private final Consumer<HttpRequest> sendFunction;

    public static final HttpMethod GET = new HttpMethod("GET", request -> {
        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) request.getUrl().openConnection(request.getProxy());
            conn.setRequestMethod(request.getMethod().getVerb());
            conn.setInstanceFollowRedirects(request.isFollowRedirects());

            request.getHeaders().forEach(conn::setRequestProperty);

            try (InputStream is = conn.getInputStream()) {
                request.getOnSuccess().accept(new HttpResponse(request, conn.getResponseCode(), conn.getResponseMessage(),
                        IOHelper.readFully(is), conn.getHeaderFields()));
            }
        } catch (Exception e) {
            request.getOnFailure().accept(e);
        } finally {
            if (conn != null) conn.disconnect();
        }
    });
    public static final HttpMethod POST = new HttpMethod("GET", request -> {
        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) request.getUrl().openConnection(request.getProxy());
            conn.setRequestMethod(request.getMethod().getVerb());
            conn.setDoOutput(true);
            conn.setInstanceFollowRedirects(request.isFollowRedirects());

            request.getHeaders().forEach(conn::setRequestProperty);

            conn.setRequestProperty("Content-Length", String.valueOf(request.getBody().length));
            try (OutputStream os = conn.getOutputStream()) {
                os.write(request.getBody());
            }

            try (InputStream is = conn.getInputStream()) {
                request.getOnSuccess().accept(new HttpResponse(request, conn.getResponseCode(), conn.getResponseMessage(),
                        IOHelper.readFully(is), conn.getHeaderFields()));
            }
        } catch (Exception e) {
            request.getOnFailure().accept(e);
        } finally {
            if (conn != null) conn.disconnect();
        }
    });

    public HttpMethod(String verb, Consumer<HttpRequest> sendFunction) {
        this.verb = verb;
        this.sendFunction = sendFunction;
    }

    public String getVerb() {
        return verb;
    }

    public Consumer<HttpRequest> getSendFunction() {
        return sendFunction;
    }

    public static HttpMethod custom(String verb, Consumer<HttpRequest> onSend) {
        return new HttpMethod(verb, onSend);
    }

    public static HttpMethod getByVerb(String verb) {
        switch (verb) {
            case "GET":
                return GET;
            case "POST":
                return POST;
        }

        return null;
    }
}
