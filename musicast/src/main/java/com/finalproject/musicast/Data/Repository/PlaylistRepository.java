package com.finalproject.musicast.Data.Repository;

import com.finalproject.musicast.Presentation.Model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {
    List<Playlist> getAllByUsername(String username);
}
