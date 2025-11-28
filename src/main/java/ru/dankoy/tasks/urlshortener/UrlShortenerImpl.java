package ru.dankoy.tasks.urlshortener;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UrlShortenerImpl implements UrlShortener {

    private final Map<String, String> cache = new HashMap<>();

    @Override
    public String shortUrl(URL url) throws SQLException {

        try {
            var uri = url.toURI();
            var uriString = uri.toString();
            var uriStringHash = uriString.hashCode();

            var presentShortUrl = cache.get(String.valueOf(uriStringHash));

            if (presentShortUrl == null) {

                var hash = String.valueOf(uriString.hashCode());

                var sb = new StringBuilder();
                sb.append(uri.getScheme())
                        .append("://")
                        .append(uri.getHost())
                        .append("/")
                        .append(hash);

                var shortUrl = URI.create(sb.toString()).toString();

                cache.put(hash, uriString);
                return shortUrl;

            }

            return presentShortUrl;

        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }

    }

    @Override
    public URL unshortUrl(String shortUrl) {

        var uri = URI.create(shortUrl);
        var hashCode = uri.getPath().substring(1);

        var longUriString = cache.get(hashCode);

        if (longUriString == null) {
            throw new IllegalArgumentException("Short uri is not present in system.");
        }

        try {
            return URI.create(longUriString).toURL();
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(longUriString, e);
        }

    }

}
