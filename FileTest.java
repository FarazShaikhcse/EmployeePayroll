import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

import org.junit.Test;

import junit.framework.Assert;

public class FileTest{
	
	final String basePath = "/Users/farazshabbir/eclipse-workspace/Employee Payroll/src/Data/";
	final String fileName = "input.txt";
	Path filePath = Paths.get(basePath + fileName);
	
	@Test
	public void fileExists()
	{
		
		if(Files.exists(filePath)) {
			
			FileUtils.deleteFiles(filePath.toFile());
		}
		Assert.assertTrue(Files.notExists(filePath));
	}
	@Test
	public void createDirectory() throws IOException {
		Files.createDirectory(filePath);
		Assert.assertTrue(Files.exists(filePath));
	}
	@Test
	public void createFile() {
		IntStream.range(1,10).forEach(cntr -> {
			Path tempFile = Paths.get(filePath + "/temp" + cntr);
			Assert.assertTrue(Files.notExists(tempFile));
			try {
				Files.createFile(tempFile);
			}catch(IOException e) {
			}
			Assert.assertTrue(Files.exists(tempFile));
		});
	}
	@Test
	public void listFilesDir() throws IOException {
		Files.list(filePath).filter(Files::isRegularFile).forEach(System.out::println);
		Files.newDirectoryStream(filePath).forEach(System.out::println);
		Files.newDirectoryStream(filePath, path -> path.toFile().isFile() && path.toString().startsWith("input")).forEach(System.out::println);

	}
	
}