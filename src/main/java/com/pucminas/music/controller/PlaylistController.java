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

import com.pucminas.music.entity.Playlist;
import com.pucminas.music.service.PlaylistService;

@RestController
@RequestMapping("/v1/app/playlists")
public class PlaylistController {
	
	@Autowired
	private PlaylistService playlistService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Playlist>> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(playlistService.findAll());
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findOne(@PathVariable("id") Long id){
		Optional<Playlist> playlist = playlistService.find(id);
		CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);		
		return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(playlist);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody Playlist playlist){
		playlist = playlistService.save(playlist);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				  path("/{id}").buildAndExpand(playlist.getId()).toUri();
		
		return ResponseEntity.created(uri).build();

	}

}
