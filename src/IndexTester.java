

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

class IndexTester {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
        Path p = Paths.get("test.txt");
        try {
            Files.writeString(p, "yo", StandardCharsets.ISO_8859_1);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Path q = Paths.get("testy.txt");
        try {
            Files.writeString(q, "what", StandardCharsets.ISO_8859_1);
        } catch (IOException f) {
            // TODO Auto-generated catch block
            f.printStackTrace();
        }
        Path r = Paths.get("testee.txt");
        try {
            Files.writeString(r, "up", StandardCharsets.ISO_8859_1);
        } catch (IOException g) {
            // TODO Auto-generated catch block
            g.printStackTrace();
        }
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void test() {
		File file1 = new File("objects/4b6fcb2d521ef0fd442a5301e7932d16cc9f375a");
		File file2 = new File("objects/6b06033bbcbff37438a3874048491793c7939517");
		File file3 = new File("objects/168191428dc80d9431b09880ecc785729cf75426");
		Index index = new Index();
		index.addBlob("test.txt");
		index.addBlob("testy.txt");
		index.addBlob("testee.txt");
		assertTrue(file1.exists());
	}

}
