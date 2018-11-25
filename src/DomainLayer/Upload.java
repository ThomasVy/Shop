package DomainLayer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;


public abstract class Upload {
    public abstract String upload();
	public abstract void writeFileContent(byte[] content);
	/**
	 * Open file browser
	 * @param specifier
	 */
	private byte [] openFileBrowser() {
		JFileChooser fileBrowser = new JFileChooser();
		if (fileBrowser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileBrowser.getSelectedFile();
			byte [] fileInBytes = turnFileIntoBytes(selectedFile);
			return fileInBytes;
		}
		return null;
	}
	private byte [] turnFileIntoBytes (File selectedFile)
	{
		long length = selectedFile.length();
		byte[] content = new byte[(int) length]; // Converting Long to Int
		try {
			FileInputStream fis = new FileInputStream(selectedFile);
			BufferedInputStream bos = new BufferedInputStream(fis);
			bos.read(content, 0, (int)length);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}
		return content;
	}
//	/**
//	 * Gets the file content from the path
//	 * @param path - the path of the file to be converted
//	 * @return - the file converted into bytes
//	 */
//	public byte[] getFileContent(String path) { 
//		File selectedFile = new File(path);
//		long length = selectedFile.length();
//		byte[] content = new byte[(int) length];
//		try {
//			FileInputStream fis = new FileInputStream(selectedFile);
//			BufferedInputStream bos = new BufferedInputStream(fis);
//			bos.read(content, 0, (int)length);
//			bos.close();
//			fis.close();
//		} catch (Exception e)
//		{
//			
//		}
//		return content;
//	}
}
