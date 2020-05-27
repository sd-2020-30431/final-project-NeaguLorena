package com.finalproject.musicast.Presentation.Model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name = "SONG")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int songId;
    private int playlistId;
    private String username;
    private String name;
    private String artist;
    private String genre;

    public Song(String username, String name, String artist, String genre) {
        this.username = username;
        this.name = name;
        this.artist = artist;
        this.genre = genre;
    }

    public Song(int playlistId, String username, @NotNull String name, @NotNull String artist, String genre) {
        this.playlistId = playlistId;
        this.username = username;
        this.name = name;
        this.artist = artist;
        this.genre = genre;
    }

    public Song() {
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
