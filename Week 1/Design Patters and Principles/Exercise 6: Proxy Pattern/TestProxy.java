// TestProxy.java
package ProxyPatternExample;

public class TestProxy {
    public static void main(String[] args)
    {
        Image image1 = new ProxyImage("image1.jpg");

        image1.display();
    }
}
