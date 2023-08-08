package io.github.winnpixie.hukkit.io.http;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class HttpResponse {
    private final HttpRequest request;
    private final int statusCode;
    private final String statusMessage;
    private final byte[] body;
    private final Map<String, List<String>> headers;

    public HttpResponse(HttpRequest request, int statusCode, String statusMessage, byte[] body, Map<String, List<String>> headers) {
        this.request = request;
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.body = body;
        this.headers = headers;
    }

    public HttpRequest getRequest() {
        return request;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public Map<String, List<String>> getHeaders() {
        return headers;
    }

    public byte[] getBody() {
        return body;
    }

    public String getBodyAsString(Charset charset) {
        return new String(body, charset);
    }

    public String getBodyAsString() {
        return getBodyAsString(StandardCharsets.UTF_8);
    }
}
