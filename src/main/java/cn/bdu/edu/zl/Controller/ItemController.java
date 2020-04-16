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
	 * 显示商品列表
	 * 
	 * @return
	 */
	@RequestMapping("/itemList")
	public String queryItemList(ModelMap map) {
		// 获取商品数据
		List<Item> list = this.itemService.queryItemList();
		map.addAttribute("ItemList", list);
		return "itemList";
	}

	// 添加商品
	@RequestMapping("/itemInsert")
	public String insertItem() {
		return "itemInsert";
	}
	@RequestMapping("/updateItems")
	public String updateItems(Item item) {
		this.itemService.InsertItem(item);
		return "success-Insert";
	}

	// 根据id删除商品
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
	 * 修改更新 根据id查询修改
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/itemEdit")
	public String queryItemById(Integer id, ModelMap modelMap) {
		// 根据id查询商品数据
		Item item = this.itemService.queryItemById(id);
		// 把商品数据放在模型中
		modelMap.addAttribute("item", item);
		return "itemEdit";
	}

	@RequestMapping("/updateItem")
	public String updateItem(Item item) {
		// 调用服务更新商品
		this.itemService.updateItemById(item);
		// 返回逻辑视图
		return "success-Edit";
	}

	// 批量查询
	@RequestMapping("queryItem")
	public String queryItem2(QueryVo queryVo, Model model) {
		List<Item> list = this.itemService.queryItem2(queryVo);
		model.addAttribute("ItemList", list);
		return "itemList";
	}

}
