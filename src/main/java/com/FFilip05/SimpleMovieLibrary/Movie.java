package com.FFilip05.SimpleMovieLibrary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    private int id;
    private int length;
    private int rating;
    private String title;
}
