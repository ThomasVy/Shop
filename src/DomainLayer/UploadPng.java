package DomainLayer;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class UploadPng extends Upload{
    @Override
    public String upload() {
        return null;
    }
    /**
	 * Writing file content to a place
	 * @param a
	 * @param content
	 */
	public void writeFileContent(byte[] content) {
		try {
				File newFile = new File("temp");
				newFile.createNewFile();
				FileOutputStream writer = new FileOutputStream(newFile);
				BufferedOutputStream bos = new BufferedOutputStream(writer);
				bos.write(content);
				writer.close();
				bos.close();
		} catch (Exception e) {
			return;
		}
	}
}
