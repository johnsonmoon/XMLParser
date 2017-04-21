package xuyihao.xml.parser.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * 对XML文件进行操作的工具类
 * 
 * Created by Xuyh at 2017年4月21日 下午7:41:42.
 */
public class XMLUtils {
	/**
	 * 将document写入XML文件
	 * 
	 * @param filePathName 文件路径名
	 * @param document
	 * @return
	 */
	public static boolean wirteXMLFile(String filePathName, Document document) {
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		XMLWriter writer = null;
		try {
			writer = new XMLWriter(new FileOutputStream(new File(filePathName)), format);
			writer.write(document);
			writer.flush();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
			return false;
		} catch (IOException e2) {
			e2.printStackTrace();
			return false;
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * 读取XML文件获取document
	 * 
	 * @param filePathName 文件路径名
	 * @return
	 */
	public static Document readXMLFile(String filePathName) {
		SAXReader reader = new SAXReader();
		Document document = null;
		try {
			document = reader.read(new File(filePathName));
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return document;
	}
}
