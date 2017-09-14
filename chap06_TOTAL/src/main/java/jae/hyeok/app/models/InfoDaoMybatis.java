package jae.hyeok.app.models;

import java.sql.SQLException;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InfoDaoMybatis {

	@Autowired
	SqlSessionTemplate template;
	
	public Map myInfo(String map) {
		return template.selectOne("my.readOneDetail",map);
	}
	
	public int myInfoChange(Map map) {
		return template.update("my.updateOneDetail", map);
	}
}
