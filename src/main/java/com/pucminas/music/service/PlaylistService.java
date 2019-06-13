package com.pucminas.music.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pucminas.music.entity.Playlist;
import com.pucminas.music.repository.PlaylistRepository;

@Service
public class PlaylistService {
	
	@Autowired
	private PlaylistRepository playlistRepository;
	
	public List<Playlist> findAll(){
		return playlistRepository.findAll();
	}
	
	public Optional<Playlist> find(Long id){
		Optional<Playlist> playlist = playlistRepository.findById(id);
		
		if (playlist == null) {
			try {
				throw new Exception("A playlist não pôde ser encontrada.");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		}
		return playlist;		
	}

	public Playlist save(Playlist playlist) {
		playlist.setId(null);
		return playlistRepository.save(playlist);		
	}	
	
	public void deletar(Long id) {
		try {
			playlistRepository.deleteById(id);
		}catch(Exception e) {
			try {
				throw new Exception("A playlist não pôde ser deletada.");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		}		
	}
}
