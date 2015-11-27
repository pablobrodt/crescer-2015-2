package br.com.cwi.crescer.lavanderia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.dao.UsuarioDao;
import br.com.cwi.crescer.lavanderia.domain.Cliente;
import br.com.cwi.crescer.lavanderia.domain.Usuario;
import br.com.cwi.crescer.lavanderia.domain.Usuario.SituacaoUsuario;
import br.com.cwi.crescer.lavanderia.dto.UsuarioDTO;
import br.com.cwi.crescer.lavanderia.dto.UsuarioResumoDTO;
import br.com.cwi.crescer.lavanderia.mapper.ClienteMapper;
import br.com.cwi.crescer.lavanderia.mapper.UsuarioMapper;

@Service
public class UsuarioService {

	private UsuarioDao usuarioDao;
	
	@Autowired
	public UsuarioService(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
	
	public UsuarioDTO findByUserName(String userName){
		return UsuarioMapper.toDTO(this.usuarioDao.findByUserName(userName));
	}
	
	public List<UsuarioResumoDTO> findAllEnabled(){
		return UsuarioMapper.toResumoDTOList(this.usuarioDao.findAllEnabled());
	}
	
	public void update(UsuarioDTO dto){
		Usuario entity = this.usuarioDao.findByUserName(dto.getUserName());
		UsuarioMapper.merge(dto, entity);
		
		this.usuarioDao.save(entity);
	}
	
	public void insert(UsuarioDTO dto){
		Usuario entity = new Usuario();
		UsuarioMapper.merge(dto, entity);
		entity.setEnabled(SituacaoUsuario.ATIVO);
		
		this.usuarioDao.save(UsuarioMapper.toEntity(dto));
	}
	
	public void delete(String userName){
		Usuario entity = this.usuarioDao.findByUserName(userName);
		entity.setEnabled(SituacaoUsuario.INATIVO);
		
		this.usuarioDao.save(entity);
	}
}
