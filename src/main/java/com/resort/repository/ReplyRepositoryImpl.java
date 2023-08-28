package com.resort.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.resort.domain.Reply;
import com.resort.mapper.ReplyMapper;
import com.resort.repository.Repository.ReplyRepository;

@Repository
public class ReplyRepositoryImpl implements ReplyRepository {

	@Autowired
	private ReplyMapper replyMapper;
	
	private List<Reply> listOfReply;
	
	// Create
		@Override
		public void createOneReply(Reply reply) {
			replyMapper.createOneReply(reply);
		}
		
	// Read
		@Override
		public List<Reply> readAllReply(int rootId) {
			listOfReply = replyMapper.readAllReply(rootId);
			return listOfReply;
		}

	// Delete
		@Override
		public void deleteOneReply(int replyId) {
			replyMapper.deleteOneReply(replyId);
		}

		@Override
		public void deleteAllReply(int rootId) {
			replyMapper.deleteAllReply(rootId);
		}

	

}
