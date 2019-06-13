package com.pucminas.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pucminas.music.entity.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist, Long>{

}
