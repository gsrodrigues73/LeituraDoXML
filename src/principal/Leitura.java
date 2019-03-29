package principal;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Leitura {

	public static void main(String[] args) throws Exception {
		File file = new File("FASE-Tabelas.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance(); 
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(file);
		
		doc.getDocumentElement().normalize();
		
		// Recupera a lista de todas as tabelas
		NodeList nTabelas = doc.getElementsByTagName("o:Table");
		
		// Itera tabela por tabela
		for (int i = 0; i <= nTabelas.getLength(); i++) {
			Node nTabela = nTabelas.item(i);
			
			// Recupera a lista de informações por tabela
			NodeList nItens = nTabela.getChildNodes();
			
			// Itera item a item da tabela
			for (int j = 1; j < nItens.getLength(); j += 2) {
				Node nItem = nItens.item(j);
				
				System.out.println(nItem.getNodeName());
			}
			break;
		}
	}

}
