package com.pucminas.music.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pucminas.music.entity.Music;
import com.pucminas.music.service.MusicService;

@RestController
@RequestMapping("/v1/app/musics")
public class MusicController {

	@Autowired
	private MusicService musicService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Music>> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(musicService.findAll());
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findOne(@PathVariable("id") Long id){
		Optional<Music> music = musicService.find(id);
		CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);		
		return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(music);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody Music music){
		music = musicService.save(music);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				  path("/{id}").buildAndExpand(music.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
}
