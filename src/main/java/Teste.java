
import java.io.IOException;

import javax.websocket.Session;

import br.com.abasteceaqui.dao.PersistenciaDAO;
import br.com.abasteceaqui.util.HibernateUtil;


public class Teste {

	public static void main(String[] args) {
		
	
		 
		 Session sessao = (Session) HibernateUtil.getSessionFactory().openSession();
	        try {
				sessao.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        HibernateUtil.getSessionFactory().close();

	}

}
