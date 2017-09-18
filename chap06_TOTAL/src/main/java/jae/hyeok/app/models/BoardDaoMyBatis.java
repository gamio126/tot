package jae.hyeok.app.models;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDaoMyBatis {

	@Autowired
	SqlSessionTemplate template;
	
	public List<Map> readAll(){
		return template.selectList("board.readAll");
	}
	
	public int addOne(Map map) {
		return template.insert("board.addOne",map);
	}
	
	public Map readOne(String num){
		return template.selectOne("board.readOne", num);
	}
	
	public int CountOne(String num) {
		return template.update("board.countOne", num);
	}
	
	//=========
	public List<Map> ListAll(Map map){
		return template.selectList("board.ListAll", map);
	}
	
	public int ListCount() {
		return template.selectOne("board.ListCount");
	}
}
