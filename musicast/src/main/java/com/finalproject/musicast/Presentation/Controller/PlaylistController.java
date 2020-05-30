package com.finalproject.musicast.Presentation.Controller;

import com.finalproject.musicast.Data.Repository.PlaylistRepository;
import com.finalproject.musicast.Data.Repository.SongRepository;
import com.finalproject.musicast.Presentation.Model.Playlist;
import com.finalproject.musicast.Presentation.Model.Song;
import com.finalproject.musicast.Presentation.Model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Controller
public class PlaylistController {
    @Autowired
    PlaylistRepository playlistRepository;
    @Autowired
    SongRepository songRepository;

    @PostMapping("/playlists")
    public String createPlaylist(@Valid Playlist playlist, Principal principal){
        playlist.setUsername(principal.getName());
        playlistRepository.save(playlist);
        return "redirect:/playlists";
    }

    @GetMapping("/playlists")
    public String getAllPlaylists(Principal principal, Model model) throws IOException {
        List<Playlist> playlists = playlistRepository.getAllByUsername(principal.getName());
        model.addAttribute("temperature", Weather.getTemperatureAPI());
        model.addAttribute("playlists", playlists);
        return "index";
    }

}
