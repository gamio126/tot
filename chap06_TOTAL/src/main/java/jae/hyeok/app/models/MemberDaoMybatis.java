package jae.hyeok.app.models;

import java.sql.SQLException;
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
}