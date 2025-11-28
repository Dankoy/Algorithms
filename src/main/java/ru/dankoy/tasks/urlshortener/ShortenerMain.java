package ru.dankoy.tasks.urlshortener;

import java.net.MalformedURLException;
import java.net.URI;
import java.sql.SQLException;

public class ShortenerMain {

    public static void main(String[] args) throws MalformedURLException, SQLException {

        var uri = "https://my.hello.word/path1/path2?asd=ffg";
        var url = URI.create(uri).toURL();

        UrlShortener urlShortener = new UrlShortenerImpl();

        var shortUrl = urlShortener.shortUrl(url);

        var longUrl = urlShortener.unshortUrl(shortUrl);

        var checkCache = urlShortener.shortUrl(url);

        System.out.println(shortUrl);
        System.out.println(longUrl);

        System.out.println(checkCache);

    }

}
