package com.FFilip05.SimpleMovieLibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Movie> getAllMovies(){
//        System.out.println(jdbcTemplate.query("SELECT * FROM movie", BeanPropertyRowMapper.newInstance(Movie.class)));
        return jdbcTemplate.query("SELECT * FROM movie", BeanPropertyRowMapper.newInstance(Movie.class));
    }

    public Movie getMovieById(int id){
        return jdbcTemplate.queryForObject("SELECT * FROM movie WHERE " + "id = ?", BeanPropertyRowMapper.newInstance(Movie.class),id);
    }

    public int saveMovie(List<Movie> movies) {
        movies.forEach(movie -> jdbcTemplate
                .update("INSERT INTO movie(title,length,rating) VALUES (?,?,?)",movie.getTitle(), movie.getTitle(),movie.getRating()
                ));
        return 1;
    }

    public int updateMovie(Movie movie){
        return jdbcTemplate.update("UPDATE movie SET title = ?, length = ?, rating = ? WHERE id = ?",movie.getTitle(),movie.getLength(),movie.getRating(),movie.getId());
    }

    public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM movie WHERE id = ?",id);
    }
}
