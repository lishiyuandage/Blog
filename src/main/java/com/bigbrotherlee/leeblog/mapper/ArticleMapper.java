package com.bigbrotherlee.leeblog.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.FetchType;
import com.bigbrotherlee.leeblog.domain.entity.Article;


public interface ArticleMapper {
	@Results(id="articleMap",value={
			@Result(property="articleId",column="articleId"),
			@Result(property="small",column="articleSmall",one=@One(fetchType=FetchType.DEFAULT,select="com.bigbrotherlee.leeblog.mapper.ClassifySmallMapper.findById")),
			@Result(property="user" ,column="articleAuthor",one=@One(fetchType=FetchType.DEFAULT,select="com.bigbrotherlee.leeblog.mapper.UserMapper.findById")),
			@Result(property="tags" ,column="articleId",many=@Many(fetchType=FetchType.DEFAULT,select="com.bigbrotherlee.leeblog.mapper.TagMapper.findTagByArticleId")),
			@Result(property="comments" ,column="articleId",many=@Many(fetchType=FetchType.DEFAULT,select="com.bigbrotherlee.leeblog.mapper.CommentMapper.find"))
			})
	@Select("select * from article where articleId=#{articleId}")
	public Article findById(Integer articleId);
	
	@ResultMap("articleMap")
	@Select("select a.* from article a,tagTemp t where t.tagId=#{tagId} and a.articleId=t.articleId")
	public List<Article> findByTagId(String tagId);
	@Insert("insert into article values(null,#{articleTitle},#{articleContent},#{small.smallId},#{articleCreateDate},#{articleHide},#{articleClose},0,#{user.userId},#{articleImage})")
	@Options(useGeneratedKeys = true, keyProperty = "articleId") 
	public void createArticle(Article article);
	@Update("<script>"+
			"update article " + 
			"		<set>" + 
			"			<if test='articleTitle!=null'>articleTitle=#{articleTitle},</if>" + 
			"			<if test='articleContent!=null'>articleContent=#{articleContent},</if>" + 
//			"			<if test='small.smallId!=null'>articleSmall=#{small.smallId},</if>" + 
			"			<if test='articleHide!=null'>articleHide=#{articleHide},</if>" + 
			"			<if test='articleClose!=null'>articleClose=#{articleClose},</if>" + 
			"			<if test='articleSee!=null'>articleSee=#{articleSee},</if>" + 
			"			<if test='articleImage!=null'>articleImage=#{articleImage},</if>" + 
//			"			<if test='user.userId!=null'>articleAuthor=#{user.userId},</if>" + 
			"		</set>" + 
			" where articleId=#{articleId}"+ 
			"</script>")
	public void updateArticle(Article article);
	
	@Delete("delete from article where articleId=#{articleId}")
	public void deleteArricle(Integer articleId);
	
	@ResultMap("articleMap")
	@Select("<script>"+
				"select * from article "+
					"<where>"+ 
						"<if test='articleTitle!=null'>and articleTitle like '%${articleTitle}%'</if>"+
						"<if test='articleContent!=null'>and articleContent like '%${articleContent}%'</if>"+
					"</where>"+
			"</script>")
	public List<Article> searchByArticle(Article article);
	
	@ResultMap("articleMap")
	@Select("select * from article where articleTitle like #{key}")
	public List<Article> searchByKey(String key);
	
	@ResultMap("articleMap")
	@Select("select * from article where articleSmall=#{smallId}")
	public List<Article> findBySmallId(String smallId);
	
	@ResultMap("articleMap")
	@Select("select * from article where articleAuthor=#{userId}")
	public List<Article> findByUserId(String userId);
}
