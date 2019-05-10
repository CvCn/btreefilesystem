package btreefilesystem;

import static org.junit.Assert.assertTrue;

import com.moxiaowei.btree.BTree;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        BTree bTree = new BTree();
        bTree.createNewLogCon();
        assertTrue(true);
    }
}
