package jae.hyeok.app.models;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemoDaoMybatis {

	@Autowired
	SqlSessionTemplate template;
	
	public List<Map> MyReceiveMemo(String id){
		return template.selectList("memo.MyReceiveMemo",id);
	}
	
	public int addNew(Map map) {
		return template.insert("memo.addNew", map);
	}
	
	public List<Map> listAll(Map map) {
		return template.selectList("memo.ListAll", map);
	}
	public int ListCount(String id) {
		return template.selectOne("memo.ListCount",id);
	}
}
