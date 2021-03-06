package fr.dawan.sitecritiqueprojet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.sitecritiqueprojet.beans.Commentary;
import fr.dawan.sitecritiqueprojet.dto.CommentaryDto;
import fr.dawan.sitecritiqueprojet.services.CommentaryService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/comments")
public class CommentaryController {

	@Autowired
	private CommentaryService commentaryService;

	@GetMapping(value = "/commentary/{id}", produces = "application/json")
	public CommentaryDto getCommentary(@PathVariable("id") long id) {
		return commentaryService.findById(id);
	}

	@GetMapping(value = "/user/{id}" , produces = "application/json")
	public List<CommentaryDto> getCommentsByUserId(@PathVariable("id") long id){
		return commentaryService.findCommentaryByUserId(id);
	}
	
	@GetMapping(value = "/review/{id}", produces = "application/json")
	public List<CommentaryDto> getCommentsByReviewId(@PathVariable("id") long id){
		return commentaryService.findCommentaryByReviewId(id);
	}
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	public Commentary createCommentary(@RequestBody Commentary c) {
		return commentaryService.saveOrUpdate(c);
	}
	@PutMapping(consumes = "application/json", produces = "application/json")
	public Commentary updateCommentary(@RequestBody Commentary c) {
		return commentaryService.saveOrUpdate(c);
	}
	@DeleteMapping(value = "/commentary/{id}", produces = "text/plain")
	public String deleteReviewById(@PathVariable("id") long id) {
		try {
			commentaryService.deleteById(id);
			return "Suppr ok";
		}catch(Exception e) {
			e.printStackTrace();
			return "Erreur : " + e.getMessage();
		}
	}
}
