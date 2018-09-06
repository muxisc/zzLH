package com.lh.blog.util;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.icinfo.framework.generator.api.MyBatisGenerator;
import com.icinfo.framework.generator.config.Configuration;
import com.icinfo.framework.generator.config.xml.ConfigurationParser;
import com.icinfo.framework.generator.exception.InvalidConfigurationException;
import com.icinfo.framework.generator.exception.XMLParserException;
import com.icinfo.framework.generator.internal.DefaultShellCallback;

/**
 * mybatis代码自动生成
 * @author hzhb
 *
 */
public class GeneratorMain {
	public static void main(String[] args) {
		try {
	        List<String> warnings = new ArrayList<String>();  
	        boolean overwrite = true;  
	        String genCfg = "/generatorConfig.xml";  
	        File configFile = new File(GeneratorMain.class.getResource(genCfg).getFile());  
	        ConfigurationParser cp = new ConfigurationParser(warnings);  
	        Configuration config = cp.parseConfiguration(configFile);  
	        DefaultShellCallback callback = new DefaultShellCallback(overwrite);  
	        MyBatisGenerator myBatisGenerator =new MyBatisGenerator(config, callback, warnings);
		    myBatisGenerator.generate(null);
		}catch (IOException e) {
            e.printStackTrace();
        } catch (XMLParserException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
        
    }  

}
