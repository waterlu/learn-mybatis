package cn.lu.learn;

import cn.lu.learn.aop.ProductMapper;
import cn.lu.learn.aop.ProxyHandler;
import com.alibaba.fastjson.JSON;
import lombok.ToString;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.assertj.core.data.MapEntry;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationHandler;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisApplicationTests {

	private final Logger logger = LoggerFactory.getLogger(MybatisApplicationTests.class);

	@Test
	public void contextLoads() {
//		parseBankType();
//		compareFile();
//		compareMenu();
	}

	@Autowired
	private ProductMapper productMapper;

	void compareMenu() {
		String file1 = "E:\\kingold2018\\2018-01\\menu_pre.txt";
		String file2 = "E:\\kingold2018\\2018-01\\menu_test.txt";

		try {
			Map<String, Menu> preFileMap = new HashMap<>();
			Map<String, Menu> prodFileMap = new HashMap<>();

			FileInputStream in = new FileInputStream(file1);
			InputStreamReader inReader = new InputStreamReader(in, "UTF-8");
			BufferedReader bufReader = new BufferedReader(inReader);
			String line = bufReader.readLine();
			while(line != null) {
				String [] data = line.split("\t");
				Menu menu = new Menu();
				menu.id = data[0];
				menu.parentId = data[1];
				menu.name = data[2];
				menu.permission = data[5];
				preFileMap.put(menu.id, menu);
				line = bufReader.readLine();
			}
			bufReader.close();
			inReader.close();
			in.close();

			in = new FileInputStream(file2);
			inReader = new InputStreamReader(in, "UTF-8");
			bufReader = new BufferedReader(inReader);
			line = bufReader.readLine();
			while(line != null){
				String [] data = line.split("\t");
				Menu menu = new Menu();
				menu.id = data[0];
				menu.parentId = data[1];
				menu.name = data[2];
				menu.permission = data[5];
				prodFileMap.put(menu.id, menu);
				line = bufReader.readLine();
			}
			bufReader.close();
			inReader.close();
			in.close();

			for (String key : preFileMap.keySet()) {
				if (!prodFileMap.containsKey(key)) {
					logger.error("预上线有，测试没有 {}", preFileMap.get(key));
				}
			}

			for (String key : prodFileMap.keySet()) {
				if (!preFileMap.containsKey(key)) {
					logger.error("测试有，预上线没有 {}", prodFileMap.get(key));
				}
			}

			logger.info("completed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void compareFile() {
		String file1 = "E:\\kingold2018\\2018-01\\pre1.txt";
		String file2 = "E:\\kingold2018\\2018-01\\prod1.txt";

		try {
//			List<String> preFile = new ArrayList<>();
//			List<String> prodFile = new ArrayList<>();

			Map<String, Menu> preFileMap = new HashMap<>();
			Map<String, Menu> prodFileMap = new HashMap<>();

			FileInputStream in = new FileInputStream(file1);
			InputStreamReader inReader = new InputStreamReader(in, "UTF-8");
			BufferedReader bufReader = new BufferedReader(inReader);
			String line = bufReader.readLine();
			while(line != null) {
				String [] data = line.split("\t");
				Menu menu = new Menu();
				menu.id = data[0];
				menu.parentId = data[1];
				menu.name = data[2];
				preFileMap.put(menu.id, menu);
				line = bufReader.readLine();
			}
			bufReader.close();
			inReader.close();
			in.close();

			in = new FileInputStream(file2);
			inReader = new InputStreamReader(in, "UTF-8");
			bufReader = new BufferedReader(inReader);
			line = bufReader.readLine();
			while(line != null){
				String [] data = line.split("\t");
				Menu menu = new Menu();
				menu.id = data[0];
				menu.parentId = data[1];
				menu.name = data[2];
				prodFileMap.put(menu.id, menu);
				line = bufReader.readLine();
			}
			bufReader.close();
			inReader.close();
			in.close();

			for (String key : preFileMap.keySet()) {
				if (!prodFileMap.containsKey(key)) {
					logger.error("预上线有，生产没有 {}", preFileMap.get(key));
				}
			}

			for (String key : prodFileMap.keySet()) {
				if (!preFileMap.containsKey(key)) {
					logger.error("生产有，预上线没有 {}", prodFileMap.get(key));
				}
			}

			logger.info("completed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@ToString
	public class Menu {

		public String id;

		public String parentId;

		public String name;

		public String permission;

	}

	void parseBankType() {
		String filename = "F:\\log\\2018\\01-08\\bankId.txt";
		Pattern pattern = Pattern.compile("\\d+");

		try {
			InputStream inputStream = MybatisApplication.class.getClassLoader().getResourceAsStream("bankBin.json");
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			StringBuffer content = new StringBuffer();
			String line = bufferedReader.readLine();
			while(line != null){
				content.append(line);
				line = bufferedReader.readLine();
			}
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();

			Map<String, String> bankBinMap = (Map) JSON.parse(content.toString());

			Map<String, Integer> data = new HashMap<>();
			data.put("unknown", 0);

			FileInputStream in = new FileInputStream(filename);
			InputStreamReader inReader = new InputStreamReader(in, "UTF-8");
			BufferedReader bufReader = new BufferedReader(inReader);

			line = bufReader.readLine();
			while(line != null){
				Matcher matcher = pattern.matcher(line);
				if (matcher.find()) {
					String id = matcher.group(0);
					String prefix = id.substring(0, 6);
					if (bankBinMap.containsKey(prefix)) {
						String bank = bankBinMap.get(prefix);
						String bankInfo[] = bank.split("·");
						String key = bankInfo[0];
						if (data.containsKey(key)) {
							int count = data.get(key);
							data.put(key, count + 1);
						} else {
							data.put(key, 1);
						}
					} else {
						int count = data.get("unknown");
						data.put("unknown", count + 1);
					}
				}
				line = bufReader.readLine();
			}
			bufReader.close();
			inReader.close();
			in.close();

			List<Map.Entry<String,Integer>> list = new ArrayList<>(data.entrySet());
			Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
				public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
					return  o2.getValue().compareTo(o1.getValue());
				}
			});

			for(Map.Entry<String,Integer> entry:list){
				System.out.println("银行="+entry.getKey()+"\t人数="+entry.getValue());
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("读取" + filename + "出错！");
		}
	}

}
