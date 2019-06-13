package com.pucminas.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pucminas.music.entity.Music;

public interface MusicRepository extends JpaRepository<Music, Long> {
}
