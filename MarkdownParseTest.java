import static org.junit.Assert.*;
import org.junit.*;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.List;
import java.io.IOException;
//import java.util.ArrayList;
public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1+1);
    }

    @Test
    public void testTestFile() throws IOException
    {
        assertEquals(List.of("https://something.com", "some-thing.html"), MarkdownParse.getLinks(Files.readString(Paths.get("test-file.md"))));
    }

    @Test
    public void testSelfTestFile() throws IOException
    {
        assertEquals(List.of("k", "mymy.org"), MarkdownParse.getLinks(Files.readString(Paths.get("selftest.md"))));
    }

    @Test
    public void testImageTestFile() throws IOException
    {
        assertEquals(List.of("https://www.unrealengine.com/marketplace/en-US/product/monster-giant-slug"), MarkdownParse.getLinks(Files.readString(Paths.get("imagetest.md"))));
    }

    @Test
    public void testBracketsWoParenFile() throws IOException
    {
        assertEquals(List.of(), MarkdownParse.getLinks(Files.readString(Paths.get("bracketswoparen.md"))));
    }

    @Test
    public void test2() throws IOException
    {
        assertEquals(List.of("https://something.com", "some-page.html"), MarkdownParse.getLinks(Files.readString(Paths.get("test-file2.md"))));
    }

    @Test
    public void test3() throws IOException
    {
        assertEquals(List.of(), MarkdownParse.getLinks(Files.readString(Paths.get("test-file3.md"))));
    }

    @Test
    public void test4() throws IOException
    {
        assertEquals(List.of(), MarkdownParse.getLinks(Files.readString(Paths.get("test-file4.md"))));
    }

    @Test
    public void test5() throws IOException
    {
        assertEquals(List.of(), MarkdownParse.getLinks(Files.readString(Paths.get("test-file5.md"))));
    }

    @Test
    public void test6() throws IOException
    {
        assertEquals(List.of(), MarkdownParse.getLinks(Files.readString(Paths.get("test-file6.md"))));
    }

    @Test
    public void test7() throws IOException
    {
        assertEquals(List.of(), MarkdownParse.getLinks(Files.readString(Paths.get("test-file7.md"))));
    }

    @Test
    public void test8() throws IOException
    {
        assertEquals(List.of("a link on the first line"), MarkdownParse.getLinks(Files.readString(Paths.get("test-file8.md"))));
    }
}
//javac -cp ".;lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar" MarkdownParseTest.java
//java -cp ".;lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar" org.junit.runner.JUnitCore MarkdownParseTest
