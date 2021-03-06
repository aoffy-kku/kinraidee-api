package kinraidee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kinraidee.model.Comment;
import kinraidee.model.CommentRepository;
import kinraidee.model.Follow;

@CrossOrigin(origins = "*" ,maxAge = 3600)
@RestController
public class CommentController {
	@Autowired
	private CommentRepository commentRepository;

	// insert comment
	@PostMapping("/comment")
	public Comment createComment(@RequestBody Comment comment) {
		return commentRepository.insert(comment);
	}

	// Show all comment
	@GetMapping("/comment")
	public List<Comment> getCommentList() {
		List<Comment> commentList = commentRepository.findAll();
		return commentList;
	}

	// search by comment_id
	@GetMapping("/comment/{id}")
	public Comment getCommentById(@PathVariable Integer id) {
		Comment comment = commentRepository.findById(id);
		return comment;
	}

	// update comment
	@PutMapping("/comment/{id}")
	public Comment updateComment(@PathVariable Integer id, @RequestBody Comment comment) {
		Comment newComment = commentRepository.update(id, comment);
		return newComment;
	}

	// delete comment
	@DeleteMapping("/comment/{id}")
	public void deleteComment(@PathVariable Integer id) {
		commentRepository.delete(id);
	}

}
