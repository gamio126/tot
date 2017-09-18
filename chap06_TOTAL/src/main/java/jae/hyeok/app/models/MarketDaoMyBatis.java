package jae.hyeok.app.models;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MarketDaoMyBatis {

	@Autowired
	SqlSessionTemplate template;
	
	public int addArticle(Map map) {
		return template.insert("market.addArticle",map);
	}
	
	public List<Map> allArticle(){
		return template.selectList("market.allArticle");
	}
	
	public Map readArticle(int num){
		return template.selectOne("market.readArticle", num);
	}
	
	public List<Map> searchArticle(Map map) {
		return template.selectList("market.searchStprice", map);
	}
	
	
	
	
	//=========
	public List<Map> ListAll(Map map){
		return template.selectList("market.ListAll", map);
	}
	
	public int ListCount() {
		return template.selectOne("market.ListCount");
	}
}
