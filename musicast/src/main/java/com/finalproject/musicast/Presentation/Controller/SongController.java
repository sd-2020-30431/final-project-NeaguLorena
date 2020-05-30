package com.finalproject.musicast.Presentation.Controller;

import com.finalproject.musicast.Bussiness.Service.PlaylistGeneratorService;
import com.finalproject.musicast.Bussiness.Service.WeatherService;
import com.finalproject.musicast.Data.Repository.SongRepository;
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
public class SongController {

    @Autowired
    SongRepository songRepository;
    PlaylistGeneratorService playlistGeneratorService;
    WeatherService weatherService;
    Weather weather;


    public SongController(PlaylistGeneratorService playlistGeneratorService, WeatherService weatherService ) {
        this.playlistGeneratorService = playlistGeneratorService;
        this.weatherService = weatherService;
        this.weather = new Weather();
    }

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

    @GetMapping("/generate-playlist-weather")
    public String generatePlaylistByWeather(Principal principal, Model model) throws IOException {
        List<Song> songs = songRepository.findAllByUsername(principal.getName());
        weatherService.getTemperatureAPI(this.weather);
        List<Song> playlist = playlistGeneratorService.playlistGenerate(songs,this.weather.getForecast());
        model.addAttribute("moodPlaylist", playlist);
        model.addAttribute("temperature", weather.getTemperature());
        return "index";
    }
}
