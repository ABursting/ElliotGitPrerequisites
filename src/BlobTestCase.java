

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
		File file = new File("4b6fcb2d521ef0fd442a5301e7932d16cc9f375a");
		Scanner scanny = new Scanner("4b6fcb2d521ef0fd442a5301e7932d16cc9f375a");
		System.out.println(file.exists());
		String s = scanny.nextLine(); 
		System.out.println((s.equals("yo yo this is a test")));
	}

}
