

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BlobTestCase {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		File dir = new File("objects");
		dir.mkdir();
		Path p = Paths.get("test.txt");
        try {
            Files.writeString(p, "yo yo this is a test", StandardCharsets.ISO_8859_1);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		File orig = new File("test.txt");
		orig.delete();
		File dir = new File("objects"); 
		dir.delete();
	}

	@Test
	void testBlob() {
		Blob test = new Blob("test.txt");
		File file = new File("objects/464df858f159f0fba6fd85af76b9f5f8c7851a09");
		Scanner scanny = new Scanner("objects/464df858f159f0fba6fd85af76b9f5f8c7851a09");
		assertTrue(file.exists());
		String s = scanny.nextLine(); 
		assertTrue(s.equals("yo yo this is a test"));
	}

}
