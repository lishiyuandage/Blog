package com.bigbrotherlee.leeblog.mapper;

import org.apache.ibatis.annotations.Select;
import com.bigbrotherlee.leeblog.domain.entity.AdminUser;

/*
 * 注意：
 * 	1.mapper方法不可以重载
 * `2.@Results注解不能复用，它的Id没有意义
 * 	3.@ResultMap依赖一个外部的XML文件,这个文件定义了ResultMap
 * 	4.@SelectProvider依赖另一个类的方法，该方法用于生成动态sql
 */
public interface AdminMapper {
	
	@Select("<script>"+
			"select * from adminuser  where	adminCode=#{adminCode}"+ 
			"		<if test='adminPassword!=null'>and	adminPassword=#{adminPassword}</if>"+ 
			"</script>")
	public AdminUser findAdminByUser(AdminUser user);
}
