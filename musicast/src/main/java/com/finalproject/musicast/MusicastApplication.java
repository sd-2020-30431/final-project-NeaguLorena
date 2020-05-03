package com.finalproject.musicast;

import com.finalproject.musicast.Data.Repository.PlaylistRepository;
import com.finalproject.musicast.Data.Repository.SongRepository;
import com.finalproject.musicast.Data.Repository.UserRepository;
import com.finalproject.musicast.Presentation.Model.Playlist;
import com.finalproject.musicast.Presentation.Model.Song;
import com.finalproject.musicast.Presentation.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
@EnableJpaRepositories
public class MusicastApplication {

    @Autowired
    private PlaylistRepository playlistRepository;
    @Autowired
    private SongRepository songRepository;
    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(MusicastApplication.class, args);
    }

    @PostConstruct
    public void initDb() throws ParseException {

        User user = new User("user", "pass");
        userRepository.save(user);

        Playlist list = new Playlist("user", "summer playlist");
        playlistRepository.save(list);

        Song Song = new Song("user", "Animals", "Martin Garrix", "EDM");

        Song Song2 = new Song("user", "Paradise", "Coldplay", "rock");

        Song Song3 = new Song("user", "Crazy", "Aerosmith", "rock");

        songRepository.save(Song);
        songRepository.save(Song2);
        songRepository.save(Song3);
    }
}
