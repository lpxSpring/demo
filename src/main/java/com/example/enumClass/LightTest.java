package com.example.enumClass;

import java.util.EnumMap;
import java.util.EnumSet;

/**
 *
 * 1. 所有的枚举类型都是Enum类的子类。 它们继承了这个类的许多方法。其中最有用的一个方法是toString()，这个方法能够返回枚举常量名。   toString()方法的逆方法是静态方法valueOf(Class, String). 例如 Light lt = (Light) Enum.valueOf(Light.class, "RED"); 将lt设置为 Light.RED。 每个枚举类型都有一个静态的values()方法，它将返回一个包含全部枚举值的数组。   ordinal()方法返回enum声明中枚举常量的位置，位置从0开始计数。例如  Light.GREEN.ordinal()返回1。   Enum类实现了Comparable接口，  int  compareTo( E other)  如果枚举常量在other之前，则返回一个负值； 如果this==other，则返回0；否则，返回正值。 枚举常量的出现次序在enum 声明中给出。（所以不能直接用<,>符号比较两个枚举值）
 *
 * 2. 可以创建一个enum类，把它看做一个普通的类。除了它不能继承其他类了。(java是单继承，它已经继承了Enum),
 *
 * 可以添加其他方法，覆盖它本身的方法
 *
 * 3. switch()参数可以使用enum了
 *
 * 4. values()方法是编译器插入到enum定义中的static方法，所以，当你将enum实例向上转型为父类Enum是，values()就不可访问了。解决办法：在Class中有一个getEnumConstants()方法，所以即便Enum接口中没有values()方法，我们仍然可以通过Class对象取得所有的enum实例
 *
 * 5. 无法从enum继承子类，如果需要扩展enum中的元素，在一个接口的内部，创建实现该接口的枚举，以此将元素进行分组。达到将枚举元素进行分组。
 *
 * 6. 使用EnumSet代替标志。enum要求其成员都是唯一的，但是enum中不能删除添加元素。
 *
 * 7. EnumMap的key是enum，value是任何其他Object对象。
 *
 * 8. enum允许程序员为eunm实例编写方法。所以可以为每个enum实例赋予各自不同的行为。
 *
 * 9. 使用enum的职责链(Chain of Responsibility) .这个关系到设计模式的职责链模式。以多种不同的方法来解决一个问题。然后将他们链接在一起。当一个请求到来时，遍历这个链，直到链中的某个解决方案能够处理该请求。
 *
 * 10. 使用enum的状态机
 *
 * 11. 使用enum多路分发
 *
 *
 * @author 18124550
 * @date 2019/8/2
 */
public class LightTest {

    // 1.定义枚举类型

    public enum Light {

        // 利用构造函数传参

        RED(1), GREEN(3), YELLOW(2);

        // 定义私有变量

        private int nCode;

        // 构造函数，枚举类型只能为私有

        private Light(int _nCode) {

            this.nCode = _nCode;

        }

        @Override
        public String toString() {

            return String.valueOf(this.nCode);

        }

    }

    /**
     *
     * @param args
     */

    public static void main(String[] args) {

        // 1.遍历枚举类型

        System.out.println("演示枚举类型的遍历 ......");

        testTraversalEnum();

        // 2.演示EnumMap对象的使用

        System.out.println("演示EnmuMap对象的使用和遍历.....");

        testEnumMap();

        // 3.演示EnmuSet的使用

        System.out.println("演示EnmuSet对象的使用和遍历.....");

        testEnumSet();

    }

    /**
     *
     * 演示枚举类型的遍历
     */

    private static void testTraversalEnum() {

        Light[] allLight = Light.values();

        for (Light aLight : allLight) {

            System.out.println("当前灯name：" + aLight.name());

            System.out.println("当前灯ordinal：" + aLight.ordinal());

            System.out.println("当前灯：" + aLight);

        }

    }

    /**
     *
     * 演示EnumMap的使用，EnumMap跟HashMap的使用差不多，只不过key要是枚举类型
     */

    private static void testEnumMap() {

        // 1.演示定义EnumMap对象，EnumMap对象的构造函数需要参数传入,默认是key的类的类型

        EnumMap<Light, String> currEnumMap = new EnumMap<Light, String>(

                Light.class);

        currEnumMap.put(Light.RED, "红灯");

        currEnumMap.put(Light.GREEN, "绿灯");

        currEnumMap.put(Light.YELLOW, "黄灯");

        // 2.遍历对象

        for (Light aLight : Light.values()) {

            System.out.println("[key=" + aLight.name() + ",value="

                    + currEnumMap.get(aLight) + "]");

        }

    }

    /**
     *
     * 演示EnumSet如何使用，EnumSet是一个抽象类，获取一个类型的枚举类型内容<BR/>
     *
     * 可以使用allOf方法
     */

    private static void testEnumSet() {

        EnumSet<Light> currEnumSet = EnumSet.allOf(Light.class);

        for (Light aLightSetElement : currEnumSet) {

            System.out.println("当前EnumSet中数据为：" + aLightSetElement);

        }

    }

}
