package API;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Repository.VolRepository;
import models.Vol;

@RequestMapping("/")
@RestController
public class VolController {
	
	@Autowired
	VolRepository repository;
	
	@GetMapping("/Vols")
	public List<Vol> getAllVols() {
		System.out.println("Get all Vols");
	    return (List<Vol>) (repository.findAll());
	    }
	 
	  @PostMapping(value = "/Vols/create")
	  public Vol postVol (@Valid @RequestBody Vol vol) {
		  System.out.println("new vol");
		  Vol _Instrument = repository.save(vol);
		  return _Instrument;
	  }
	  
	  @DeleteMapping("/Vols/{num}")
	  public ResponseEntity<String> deleteVol(@PathVariable("num") Long num) {
		System.out.println("Delete Vol with Code = " + num );
	    repository.delete(num);
	    return new ResponseEntity<String>("Vol has been deleted!", HttpStatus.OK);
	  }
	  
	  @DeleteMapping("/Vols/delete")
	  public ResponseEntity<String> deleteAllVols() {
	    System.out.println("Delete All Vols");
	    repository.deleteAll();
	    return new ResponseEntity<String>("All Vols have been deleted!", HttpStatus.OK);
	  }
	  
	  @PutMapping("/Vols/{num}")
	  public ResponseEntity<Vol> updateVol(@PathVariable("num") Long num, @RequestBody Vol vol) {
	 
		System.out.println("Update Vol");
		
		Vol Data = repository.findOne(num);
	    if (Data!= null ) {
	    
	    Vol v = Data;
	      v.setDeparture(vol.getDeparture());
	      v.setDestination(vol.getDestination());
	      v.setT_off(vol.getT_off());
	      v.setT_Arrival(vol.getT_Arrival());
	      v.setDuration(vol.getDuration());
	      return new ResponseEntity<Vol>(repository.save(v), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<Vol>(HttpStatus.NOT_FOUND);
	    }
	  }
	 
}
