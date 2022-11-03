package meuble.com.tn.controlleur;

import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import meuble.com.tn.entities.MemberN3;
import meuble.com.tn.entities.User;
import meuble.com.tn.services.IMember3Service;

@RestController
@RequestMapping("/Member3")
@CrossOrigin(origins = {"http://localhost:4200", "https://lylyqcontinental.com"})


public class Member3Controleur {
	@Autowired
	IMember3Service member3Service;
	
	

	 @GetMapping("/all") 
	 public List<MemberN3> getAll(){
		 return member3Service.getAllMemberN3();
		 
	 }
	
	 
	 
	 @PostMapping("/add")
		public HashMap<String, String> add(@RequestBody JSONObject obj){
			HashMap<String, String> msg = new HashMap<>();
			try {
				String nom = obj.get("firstName").toString();
				String prenom = obj.get("lastName").toString(); 
				String sexe = obj.get("gender").toString();  
				String nomCountry = obj.get("country").toString();  
				String nomRegion = obj.get("region").toString(); 
			    int tel = Integer.parseInt(obj.get("tel").toString()); 
				String email = obj.get("email").toString();  
				String motdepass = obj.get("password").toString();  
				String role = obj.get("role").toString();
				if(member3Service.checkMemberN3Exist(email)>0) { 
					msg.put("status", "exist");
				}else { 
				
					member3Service.addMemberN3(nom, prenom, sexe, nomCountry, nomRegion, tel, email, motdepass, role) ;
		        
		        msg.put("status", "success");
				}
			}catch (Exception e) {
				// TODO: handle exception
				msg.put("status", "error");
			}
			return  msg ; 
		}

		@DeleteMapping("/delete/{id}")
		 public  HashMap<String, String> delete(@PathVariable int id){
			HashMap<String, String> msg = new HashMap<>();
			 try {
				 member3Service.deleteMemberN3(id);
				msg.put("status", "success");
			 }catch(Exception e) {
				msg.put("status", "error");
				 e.printStackTrace();
			 }
			 return msg ; 
		}

		@GetMapping("/show/{id}")
		public  MemberN3 getDetails(@PathVariable int id){
			return member3Service.getMemberN3ById(id); 
		}
	 
		@PutMapping("/edit")
		 public  HashMap<String, String> edittt(@RequestBody MemberN3 a){
			HashMap<String, String> msg = new HashMap<>();
			 try {
				 member3Service.editMemberN3(a);
				msg.put("status", "success");
			 }catch(Exception e) {
				msg.put("status", "error");
				 e.printStackTrace();
			 }
			 return msg ; 
		}
		
		



		@PostMapping("/checkpassword")
		 public User getAll(@RequestBody JSONObject data){ System.out.println("data recived : "+data.toString()); 
			String password = data.get("password").toString();
			return member3Service.checkuser( password);
		 }
		

}


