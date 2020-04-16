package cn.bdu.edu.zl.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.bdu.edu.zl.Pojo.Item;
import cn.bdu.edu.zl.Pojo.QueryVo;
import cn.bdu.edu.zl.Service.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;

	/**
	 * ��ʾ��Ʒ�б�
	 * 
	 * @return
	 */
	@RequestMapping("/itemList")
	public String queryItemList(ModelMap map) {
		// ��ȡ��Ʒ����
		List<Item> list = this.itemService.queryItemList();
		map.addAttribute("ItemList", list);
		return "itemList";
	}

	// �����Ʒ
	@RequestMapping("/itemInsert")
	public String insertItem() {
		return "itemInsert";
	}
	@RequestMapping("/updateItems")
	public String updateItems(Item item) {
		this.itemService.InsertItem(item);
		return "success-Insert";
	}

	// ����idɾ����Ʒ
	@RequestMapping("deleteItems.action")
	public String deleteItems(int[] ids) {
		System.out.println(ids.length);
		for (int i = 0; i < ids.length; i++) {
			System.out.println(ids[i]);
			this.itemService.DeleteItemById(ids[i]);
		}
		return "forward:itemList.action";
	}

	/**
	 * �޸ĸ��� ����id��ѯ�޸�
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/itemEdit")
	public String queryItemById(Integer id, ModelMap modelMap) {
		// ����id��ѯ��Ʒ����
		Item item = this.itemService.queryItemById(id);
		// ����Ʒ���ݷ���ģ����
		modelMap.addAttribute("item", item);
		return "itemEdit";
	}

	@RequestMapping("/updateItem")
	public String updateItem(Item item) {
		// ���÷��������Ʒ
		this.itemService.updateItemById(item);
		// �����߼���ͼ
		return "success-Edit";
	}

	// ������ѯ
	@RequestMapping("queryItem")
	public String queryItem2(QueryVo queryVo, Model model) {
		List<Item> list = this.itemService.queryItem2(queryVo);
		model.addAttribute("ItemList", list);
		return "itemList";
	}

}
