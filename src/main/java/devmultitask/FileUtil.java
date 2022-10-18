package devmultitask;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * Fonte: https://mkyong.com/java/java-how-to-create-and-write-to-a-file/
 * 
 * @author devmultitask
 *
 */
public class FileUtil {

	// Java 11
	public static void writeFile(Path path, String content) {

		try {
			Files.writeString(path, content, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
		} catch (IOException e) {
			if (SystemFlags.DEBUG)
				e.printStackTrace();
		}

	}

	public static void deleteFile(Path path) {

		try {
			Files.delete(path);
		} catch (IOException e) {
			if (SystemFlags.DEBUG)
				e.printStackTrace();
		}

	}

}
