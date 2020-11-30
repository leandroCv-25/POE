package instalamento;

import java.util.List;

import org.junit.Test;

import com.ifsp.instalamento.model.models.User;
import com.ifsp.instalamento.model.service.UserService;

public class UserTest {
	
	//@Test(expected = Exception.class)
	public void salvarUserBancoDadosTeste() {
		User user = new User();
		
		//user.setId(2);
		user.setUsername("Maria Fernanda da Silva");
		user.setPassword("123456");
		user.setEmail("maria@maria.br");
		
		UserService userService = new UserService();
		
		userService.save(user);
		
		System.out.println("Gravando usuário no banco de dados 1");
				
		user = new User();
		
		//user.setId(2);
		user.setUsername("Clara Vieira");
		user.setPassword("123456");
		user.setEmail("clara@clara.br");

		UserService userService1 = new UserService();
	
		userService1.save(user);
		//assertTrue(true);
		
	}
	
	//@Test(expected = Exception.class)
		public void alterarUserBancoDadosTeste() {
	      
			User user = new User();
					
			user.setId(2);
			
			UserService userService = new UserService();
			
			user = userService.findById(user.getId());
			
			System.out.println(user.toString());
			
			user.setEmail("joao@joao.com.br");
			
			userService.update(user);
			
			System.out.println("Ateração usuário no banco de dados");
			
			//assertTrue(true);
			
			
		}
		
		@Test(expected = Exception.class)
		public void listarTodosUserTabelaUser() {
			
			UserService userService = new UserService();
			
			List<User> listaUser = userService.findAll();
			
			for (User user : listaUser) {
				System.out.println(user.toString());
			}
			
			
			
		}
		
		//@Test
		public void excluirUserDaTabela() {
			
			User user = new User();
			
			user.setId(6);
			
			UserService userService = new UserService();
			
			userService.delete(user);
			
		}
}
