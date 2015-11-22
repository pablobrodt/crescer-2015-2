package br.com.cwi.crescer.lavanderia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.dao.ItemDao;
import br.com.cwi.crescer.lavanderia.domain.Item;

@Service
public class ItemService {
	
	private ItemDao itemDao;
	
	@Autowired
	public ItemService(ItemDao itemDao){
		super();
		this.itemDao = itemDao;
	}
	
	public Item findById(Long id){
		return this.itemDao.findById(id);
	}
}
