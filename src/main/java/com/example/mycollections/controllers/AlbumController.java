package com.example.mycollections.controllers;

import com.example.mycollections.models.Album;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {
    private final List<Album> albums = new ArrayList<>() {{
        add(new Album("B-Day", "Beyonce", 2006, 11));
        add(new Album("The Emancipation of Mimi", "Mariah Carey", 2005, 14));
        add(new Album("Songs in the Key of Life", "Stevie Wonder", 1976, 21));
    }};

    @GetMapping("/json")
    public List<Album> getAlbumsJson(){
        return albums;
    }

    @GetMapping("/html")
    public String getAlbumsHtml(){
        String albumList = "<ul>";
        for (Album album : albums) {
            albumList += "<li>" + album + "</li>";
        }
        albumList += "</ul>";

        return """
                <html>
                    <body>
                        <h1>Albums</h1>
                        <ul>
                """ +
                albumList +
                """
                        </ul>
                    </body>
                """;
    }
}
