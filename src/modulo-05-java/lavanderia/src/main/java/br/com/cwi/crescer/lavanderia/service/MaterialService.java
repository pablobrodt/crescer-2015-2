package br.com.cwi.crescer.lavanderia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.dao.MaterialDao;
import br.com.cwi.crescer.lavanderia.domain.Cidade;
import br.com.cwi.crescer.lavanderia.domain.Material;
import br.com.cwi.crescer.lavanderia.dto.MaterialDTO;

@Service
public class MaterialService {
	
	private MaterialDao materialDao;
	
	@Autowired
	public MaterialService(MaterialDao materialDao){
		super();
		this.materialDao = materialDao;
	}
	
	public Material findById(Long id){
		return this.materialDao.findById(id);
	}

	public List<MaterialDTO> findAll() {
		List<MaterialDTO> materiais = new ArrayList<>();
		for (Material material : this.materialDao.findAll()) {
			materiais.add(new MaterialDTO(material));
		}
		return materiais;
	}
}
