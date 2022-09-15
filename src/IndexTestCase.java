

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class IndexTestCase {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Path p = Paths.get("test.txt");
        try {
            Files.writeString(p, "example", StandardCharsets.ISO_8859_1);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Path q = Paths.get("testy.txt");
        try {
            Files.writeString(q, "example", StandardCharsets.ISO_8859_1);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Path r = Paths.get("testee.txt");
        try {
            Files.writeString(r, "example", StandardCharsets.ISO_8859_1);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		File file1 = new File("test.txt");
		file1.delete();
		File file2 = new File("testy.txt");
		file2.delete();
		File file3 = new File("testee.txt");
		file3.delete();
	}

	@Test
	void test() {
		Index testIndex = new Index();
		testIndex.initProject();
		testIndex.addBlob("test.txt");
		testIndex.addBlob("testy.txt");
		testIndex.addBlob("testee.txt");
		File file1 = new File("objects/464df858f159f0fba6fd85af76b9f5f8c7851a09");
		File file2 = new File("objects/6b06033bbcbff37438a3874048491793c7939517");
		File file3 = new File("objects/168191428dc80d9431b09880ecc785729cf75426");
		assertFalse(file1.exists());
		assertTrue(file2.exists());
		assertTrue(file3.exists());
		testIndex.removeBlob("test.txt");
		testIndex.removeBlob("testee.txt");
		assertTrue(file1.exists());
		assertTrue(file2.exists());
		assertTrue(file3.exists());
	}

}
