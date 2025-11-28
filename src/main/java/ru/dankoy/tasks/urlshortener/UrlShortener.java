package ru.dankoy.tasks.urlshortener;

import java.net.URL;
import java.sql.SQLException;

public abstract interface UrlShortener {

    String shortUrl(URL url) throws SQLException;

    URL unshortUrl(String shortUrl);

}
