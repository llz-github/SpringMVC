package cn.bdu.edu.zl.Service;

import java.util.List;
import cn.bdu.edu.zl.Pojo.Item;
import cn.bdu.edu.zl.Pojo.QueryVo;


public interface ItemService {
	List<Item> queryItemList();
	Item queryItemById(int id);
	void updateItemById(Item item);
	void DeleteItemById(int id);
	public List<Item> queryItem2(QueryVo queryVo);
	void InsertItem(Item item);
}
