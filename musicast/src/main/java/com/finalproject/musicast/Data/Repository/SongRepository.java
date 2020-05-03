package com.finalproject.musicast.Data.Repository;

import com.finalproject.musicast.Presentation.Model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer> {

    List<Song> findAllBySongId(int songId);

    Song findItemBySongId(int songId);

}
