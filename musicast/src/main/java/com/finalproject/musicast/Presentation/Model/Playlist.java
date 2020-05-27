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

    public Playlist(String username, String name, List<Song> songs) {
        this.username = username;
        this.name = name;
    }

    public Playlist(String username, String name) {
        this.username = username;
        this.name = name;
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

}
