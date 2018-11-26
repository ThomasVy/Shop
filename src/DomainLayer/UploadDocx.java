package DomainLayer;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UploadDocx extends Upload{
    /**
   	 * Writing file content to a place
   	 * @param a
   	 * @param content
   	 */
   	public String writeFileContent(byte[] content) {
   		try {
			while(true) {
				String extension = "\\Documents\\document" + counter++ + ".docx";
				Path path = Paths.get(System.getProperty("user.dir"), extension);
				File newFile = new File(path.toString());
				if(!newFile.exists()) {
					newFile.createNewFile();
					FileOutputStream writer = new FileOutputStream(newFile);
					BufferedOutputStream bos = new BufferedOutputStream(writer);
					bos.write(content);
					bos.close();
					writer.close();
					return path.toString();
				}
			}
			
	} catch (Exception e) {
		return null;
	}
   	}
}
