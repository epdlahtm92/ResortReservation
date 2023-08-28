package com.resort.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.resort.domain.Reply;

@Mapper
public interface ReplyMapper {
	
	// Create
		void createOneReply(@Param("Reply") Reply reply);
		
	// Read
		List<Reply> readAllReply(@Param("rootId") int rootId);
	
	// Delete
		void deleteOneReply(@Param("replyId") int replyId);
		
		void deleteAllReply(@Param("rootId") int rootId);
}
