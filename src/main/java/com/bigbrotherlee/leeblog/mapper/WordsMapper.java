package com.bigbrotherlee.leeblog.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import com.bigbrotherlee.leeblog.domain.entity.Words;

public interface WordsMapper {
	@Insert("insert into words values(null,#{wordsContent},#{wordsCreateDate},#{user.userId})")
	public void create(Words words);
	@Delete("delete from words where wordsId=#{wordsId}")
	public void delete(String wordsId);
	@Results(id="wordsMap",value=@Result(column="wordsAuthor",property="user" ,one =@One(fetchType=FetchType.DEFAULT,select="com.bigbrotherlee.leeblog.mapper.UserMapper.findById")))
	@Select("select * from words where  wordsId=#{wordsId}")
	public Words findById(String wordsId);
	@ResultMap("wordsMap")
	@Select("select * from words where  wordsContent like #{key}")
	public List<Words> findWordsByKey(String key);
	@ResultMap("wordsMap")
	@Select("select * from words where wordsAuthor=#{userId}")
	public List<Words> findWordsByAuthor(String userId);
	
}
