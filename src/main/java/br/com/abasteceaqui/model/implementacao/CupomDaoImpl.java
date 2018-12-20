package br.com.abasteceaqui.model.implementacao;

import java.util.List;

import br.com.abasteceaqui.model.dao.PersistenciaDAO;
import br.com.abasteceaqui.model.entidades.Cupom;
import br.com.abasteceaqui.model.interfaces.InterfaceCupomDao;

public class CupomDaoImpl extends PersistenciaDAO<Cupom> implements InterfaceCupomDao<Cupom> {
	
    public Cupom buscarPorCodigo(Integer codigo) {
        @SuppressWarnings("rawtypes")
		List lista = super.listar("SELECT c FROM Cupom c WHERE c.id=" + codigo);
        
        if(!lista.isEmpty()) {
            return (Cupom) lista.get(0);
        }
            return null;  
    }

    @SuppressWarnings("unchecked")
	public List<Cupom> listar() {
        return super.listar("SELECT c FROM Cupom c");
    }
    
    public Cupom buscarPorId(Integer id) {
        @SuppressWarnings("rawtypes")
		List lista =  super.listar("SELECT c FROM Cupom c WHERE c.id=" + id);
        
        if(!lista.isEmpty()) {
        	return (Cupom) lista.get(0);
        }
            return null;
    }
    
}