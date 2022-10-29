package meuble.com.tn.controlleur;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import meuble.com.tn.entities.User;
import meuble.com.tn.services.IUserService;


@RestController 
@RequestMapping("/User")
@CrossOrigin(origins = "http://localhost:4200")

public class UserControleur {
	
	@Autowired
	 IUserService userServise;
	@Autowired
    private JavaMailSender javaMailSender;


	@PostMapping("/login")
	 public User getAll(@RequestBody JSONObject data){ System.out.println("data recived : "+data.toString()); 
		String mail = data.get("email").toString();
		String password = data.get("password").toString();
		return userServise.checkuser(mail, password);
	 }
	

	
	
	@SuppressWarnings("unused")
	@PostMapping("/forget")
	 public HashMap<String, String> getPasswordUser(@RequestBody JSONObject data){ System.out.println("data recived : "+data.toString()); 
		String mail = data.get("email").toString(); 
		String newPassword = data.get("password").toString(); 
		String newPasswordCrypted = data.get("passwordCrypted").toString(); 
		HashMap<String, String> msg = new HashMap<>();
	
		try {
			User u = userServise.getUserInfo(mail);
			System.out.println(u);
			System.out.println(u.getLastName()+" "+u.getFirstName());
			if(u!=null) { 
				// save new password 
				userServise.editPassword(u.getIdUser(), newPasswordCrypted); 
				// send mail contient new password of user 
				SimpleMailMessage sender = new SimpleMailMessage();
				sender.setTo(mail); 
				sender.setSubject("LyLyQ- - Recuperation Mot de passe");
				sender.setText("Salut "+u.getFirstName()+" "+u.getLastName()+", suite a votre demande de récuperation de mot de passe , \n Votre Mot de passe  est : "+newPassword);
				javaMailSender.send(sender);
		        
				msg.put("status", "success");
				msg.put("result", "E-mail envoyée avec succès");
			}else{
				msg.put("status", "warning");
				msg.put("result", "E-mail inexiste");
			} 
			
		}catch (Exception e) {
			// TODO: handle exception
			msg.put("status", "error"); 
			e.printStackTrace(); 
		}
		return  msg ; 
	 } 
	 
	

	@SuppressWarnings("unused")
	@PostMapping("/verifie")
	 public HashMap<String, String> verifieEmailUser(@RequestBody JSONObject data){ System.out.println("data recived : "+data.toString()); 
		String mail = data.get("email").toString(); 
		HashMap<String, String> msg = new HashMap<>();
	
		try {
			User u = userServise.getUserInfo(mail);
			System.out.println(u);
			System.out.println(u.getLastName()+" "+u.getFirstName());
			if(u!=null) {
				// send mail contient role de user 
				SimpleMailMessage sender = new SimpleMailMessage();
				sender.setTo(mail); 
				sender.setSubject("LyLyQ - Bienvenue");
				sender.setText("Salut "+u.getFirstName()+" "+u.getLastName()+",Bienvenue sur LyLyQ  , \n Vous êtes inscrit sous Member  de : "+u.getRole());
				javaMailSender.send(sender);
		        
				msg.put("status", "success");
				msg.put("result", "E-mail envoyée avec succès");
			}else{
				msg.put("status", "warning");
				msg.put("result", "E-mail inexiste");
			} 
			
		}catch (Exception e) {
			// TODO: handle exception
			msg.put("status", "error"); 
			e.printStackTrace(); 
		}
		return  msg ; 
	 } 
	
	@SuppressWarnings("unused")
	@PostMapping("/changementpass")
	 public HashMap<String, String> verifieEmailUserr(@RequestBody JSONObject data){ System.out.println("data recived : "+data.toString()); 
		String mail = data.get("email").toString(); 
		HashMap<String, String> msg = new HashMap<>();
	
		try {
			User u = userServise.getUserInfo(mail);
			System.out.println(u);
			System.out.println(u.getLastName()+" "+u.getFirstName());
			if(u!=null) {
				// send mail contient role de user 
				SimpleMailMessage sender = new SimpleMailMessage();
				sender.setTo(mail); 
				sender.setSubject("My-school - Changement Mot de passe");
				sender.setText("Salut "+u.getFirstName()+" "+u.getLastName()+",tu change votre mot de passe  sur techno-school  , \n Vous êtes inscrit sous rôle de : "+u.getRole());
				javaMailSender.send(sender);
		        
				msg.put("status", "success");
				msg.put("result", "E-mail envoyée avec succès");
			}else{
				msg.put("status", "warning");
				msg.put("result", "E-mail inexiste");
			} 
			
		}catch (Exception e) {
			// TODO: handle exception
			msg.put("status", "error"); 
			e.printStackTrace(); 
		}
		return  msg ; 
	 } 
	 
	 
	

}
