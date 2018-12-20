package br.com.abasteceaqui.model.implementacao;

import java.util.List;

import br.com.abasteceaqui.model.dao.PersistenciaDAO;
import br.com.abasteceaqui.model.entidades.Venda;
import br.com.abasteceaqui.model.interfaces.InterfaceVendaDao;

public class VendaDaoImpl  extends PersistenciaDAO<Venda> implements InterfaceVendaDao<Venda> {

    public Venda buscarPorCodigo(Integer codigo) {
        @SuppressWarnings("rawtypes")
		List lista = super.listar("SELECT v FROM Venda v WHERE v.id=" + codigo);
        
        if(!lista.isEmpty()) {
            return (Venda) lista.get(0);
        }
            return null;  
    }

    @SuppressWarnings("unchecked")
	public List<Venda> listar() {
        return super.listar("SELECT v FROM Venda v");
    }
    
    public Venda buscarPorId(Integer id) {
        @SuppressWarnings("rawtypes")
		List lista = super.listar("SELECT v FROM Venda v WHERE v.id=" + id);
        
        if(!lista.isEmpty()) {
        	return (Venda) lista.get(0);
        }
            return null;
    }
    
}