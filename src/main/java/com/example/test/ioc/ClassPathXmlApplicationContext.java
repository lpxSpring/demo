package com.example.test.ioc;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO 读取xml文件内容，并创建对象及对象关系（使用setter方式）
 *
 * @author 18124550
 * @date 2019/1/8
 */
public class ClassPathXmlApplicationContext implements BeanFactory{

    private Map<String, Object> beans = new HashMap<>();

    /**
     *
     * @throws JDOMException
     * @throws IOException
     */
    public ClassPathXmlApplicationContext() throws Exception {
        SAXBuilder sb = new SAXBuilder();
        // 构造文档对象
        Document doc = sb.build(ClassPathXmlApplicationContext.class
                .getClassLoader().getResourceAsStream("beans.xml"));
        // 获取根元素
        Element root = doc.getRootElement();
        // 取到根元素所有元素
        List<Element> list = root.getChildren();

        setBeans(list);
    }

    /**
     * 设置Bean
     * @param list
     * @throws Exception
     */
    private void setBeans(List<Element> list) throws Exception {
        for (int i = 0; i < list.size(); i++) {
            Element element = (Element) list.get(i);
            String id = element.getAttributeValue("id");
            //取得class子元素
            String clzss = element.getAttributeValue("class");
            //通过反射进行实例化
            Object o = Class.forName(clzss).newInstance();
            beans.put(id, o);

            setProperty(element, o);
        }
    }

    /**
     * 获取property进行依赖注入
     * @param element
     * @param o
     * @throws Exception
     */
    private void setProperty(Element element, Object o) throws Exception {
        for (Element property : (List<Element>) element.getChildren("property")) {
            String name = property.getAttributeValue("name");
            String bean = property.getAttributeValue("bean");
            // 从beans.xml中根据id取到类的对象
            Object beanObj = this.getBean(bean);
            System.out.println(beanObj);//com.example.dao.impl.UserDAOImpl@2f4d3709
            // 组成setXXX方法名
            String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
            // 反射机制对方法进行调用，将对象在加载bean时就注入到环境上下文中
            Method m = o.getClass().getMethod(methodName, beanObj.getClass().getInterfaces()[0]);
            m.invoke(o, beanObj);
        }
    }

    @Override
    public Object getBean(String name) {
        return beans.get(name);
    }
}
