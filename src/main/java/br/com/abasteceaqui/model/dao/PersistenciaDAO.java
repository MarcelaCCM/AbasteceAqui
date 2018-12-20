package br.com.abasteceaqui.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class PersistenciaDAO<E> {
	
	protected EntityManager em = ConectionManager.getInstance().getEntityManager();
	
    public void salvar(E o) {
        EntityTransaction transaction = null;
        
        try {
        	transaction = em.getTransaction();
            transaction.begin();
            em.persist(o);
            transaction.commit();
        } catch(RuntimeException ex) {
            if(transaction != null)
            	transaction.rollback();
            throw ex;
        }
        
    }
    
    protected void finalize() throws Throwable {
    	super.finalize();
    	this.close();
    }

    @SuppressWarnings("rawtypes")
	public List listar(String sql) {
        List lista = null;
        
        try {
            Query consulta = em.createQuery(sql);
            lista = (List) consulta.getResultList();
        } catch(RuntimeException ex) {
            throw ex;
        }
        
        return lista;
        
    }

    public void atualizar(E o) {
        EntityTransaction transacao = null;
        
        try {
            transacao = em.getTransaction();
            transacao.begin();
            em.merge(o);
            transacao.commit();
        } catch(RuntimeException ex) {
            if(transacao != null) {
                transacao.rollback();
            }
            
            throw ex;
        }        
    }

    public void deletar(E o) {
        EntityTransaction transacao = null;
        
        try {
            transacao = em.getTransaction();
            transacao.begin();
            em.remove(o);
            transacao.commit();
        } catch(RuntimeException ex) {
            if(transacao != null) {
                transacao.rollback();
            }
            throw ex;
        }
        
    }
    
    public Object autenticar(String sql, String login, String senha) {
        Object obj = null;
        
        try {
            Query consulta = em.createQuery(sql +" WHERE a.login =:login AND a.senha =:senha");
            
            consulta.setParameter("login", login);
            consulta.setParameter("senha", senha);
          
           obj = consulta.getSingleResult();
        } catch(RuntimeException ex) {
            throw ex;
        }
        
        return obj;
        
    }
   
	public void close() {
		em.close();
	}    
    
}