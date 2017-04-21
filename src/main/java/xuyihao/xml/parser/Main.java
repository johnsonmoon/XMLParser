package xuyihao.xml.parser;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import xuyihao.xml.parser.util.CommonUtil;
import xuyihao.xml.parser.util.XMLUtils;

import java.util.List;

/**
 * 
 * @Author Xuyh created at 2017年1月12日 下午4:25:12
 *
 */
public class Main {
	public static void main(String[] args) {
		testGetDocumentFromFile();
		testoutputDocumentToFile();
	}

	private static void testoutputDocumentToFile() {
		String dir = System.getProperty("user.dir") + "/conf/TestOutputDocument.xml";
		Document document = DocumentHelper.createDocument();
		Element rootElement = document.addElement("Root");
		rootElement.addAttribute("name", "root_001");
		rootElement.addElement("Child").addAttribute("name", "child_001");
		rootElement.addElement("Child").addAttribute("name", "child_002");
		rootElement.addElement("Child").addAttribute("name", "child_003");
		rootElement.addElement("Child").addAttribute("name", "child_004");
		rootElement.addElement("Child").addAttribute("name", "child_005").addElement("Child_child").addAttribute("name",
				"child_child_001");
		rootElement.addElement("Child").addAttribute("name", "child_010");
		rootElement.addElement("Child").addAttribute("name", "child_011");
		rootElement.addElement("Child").addAttribute("name", "child_012");
		rootElement.addElement("Child").addAttribute("name", "child_013");
		rootElement.addElement("Child").addAttribute("name", "child_014");
		XMLUtils.wirteXMLFile(dir, document);
	}

	@SuppressWarnings("unchecked")
	private static void testGetDocumentFromFile() {
		String dir = System.getProperty("user.dir") + "/conf/TestInputDocument.xml";
		Document document = XMLUtils.readXMLFile(dir);
		Element school = document.getRootElement();
		List<Element> students = school.element("Students").elements("Student");
		List<Element> teachers = school.element("Teachers").elements("Teacher");
		for (Element student : students) {
			CommonUtil.outputLine(student.attributeValue("name") + " || " + student.attributeValue("number"));
		}
		for (Element teacher : teachers) {
			CommonUtil.outputLine(teacher.attributeValue("name") + " || " + teacher.attributeValue("number"));
		}
	}
}
