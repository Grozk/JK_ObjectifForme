package gro.perso.test.transfoJson;



import gro.perso.jk_objectifforme.ParseTrainingJson;
import gro.perso.jk_objectifforme.JsonTrainingParser.Entrainement;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;

import org.junit.Test;

public class JsonTransformator {

	String jsonToParse = "{ \"entrainement\": {\"type\":\"debutant\"},"
			+ "\"contenuEchauffement\": {\"enchainement\":\"2\", \"contenu\" : {\"composante\":"
			+ "{\"intitule\":\"pompe\", \"nombre\":\"10\",\"unite\":\"repetition\"},"
			+ "\"composante\":{\"intitule\":\"pompe\","
			+ "\"nombre\":\"10\",\"unite\":\"repetition\"}},\"composante\":{\"intitule\":\"pompe\","
			+ " \"nombre\":\"10\",\"unite\":\"repetition\"}}, \"contenuSerie\":{\"enchainement\":\"5\","
			+ " \"contenu\":{\"composante\":{\"intitule\":\"pompe\","
			+ " \"nombre\":\"10\",\"unite\":\"repetition\"}, \"composante\":{\"intitule\":\"pompe\","
			+ " \"nombre\":\"10\",\"unite\":\"repetition\"}},\"composante\":{\"intitule\":\"pompe\","
			+ " \"nombre\":\"10\",\"unite\":\"repetition\"}},"
			+ " \"contenuRecuperation\":{\"composante\":{\"intitule\":\"etirement des jambes\","
			+ " \"nombre\":\"2\",\"unite\":\"minutes\"},\"intitule\":\"repos\","
			+ " \"nombre\":\"2\",\"unite\":\"minutes\"} }";

	String jsToParse = "{ \"entrainement\": {\"type\":\"debutant\"},\"contenuEchauffement\": {\"enchainement\":\"2\", \"contenu\" :			  {\"composanteEchainement\":{\"intitule\":\"pompe\", \"nombre\":\"10\",\"unite\":\"repetition\"},			   \"composanteEchainement\":{\"intitule\":\"pompe\", \"nombre\":\"10\",\"unite\":\"repetition\"}},			  \"composantSimple\":{\"intitule\":\"pompe\", \"nombre\":\"10\",\"unite\":\"repetition\"}},			 \"contenuSerie\":			 {\"enchainement\":\"5\", \"contenu\":			  {\"composanteEchainement\":{\"intitule\":\"pompe\", \"nombre\":\"10\",\"unite\":\"repetition\"},			   \"composanteEchainement\":{\"intitule\":\"pompe\", \"nombre\":\"10\",\"unite\":\"repetition\"}},			  \"composantSimple\":{\"intitule\":\"pompe\", \"nombre\":\"10\",\"unite\":\"repetition\"}},			 \"contenuRecuperation\":			 {\"composantSimple\":{\"intitule\":\"etirement des jambes\", \"nombre\":\"2\",\"unite\":\"minutes\"},			  \"composantSimple\":{\"intitule\":\"repos\", \"nombre\":\"2\",\"unite\":\"minutes\"} }}";


	/**
	 * Exemple Json possible { "entrainement": {"type":"debutant"},
	 * "contenuEchauffement": {"enchainement":"2", "contenu" : {"composante":
	 * {"intitule":"pompe", "nombre":"10","unite":"repetition"},
	 * "composante":{"intitule":"pompe",
	 * "nombre":"10","unite":"repetition"}},"composante":{"intitule":"pompe",
	 * "nombre":"10","unite":"repetition"}}, "contenuSerie":{"enchainement":"5",
	 * "contenu":{"composante":{"intitule":"pompe",
	 * "nombre":"10","unite":"repetition"}, "composante":{"intitule":"pompe",
	 * "nombre":"10","unite":"repetition"}},"composante":{"intitule":"pompe",
	 * "nombre":"10","unite":"repetition"}},
	 * "contenuRecuperation":{"composante":{"intitule":"etirement des jambes",
	 * "nombre":"2","unite":"minutes"},"intitule":"repos",
	 * "nombre":"2","unite":"minutes"} }
	 * 
	 * @throws IOException
	 */

	@Test
	public void testJsontransfo() throws IOException {
		ParseTrainingJson trObj = new ParseTrainingJson();

		String s = readFileContent(
				"test/gro/perso/test/transfoJson/exemple.json",
				Charset.defaultCharset());
		System.out.println(s);

//		ObjectMapper mapper = new ObjectMapper();
//		JsonNode node = mapper.readTree(s);
//		node = node.get("items");
//		
//		TypeReference<List<Item>> typeRef = new TypeReference<List<Item>>() {
//		};
//		List<Item> list = mapper.readValue(node.traverse(), typeRef);
		//
		Entrainement training = trObj.getTraining(s);

		System.out.println(training.getItems().get(0).getIntitule());

//		System.out.println(list.get(0).getIntitule());

	}

	public String readFileContent(String filename, Charset charset)
			throws IOException {
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(filename, "r");
			byte[] buffer = new byte[(int) raf.length()];
			raf.readFully(buffer);
			return new String(buffer, charset);
		} finally {
			raf.close();
		}
	}

}
