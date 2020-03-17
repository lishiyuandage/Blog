package com.bigbrotherlee.leeblog.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.bigbrotherlee.leeblog.domain.entity.ClassificationSmall;

public interface ClassifySmallMapper {
	@Results(id="big",value= {@Result(property="big",column="bigId",one=@One(select="com.bigbrotherlee.leeblog.mapper.ClassifyBigMapper.findById"))})
	@Select("select * from classificationSmall where smallId=#{smallId}")
	public ClassificationSmall findById(String smallId);
	@ResultMap("big")
	@Select("select * from classificationSmall where bigId=#{bigId}")
	public List<ClassificationSmall> findByBigId(Integer bigId);
	
	@Delete("delete from classificationSmall where smallId=#{smallId}")
	public void delete(String smallId);
	
	@Update("<script>"+
			"update classificationSmall " + 
			"		<set>" + 
			"			<if test='smallName!=null'>smallName=#{smallName},</if>" + 
			"			<if test='smallDetails!=null'>smallDetails=#{smallDetails},</if>" + 
			"			<if test='big.bigId!=null'>bigId=#{big.bigId},</if>" + 
			"		</set>" + 
			" where smallId=#{smallId}"+ 
			"</script>")
	public void update(ClassificationSmall small);
	
	@Insert("insert into classificationSmall values(null,#{smallName},#{smallDetails},#{big.bigId})")
	public void create(ClassificationSmall small);
	
	@ResultMap("big")
	@Select("select * from classificationSmall")
	public List<ClassificationSmall> findAll();
}
