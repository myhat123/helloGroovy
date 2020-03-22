import com.mine.hello.*

class TestUtils extends GroovyTestCase {
    void testSimple() {
        assertEquals(Utils.sum(2, 3), 5)
    }
}