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

import meuble.com.tn.entities.Produit;
import meuble.com.tn.services.IProduitService;

@RestController
@RequestMapping("/Produit")
@CrossOrigin(origins = {"http://localhost:4200", "https://lylyqcontinental.com"})
public class ProduitControleur {
	@Autowired
	IProduitService produitervice;
	

	@GetMapping("/all")
	 public List<Produit> getAll(){
		 return produitervice.getAllProduit();
	}
	
	@GetMapping("/allByAdmin/{id}")
	 public List<Produit> allByAdmin(@PathVariable int id){
		 return produitervice.getAllProduitByAdmin(id);
	}
	

	@DeleteMapping("/delete/{id}")
	 public  HashMap<String, String> delete(@PathVariable int id){
		HashMap<String, String> msg = new HashMap<>();
		 try {
			 produitervice.deleteProduit(id);
			msg.put("status", "success");
		 }catch(Exception e) {
			msg.put("status", "error");
			 e.printStackTrace();
		 }
		 return msg ; 
	}

	@GetMapping("/show/{id}")
	public  Produit getDetails(@PathVariable int id){
		return produitervice.getProduitById(id); 
	}
	

	
	@PostMapping("/addByAdmin")
	 public  HashMap<String, String> addByAdmin(@RequestBody JSONObject obj){
		HashMap<String, String> msg = new HashMap<>();
		 try {
		System.out.println(obj.toString());
		String title = obj.get("title").toString(); 
		
		String source = obj.get("source").toString(); 
		int categorie = Integer.parseInt(obj.get("categorie").toString());  
		int admin = Integer.parseInt(obj.get("admin").toString());  

		produitervice.addProduit( title, source ,categorie,admin);
       msg.put("status", "success");
		 }catch(Exception e) {
			msg.put("status", "error");
			 e.printStackTrace();
		 }
		 return msg ; 

	}
	@PutMapping("/edit")
	public HashMap<String, String> edit(@RequestBody JSONObject obj){
		HashMap<String, String> msg = new HashMap<>();
		try {
			System.out.println(obj.toString());
		int id = Integer.parseInt(obj.get("id").toString()); 
		
		String title = obj.get("title").toString(); 
		String source = obj.get("source").toString(); 

		int categorie = Integer.parseInt(obj.get("categorie").toString());

		produitervice.edittProduit(id, title, source,categorie); 
		
        msg.put("status", "success");
		}catch (Exception e) {
			// TODO: handle exception
			msg.put("status", "error");
			 e.printStackTrace();
		}
		return  msg ; 
	}
 
	
	

}
