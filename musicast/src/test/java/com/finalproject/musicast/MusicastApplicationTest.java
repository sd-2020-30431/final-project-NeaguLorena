package com.finalproject.musicast;

import com.finalproject.musicast.Data.Repository.PlaylistRepository;
import com.finalproject.musicast.Data.Repository.SongRepository;
import com.finalproject.musicast.Data.Repository.UserRepository;
import com.finalproject.musicast.Presentation.Model.Playlist;
import com.finalproject.musicast.Presentation.Model.Song;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WastelessApplicationTests {

    @Autowired
    private PlaylistRepository playlistRepository;
    @Autowired
    private SongRepository songRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("Create Playlist Test ")
    void createListTest() {

        Playlist created = playlistRepository.save(getList());

        Assertions.assertTrue(created != null);
    }

    private Playlist getList() {

        Playlist list = new Playlist("user", "summer playlist");

        return list;
    }

    @Test
    @DisplayName("Create Song Test ")
    void createSongTest() {

        Song created = songRepository.save(getSong());

        Assertions.assertTrue(created != null);
    }

    private Song getSong() {

        Song song = new Song("user", "Animals", "Martin Garrix", "EDM");

        return song;
    }
}
