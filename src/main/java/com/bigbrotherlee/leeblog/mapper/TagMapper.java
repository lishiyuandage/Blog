package com.bigbrotherlee.leeblog.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.FetchType;
import com.bigbrotherlee.leeblog.domain.entity.Tag;

public interface TagMapper {
	@Results(id="tagArticle",value= {@Result(property="articles",many=@Many(fetchType=FetchType.DEFAULT,select="com.bigbrotherlee.leeblog.mapper.ArticleMapper.findByTagId"),column="tagId")})
	@Select("select * from tag where tagId=#{tagId}")
	public Tag findTagById(String tagId);
	
	@Select("select t.* from tag t,tagtemp tt where tt.articleId=#{articleId} and t.tagId=tt.tagId")
	public List<Tag> findTagByArticleId(String articleId);
	
	@Insert("insert into tag values(null,#{tagName},#{tagDetails})")
	@SelectKey(before=false,keyProperty="tagId",resultType=Integer.class,statement="SELECT LAST_INSERT_ID() AS ID")
	public void create(Tag tag);
	
	@Update("<script>"+
			"update tag " + 
			"		<set>" + 
			"			<if test='tagName!=null'>tagName=#{tagName},</if>" + 
			"			<if test='tagDetails!=null'>tagDetails=#{tagDetails},</if>" + 
			"		</set>" + 
			" where tagId=#{tagId}"+ 
			"</script>")
	public void update(Tag tag);
	
	@Delete("delete from tag where tagId=#{tagId}")
	public void delete(String tagId);
	
	@Select("select * from tag")
	public List<Tag> findAll();
	
	@Select("select * from tag where tagName=#{tagName}")
	public Tag findByName(String tagName);
	
	@Select("select * from tag where tagName like #{key}  or tagDetails like #{key}")
	public List<Tag> findByKey(String key);
	
}
