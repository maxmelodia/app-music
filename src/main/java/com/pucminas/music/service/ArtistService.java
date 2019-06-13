package com.pucminas.music.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pucminas.music.entity.Artist;
import com.pucminas.music.repository.ArtistRepository;

@Service
public class ArtistService {

	@Autowired
	private ArtistRepository artistRepository;
	
	public List<Artist> findAll(){
		return artistRepository.findAll();
	}
	
	public Optional<Artist> find(Long id){
		Optional<Artist> artist = artistRepository.findById(id);
		
		if (artist == null) {
			try {
				throw new Exception("A música não pôde ser encontrada.");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		}
		return artist;		
	}
	
	public Artist save(Artist artist) {
		artist.setId(null);
		return artistRepository.save(artist);
	}
	
	public void deletar(Long id) {
		try {
			artistRepository.deleteById(id);
		}catch(Exception e) {
			try {
				throw new Exception("O artista não pôde ser deletado.");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 		
		}
	}
}
