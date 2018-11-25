package DomainLayer;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class UploadPdf extends Upload {
    /**
	 * Writing file content to a place
	 * @param a
	 * @param content
	 */
	public String writeFileContent(byte[] content) {
		try {
				String extension = "/Documents/"+"file" + counter++ + ".pdf";
				File newFile = new File("temp");
				newFile.createNewFile();
				FileOutputStream writer = new FileOutputStream(newFile);
				BufferedOutputStream bos = new BufferedOutputStream(writer);
				bos.write(content);
				writer.close();
				bos.close();
				return extension;
		} catch (Exception e) {
			return null;
		}
	}
}
