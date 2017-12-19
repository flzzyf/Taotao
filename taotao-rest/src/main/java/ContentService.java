import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.abel533.entity.Example;
import com.github.abel533.entity.Example.Criteria;
import com.sun.tools.javac.util.List;
import com.sun.xml.internal.xsom.impl.scd.Iterators.Map;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.HttpClientUtils;
import com.taotao.common.utils.JsonUtils;

@Service
public class ContentService {

	@Autowired
	private TbContentMapper contentMapper;
	
	public List<TbContent> queryContentList(long contentCid) {
		//根据内容分类id查询内容列表
		Example example = new Example(TbContent.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("catId", contentCid);
		//执行查询
		List<TbContent> list = (List<TbContent>) contentMapper.selectByExample(example);
		
		return list;
	}

}