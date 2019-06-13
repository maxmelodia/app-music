package com.pucminas.music.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pucminas.music.entity.Music;
import com.pucminas.music.repository.MusicRepository;

@Service
public class MusicService {
	
	@Autowired
	private MusicRepository musicRepository;
	
	public List<Music> findAll(){
		return musicRepository.findAll();
	}
	
	public Optional<Music> find(Long id) {
		Optional<Music> music = musicRepository.findById(id);		
		
		if (music == null) {
			try {
				throw new Exception("A música não pôde ser encontrada.");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		}
		return music;
	}
	
	public Music save(Music music) {
		music.setId(null);
		return musicRepository.save(music);
	}
	
	public void deletar(Long id) {
		try {
			musicRepository.deleteById(id);
		}catch(Exception e) {
			try {
				throw new Exception("A música não pôde ser deletada.");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		}
	}
}
