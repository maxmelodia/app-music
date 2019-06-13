package com.pucminas.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pucminas.music.entity.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

}
