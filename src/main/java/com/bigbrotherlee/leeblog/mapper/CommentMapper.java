package com.bigbrotherlee.leeblog.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import com.bigbrotherlee.leeblog.domain.entity.Comment;

public interface CommentMapper {

	@Select("select * from comment where commentArticle=#{artcle.articleId}")
	public List<Comment> find(Integer articleId);
	@Insert("insert into comment values(null,#{commentContent},#{commentCreateDate},#{commentHide},#{commentOtherEmail},#{commentOtherName},#{commentOtherConnect},#{commentArticle})")
	public void create(Comment comment);
	
	@Delete("delete from comment where commentId=#{commentId}")
	public void delete(Integer commentId);
}
