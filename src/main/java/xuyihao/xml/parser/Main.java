package xuyihao.xml.parser;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import xuyihao.xml.parser.entity.Character;
import xuyihao.xml.parser.util.RandomUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Author Xuyh created at 2017年1月12日 下午4:25:12
 *
 */
public class Main {
	public static void main(String[] args) {

	}

	public void testDocumentToFile() {
		Document document = DocumentHelper.createDocument();

		List<Character> characterList = new ArrayList<Character>();
		for (int i = 0; i < 20; i++) {
			Character character = new Character();
			character.setName("Name_" + RandomUtils.getRandomString(5));
			character.setAuthority(1);
			character.setCode("Code_" + RandomUtils.getRandomString(5));
			character.setNumber("Num_" + RandomUtils.getRandomString(14));
			characterList.add(character);

			Element element = DocumentHelper.createElement("character1");
			element.setData(character);
			document.setRootElement(element);
		}

	}
}
