package br.com.abasteceaqui.model.implementacao;

import java.util.List;

import br.com.abasteceaqui.model.dao.PersistenciaDAO;
import br.com.abasteceaqui.model.entidades.Avaliacao;
import br.com.abasteceaqui.model.interfaces.InterfaceAvaliacaoDao;

public class AvaliacaoDaoImpl extends PersistenciaDAO<Avaliacao> implements InterfaceAvaliacaoDao<Avaliacao> {
	
    public Avaliacao buscarPorCodigo(Integer codigo) {
        @SuppressWarnings("rawtypes")
		List lista = super.listar("SELECT a FROM Avaliacao a WHERE a.id=" + codigo);
        
        if(!lista.isEmpty()) {
            return (Avaliacao) lista.get(0);
        }
            return null;  
    }
    
    @SuppressWarnings("unchecked")
	public List<Avaliacao> listar() {
        return super.listar("SELECT a FROM Avaliacao a");
    }


	
	public Avaliacao buscarPorId(Integer id) {
        @SuppressWarnings("rawtypes")
		List lista =  super.listar("SELECT a FROM Avaliacao a WHERE a.id=" + id);
        
        if(!lista.isEmpty()) {
        	return (Avaliacao) lista.get(0);
        }
            return null;
       
}
}