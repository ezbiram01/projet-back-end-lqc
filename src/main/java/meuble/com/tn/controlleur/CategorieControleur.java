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

import meuble.com.tn.entities.Categorie;
import meuble.com.tn.services.ICategorieService;

@RestController
@RequestMapping("/Categorie")
@CrossOrigin(origins = "http://localhost:4200")
public class CategorieControleur {
	@Autowired
	ICategorieService categService;
	
	
	@GetMapping("/all")  
	public List<Categorie> getAll(){
		return categService.getAllCategories(); 
	}
	
	
	@DeleteMapping("/delete/{id}")
	 public  HashMap<String, String> delete(@PathVariable int id){
		HashMap<String, String> msg = new HashMap<>();
		 try {
			categService.deleteCategorie(id);
			msg.put("status", "success");
		 }catch(Exception e) {
			msg.put("status", "error");
			 e.printStackTrace();
		 }
		 return msg ; 
	}
	
	
	@PostMapping("/add")
	public HashMap<String, String> add(@RequestBody JSONObject obj){
		HashMap<String, String> msg = new HashMap<>();
		try {
			String nomCateg = obj.get("designation").toString(); 
			if(categService.checkCategorieIfExist(nomCateg)>0) { 
				msg.put("status", "exist");
			}else { 
				categService.addCategorie(nomCateg); 
				msg.put("status", "success");
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			msg.put("status", "error");
		}
		return  msg ; 
	}
	
	@PutMapping("/edit")
	public HashMap<String, String> edit(@RequestBody JSONObject obj){
		HashMap<String, String> msg = new HashMap<>();
		try {
		    int id = Integer.parseInt(obj.get("id").toString()); 
			String nomCateg = obj.get("designation").toString(); 
			categService.editCategorie(id ,nomCateg  ); 
			msg.put("status", "success");
		}catch (Exception e) {
			// TODO: handle exception
			msg.put("status", "error");
			 e.printStackTrace();
		}
		return  msg ; 
	}
 
	
	
	@GetMapping("/show/{id}")
	public  Categorie getDetails(@PathVariable int id){
		return categService.getCategorieById(id); 
	}

}
