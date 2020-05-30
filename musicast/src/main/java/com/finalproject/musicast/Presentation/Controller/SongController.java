package com.finalproject.musicast.Presentation.Controller;

import com.finalproject.musicast.Data.Repository.SongRepository;
import com.finalproject.musicast.Presentation.Model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
public class SongController {

    @Autowired
    SongRepository songRepository;

    @PostMapping("/playlists/{playlistId}")
    public String createSong(@Valid Song song, Principal principal){
        songRepository.save(song);
        return "redirect:/playlists/{playlistId}";
    }

    @GetMapping("/all-songs")
    public String getAllSongs(Principal principal, Model model){
        List<Song> songs = songRepository.findAllByUsername(principal.getName());
        model.addAttribute("all_songs", songs);
        return "songs";
    }

    @GetMapping("/playlists/{playlistId}")
    public String getAllSongsFromPlaylist(@PathVariable int playlistId, Principal principal, Model model){
        List<Song> playlist_songs = songRepository.findAllByPlaylistId(playlistId);
        model.addAttribute("playlist_songs", playlist_songs);
        return "songs";
    }

}
