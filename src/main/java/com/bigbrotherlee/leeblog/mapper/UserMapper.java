package com.bigbrotherlee.leeblog.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.bigbrotherlee.leeblog.domain.entity.RealUser;

public interface UserMapper {
	
//	@Results(id="userMap",value=@Result(column="userId",property="articles",many=@Many(fetchType=FetchType.LAZY,select="com.bigbrotherlee.leeblog.mapper.ArticleMapper.findByUserId")))
	@Select("select * from realuser where userId=#{userId}")
	public RealUser findById(String userId );
	
	@Select("<script>select * from realuser "
			+ "<where>"
			+ "	<if test='userCode!=null'>and userCode=#{userCode}</if>"
			+ "	<if test='userName!=null'>and userName=#{userName}</if>"
			+ "	<if test='userSex!=null'>and userSex=#{userSex}</if>"
			+ "	<if test='userEmail!=null'>and userEmail=#{userEmail}</if>"
			+ "</where>"
			+ "</script>")
	public RealUser findUserByUser(RealUser user);
	
	@Insert("insert into realuser values(null,#{userCode},#{userName},#{userPassword},#{userSex},#{userEmail})")
	@Options(useGeneratedKeys = true, keyProperty = "userId") 
	public void createUser(RealUser user);
	
	@Update("<script>"+
			"update realuser " + 
			"		<set>" + 
			"			<if test='userName!=null'>userName=#{userName},</if>" + 
			"			<if test='userPassword!=null'>userPassword=#{userPassword},</if>" + 
			"			<if test='userSex!=null'>userSex=#{userSex},</if>" + 
			"			<if test='userEmail!=null'>userEmail=#{userEmail},</if>" + 
			"		</set>" + 
			" where userId=#{userId}"+ 
			"</script>")
	public void updateUser(RealUser user);
	
	@Delete("delete from realuser where userId=#{userId}")
	public void deleteUser(String userId);
	
	@Select("<script>"+
				"select * from realuser "+
				"<where>"+ 
					"<if test='userCode!=null'>and userCode like '%${userCode}%'</if>"+
					"<if test='userName!=null'>and userName like '%${userName}%'</if>"+
					"<if test='userEmail!=null'>and userEmail like '%${userEmail}%'</if>"+
					"<if test='userSex!=null'><if test='userSex==true'>and userSex like '%${1}%'</if><if test='userSex==false'>and userSex like '%${0}%'</if></if>"+
				"</where>"+
			"</script>")
	public List<RealUser> searchUserByUser(RealUser user);
	@Select("select * from realuser where userCode like #{key}  or userName like #{key}  or userEmail like #{key}  or userSex like #{key}")
	public List<RealUser> searchUserByKey(String key);
}
