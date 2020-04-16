package cn.bdu.edu.zl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bdu.edu.zl.Mapper.ItemMapper;
import cn.bdu.edu.zl.Pojo.Item;
import cn.bdu.edu.zl.Pojo.QueryVo;
import cn.bdu.edu.zl.Service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemMapper itemMapper;

	public List<Item> queryItemList() {
		// 从数据库查询商品数据
		List<Item> list = this.itemMapper.selectByExample(null);

		return list;

	}

	public Item queryItemById(int id) {
		Item item = this.itemMapper.selectByPrimaryKey(id);
		return item;
	}
	public void updateItemById(Item item) {
		this.itemMapper.updateByPrimaryKeySelective(item);
	}

	public void DeleteItemById(int id) {
		this.itemMapper.deleteByPrimaryKey(id);
	}

	public List<Item> queryItem2(QueryVo queryVo) {
		System.out.println(queryVo.getItem().getId());
		//return null;
		return this.itemMapper.queryItem2(queryVo);
	}

	public void InsertItem(Item item) {
		// TODO Auto-generated method stub
		this.itemMapper.insert(item);
	}

}
