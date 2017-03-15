package pkgEmpty;

import static org.junit.Assert.assertTrue;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

import exceptions.BookException;
import pkgLibrary.Catalog;

public class TestBook {


	@Test (expected = BookException.class)
	public void AddBookTest() throws BookException {
		Catalog cat = ReadXMLFile();
		
		cat.AddBook("bk101");
		
		
	}
	
	@Test 
	public void AddBookTest2() throws BookException {
		Catalog cat = ReadXMLFile();
		int size = cat.getBooks().size();
		cat.AddBook("bk001");
		assertTrue(cat.getBooks().size() == size + 1);
		
	}
	


	private static Catalog ReadXMLFile() {

		Catalog cat = null;

		String basePath = new File("").getAbsolutePath();
		basePath = basePath + "/src/main/resources/XMLFiles/Books2.xml";
		File file = new File(basePath);

		System.out.println(file.getAbsolutePath());
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			cat = (Catalog) jaxbUnmarshaller.unmarshal(file);
			System.out.println(cat);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return cat;

	}
}



