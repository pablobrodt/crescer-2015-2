package br.com.cwi.crescer.lavanderia.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.lavanderia.domain.Usuario;
import br.com.cwi.crescer.lavanderia.domain.Usuario.SituacaoUsuario;

@Repository
public class UsuarioDao extends AbstractDao {

	public Usuario findByUserName(String userName) {
		return em.find(Usuario.class, userName);
	}
	
	public List<Usuario> findAllEnabled(){
		return em.createQuery("FROM Usuario u WHERE u.enabled = :enabled", Usuario.class)
				.setParameter("enabled", SituacaoUsuario.ATIVO)
				.getResultList();
	}
	
    @Transactional
    public Usuario save(Usuario usuario) {

        if (usuario.getAutorizacoes() == null) {
            em.persist(usuario);
            return usuario;
        }

        return em.merge(usuario);
    }
	
}
