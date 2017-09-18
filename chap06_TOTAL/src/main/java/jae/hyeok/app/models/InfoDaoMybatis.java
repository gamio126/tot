package jae.hyeok.app.models;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
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
	
	public List<Map> picHistory(String abc) {
		return template.selectList("my.picHistory",abc);
	}

	public Map representPic(String abc) {
		return template.selectOne("my.representPic",abc);
	}
	
	public int addPic(Map map) {
		return template.insert("my.addPic", map);
	}
	
	public List<Map> allMember(){
		return template.selectList("my.allMember");
	}
	
	public List<Map> allMember2(Map map){
		return template.selectList("my.allMember2", map);
	}
	
	public int countMember() {
		return template.selectOne("my.countMember");
	}
}
