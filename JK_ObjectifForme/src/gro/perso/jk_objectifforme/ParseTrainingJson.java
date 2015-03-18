package gro.perso.jk_objectifforme;

import gro.perso.jk_objectifforme.JsonTrainingParser.Entrainement;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ParseTrainingJson {

	public Entrainement getTraining(String jsonToParse) {

		ObjectMapper mapper = new ObjectMapper();
		Entrainement to = null;
		try {
			to = mapper.readValue(jsonToParse, Entrainement.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return to;
	}
}
