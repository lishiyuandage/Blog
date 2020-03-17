package com.bigbrotherlee.leeblog.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface TagTempMapper {
	@Insert("insert into tagtemp values(#{tagId},#{articleId})")
	public void insert(@Param("tagId") Integer tagId,@Param("articleId") Integer articleId);
	
	@Delete("delete from tagtemp where tagId=#{tagId} and articleId=#{articleId}")
	public void delete(@Param("tagId") Integer tagId,@Param("articleId") Integer articleId) ;
}
