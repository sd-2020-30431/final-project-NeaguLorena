package com.finalproject.musicast.Bussiness.Service;

import com.finalproject.musicast.Presentation.Model.Song;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaylistGeneratorService {

    public static List<Song> playlistGenerate(List<Song> allSongs, String forecast) {
        List<Song> songs = new ArrayList<>();

        if (forecast.compareTo("sunny") == 0) {
            for (Song song : allSongs) {
                if (song.getGenre().compareTo("EDM") == 0) {
                    songs.add(song);
                }
            }
        } else if (forecast.compareTo("rainy") == 0) {
            for (Song song : allSongs) {
                if (song.getGenre().compareTo("rock") == 0) {
                    songs.add(song);
                }
            }
        }

        return songs;
    }
}