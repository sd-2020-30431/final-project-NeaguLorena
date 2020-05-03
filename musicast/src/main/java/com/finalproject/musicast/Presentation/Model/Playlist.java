package com.finalproject.musicast.Presentation.Model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "PLAYLIST")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int playlistId;
    private String username;
    private String name;
    @Transient
    private List<Song> songs;

    public Playlist(String username, String name, List<Song> songs) {
        this.username = username;
        this.name = name;
        this.songs = songs;
    }

    public Playlist(String username, String name) {
        this.username = username;
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public Playlist() {
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

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
