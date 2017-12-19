
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.abel533.entity.Example;
import com.github.abel533.entity.Example.Criteria;
import com.sun.tools.javac.util.List;
import com.taotao.manager.mapper.TbItemCatMapper;
import com.taotao.manager.pojo.TbItemCat;

@Service
public class ItemCatService {

	@Autowired
	private TbItemCatMapper itemCatMapper;
	
	public ItemCatResult queryAllCategory() throws Exception {
		
		ItemCatResult result = new ItemCatResult();
		result.setData(getItemCatList(0l));
		
		return result;
	}
	
	/**
	 * 查询分类列表
	 * <p>Title: getItemCatList</p>
	 * <p>Description: </p>
	 * @param parentid
	 * @return
	 */
	private ArrayList getItemCatList(long parentid) {
		Example example = new Example(TbItemCat.class);
		Criteria criteria = example.createCriteria();
		//查询parentid为0的分类信息
		criteria.andEqualTo("parentId", parentid);
		List<TbItemCat> list = (List<TbItemCat>) itemCatMapper.selectByExample(example);
		ArrayList dataList = new ArrayList();
		for (TbItemCat tbItemCat : list) {
			//判断是否为父节点
			if (tbItemCat.getIsParent()) {
				ItemCat itemCat = new ItemCat();
				itemCat.setUrl("/category/" + tbItemCat.getId() + ".html");
				itemCat.setName(tbItemCat.getName());
				//递归调用
				itemCat.setItem(getItemCatList(tbItemCat.getId()));
				//添加到列表
				dataList.add(itemCat);
			} else {
				String catItem = "/item/" + tbItemCat.getId() + ".html|" + tbItemCat.getName();
				dataList.add(catItem);
			}
		}
		return dataList;
	}
}