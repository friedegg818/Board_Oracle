package com.sp.bbs;

import java.util.List;
import java.util.Map;

public interface BoardService {
	public void insertBoard(Board dto, String pathname) throws Exception;
	public List<Board> listBoard(Map<String, Object> map);
	public int dataCount(Map<String, Object> map);
	public Board readBoard(int num);
	public void updateHitCount(int num) throws Exception;
	public Board preReadBoard(Map<String, Object> map);
	public Board nextReadBoard(Map<String, Object> map);
	public void updateBoard(Board dto, String pathname) throws Exception;
	public void deleteBoard(int num, String pathname, String userId) throws Exception;
	
	
	public void insertBoardLike(Map<String, Object> map) throws Exception; 	// 게시글 좋아요 등록
	public int boardLikeCount(int num);		// 게시글 좋아요 개수 계산 
	
	public void insertReply(Reply dto) throws Exception;
	public List<Reply> listReply(Map<String, Object> map);
	public int replyCount(Map<String, Object> map); 		
	public void deleteReply(Map<String, Object> map) throws Exception;
	
	public List<Reply> listReplyAnswer(int answer);		// 답글 리스트
	public int replyAnswerCount(int answer);			// 답글 개수 
	
	public void insertReplyLike(Map<String, Object> map) throws Exception;		// 댓글 좋아요 추가
	public Map<String, Object> replyLikeCount(Map<String, Object> map);			// 댓글 좋아요, 싫어요 개수 
}
