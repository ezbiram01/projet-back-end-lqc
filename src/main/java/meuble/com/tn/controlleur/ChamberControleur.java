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

import meuble.com.tn.entities.chamber;
import meuble.com.tn.services.IChamberService;

@RestController
@RequestMapping("/Chamber")
@CrossOrigin(origins = "http://localhost:4200")
public class ChamberControleur {
	@Autowired
	IChamberService chamberService;
	
	

	@GetMapping("/all")
	 public List<chamber> getAll(){
		 return chamberService.getAllProduit();
	}
	
	@GetMapping("/allByAdmin/{id}")
	 public List<chamber> allByAdmin(@PathVariable int id){
		 return chamberService.getAllProduitByAdmin(id);
	}
	

	@DeleteMapping("/delete/{id}")
	 public  HashMap<String, String> delete(@PathVariable int id){
		HashMap<String, String> msg = new HashMap<>();
		 try {
			 chamberService.deleteProduit(id);
			msg.put("status", "success");
		 }catch(Exception e) {
			msg.put("status", "error");
			 e.printStackTrace();
		 }
		 return msg ; 
	}

	@GetMapping("/show/{id}")
	public  chamber getDetails(@PathVariable int id){
		return chamberService.getProduitById(id); 
	}
	

	
	@PostMapping("/addByAdmin")
	 public  HashMap<String, String> addByAdmin(@RequestBody JSONObject obj){
		HashMap<String, String> msg = new HashMap<>();
		 try {
		System.out.println(obj.toString());
		String title = obj.get("title").toString(); 
		String source = obj.get("source").toString();
		String source1 = obj.get("source1").toString();
		String source2 = obj.get("source2").toString();
		String source3 = obj.get("source3").toString(); 
		int categorie = Integer.parseInt(obj.get("categorie").toString());  
		int admin = Integer.parseInt(obj.get("admin").toString());  
		chamberService.addProduit( title, source ,source1,source2,source3,categorie,admin);
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
		String source1 = obj.get("source1").toString();
		String source2 = obj.get("source2").toString();
		String source3 = obj.get("source3").toString(); 
		int categorie = Integer.parseInt(obj.get("categorie").toString());

		chamberService.edittProduit(id, title, source,source1,source2,source3,categorie); 
		
        msg.put("status", "success");
		}catch (Exception e) {
			// TODO: handle exception
			msg.put("status", "error");
			 e.printStackTrace();
		}
		return  msg ; 
	}
 
	
	


}
