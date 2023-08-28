package com.resort.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resort.domain.Reply;
import com.resort.repository.Repository;
import com.resort.service.Service.ReplyService;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private Repository.ReplyRepository replyRepository;
	
	// Create
		@Override
		public void createOneReply(Reply reply) {
			replyRepository.createOneReply(reply);
		}
	
	// Read
		@Override
		public List<Reply> readAllReply(int rootId) {
			return replyRepository.readAllReply(rootId);
		}
		
	// Delete
		@Override
		public void deleteOneReply(int replyId) {
			replyRepository.deleteOneReply(replyId);
		}

		@Override
		public void deleteAllReply(int rootId) {
			replyRepository.deleteAllReply(rootId);
		}

	

}
