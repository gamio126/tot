package jae.hyeok.app.models;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoMybatis {

	@Autowired
	SqlSessionTemplate template;
	
	public boolean addOne(Map map) {
		template.insert("join.addOne",map);
		template.insert("join.addDetail",map);
		return true;
	}
	
	public int existOne(Map map) {
		return template.selectOne("join.existOne",map);
	}
	
	public HashMap readOneByIdOrEmail(String idmail) {
		return template.selectOne("join.readOneByIdOrEmail", idmail);
	}
	
	public List<Map> searchById(String id) {
		return template.selectList("join.searchById", id);
	}
	
	public List<Map> countByGender() {
		return template.selectList("join.countByGender");
	}
	
}
