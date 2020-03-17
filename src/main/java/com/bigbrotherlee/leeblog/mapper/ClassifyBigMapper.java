package com.bigbrotherlee.leeblog.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.FetchType;

import com.bigbrotherlee.leeblog.domain.entity.ClassificationBig;

public interface ClassifyBigMapper {
	@Results(id="small",value={
		@Result(property="smallList",column="bigId",many=@Many(select="com.bigbrotherlee.leeblog.mapper.ClassifySmallMapper.findByBigId",fetchType=FetchType.DEFAULT))
	})
	@Select("select * from classificationBig big,classificationSmall small where big.bigId=#{classifyId} and small.bigId=big.bigId")
	public ClassificationBig findClassifyById(String classifyId);
	
	@Delete("delete from classificationBig where bigId=#{classifyId}")
	public void deleteClassify(Integer classifyId);
	
	@Update("<script>"+
			"update classificationBig " + 
			"		<set>" + 
			"			<if test='bigName!=null'>bigName=#{bigName},</if>" + 
			"			<if test='bigDetails!=null'>bigDetails=#{bigDetails},</if>" + 
			"		</set>" + 
			" where bigId=#{bigId}"+ 
			"</script>")
	public void updateClassify(ClassificationBig classify);
	
	@Insert("insert into classificationBig values(null,#{bigName},#{bigDetails})")
	public void createClassify(ClassificationBig classify);
	
	@Select("select * from classificationBig where bigName like #{key}  or bigDetails like #{key}")
	public List<ClassificationBig> find(String key);
	
	@Select("select * from classificationBig where bigId=#{bigId}")
	public ClassificationBig findById(String bigId) ;
}
