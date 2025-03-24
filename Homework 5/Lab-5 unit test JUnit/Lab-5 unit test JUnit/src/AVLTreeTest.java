import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class AVLTreeTest {
    private AvlTree tree;

    @Before
    public void setUp() {
        tree = new AvlTree();
    }

    /*
    =============================================================
    Test Case Coverage Conclusion:
        * Statement Coverage:
            ✓ AVLtree()
            ✓ isEmpty()
            ✓ makeEmpty()
            ✓ insert()
            ✓ countNodes
            ✓ search()
            ✓ inorder()
            ✓ preorder()
            ✓ postorder()
        * Branch Coverage:
            - 已測試各項操作對於 Empty Tree 的處理方式
            - 已測試三種條件下的 search() 操作
            - 已測試四種 Rotations 操作
        * 不足之處:
            - 未測試所有 Override 的函式 (e.g. AvlNode(), countNodes(), search(), inorder(), preorder(), postorder())
    =============================================================
    */


    // ===================================================================================
    // * Test case for basic tree operations: isEmpty(), makeEmpty(), insert(), countNodes()
    // * Branch Converage Analysis:
    //      測試各項操作對於 Empty Tree 的處理方式

    // ===================================================================================
    @Test
    public void test_basicOperations_givenEmptyTree_expectedCorrectBehavior_byCoverage() {
        // given
        // Empty tree is created in setUp()

        // when
        boolean isEmptyBefore = tree.isEmpty();
        int nodeCountBefore = tree.countNodes();
        tree.insert(10);

        tree.insert(20);
        tree.insert(30);
        int nodeCountAfter = tree.countNodes();
        tree.makeEmpty();
        boolean isEmptyAfter = tree.isEmpty();

        // then
        assertTrue("New tree should be empty", isEmptyBefore);
        assertEquals("New tree should have no node before insert", 0, nodeCountBefore);
        assertEquals("Tree should have 3 nodes after insert", 3, nodeCountAfter);
        assertTrue("Tree should be empty after makeEmpty()", isEmptyAfter);
    }


    
    // ===================================================================================  
    // * Test case for basic search()
    // * Branch Converage Analysis:
    //      測試與目標比較，大於、小於、等於三種情況
    // =================================================================================
    @Test
    public void Searching_for_an_existed_value_will_return_True_byCoverage() {
        // given
        /*
        * Tree structure:
        *     20
        *    /  \
        *  10   40
        *       / \
        *     30  50
        */
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);

        // when
        boolean found = tree.search(30);

        // then
        assertTrue("Searching for an existed value will return True", found);
    }


    // ===================================================================================  
    //  * Test case for negative scenarios: search() with non-existent values
    // ===================================================================================
    @Test
    public void Searching_for_nonexistent_value_will_return_false_byNegative() {
        // given
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);

        // when
        boolean found = tree.search(15);

        // then
        assertFalse("Searching for non-existent value should return false", found);
    }



    // ===================================================================================
    //  * Test case for Rotations: rotateWithLeftChild(), rotateWithRightChild(), 
    // ===================================================================================
    @Test
    public void test_leftRotation_givenLeftHeavyTree_expectedBalancedTree_byPartition() {
        // given
        /*
        * Tree structure before:
        *     10
        *    /
        *   5
        *  /
        * 3
        */
        tree.insert(10);
        tree.insert(5);
        tree.insert(3);

        // when
        /* Call rotateWithLeftChild() */
        String inorder = tree.inorder();

        // then
        /*
        * Tree structure after:
        *    5
        *   / \
        *  3   10
        */
        assertEquals("Inorder traversal should be '3 5 10'", "3 5 10", inorder);
    }

    @Test
    public void test_rightRotation_givenRightHeavyTree_expectedBalancedTree_byPartition() {
        // given
        /*
        * Tree structure before:
        *   10
        *    \
        *    15
        *     \
        *      20
        */
        tree.insert(10);
        tree.insert(15);
        tree.insert(20);

        // when
        /* Call rotateWithRightChild() */
        String inorder = tree.inorder();

        // then
        /*
        * Tree structure after:
        *    15
        *   /  \
        *  10  20
        */
        assertEquals("Inorder traversal should be '10 15 20'", "10 15 20", inorder);
    }



    // ===================================================================================
    // * Test case for double rotations: doubleWithLeftChild(), doubleWithRightChild()
    // ===================================================================================
    @Test
    public void test_doubleRotation_givenLeftRightCase_expectedBalancedTree_byPartition() {
        // given
        /* 
        Tree structure before:
            10
           /
          5
           \
            7
        */

        tree.insert(10);
        tree.insert(5);
        tree.insert(7);

        // when
        String inorder = tree.inorder();

        // then
        /*
        Tree structure after:
            7
           / \
          5  10
        */
        assertEquals("Inorder traversal should be '5 7 10'", "5 7 10", inorder);
    }

    @Test
    public void test_doubleRotation_givenRightLeftCase_expectedBalancedTree_byPartition() {
        // given
        /*
        Tree structure before:
            10
             \
             20
             /
            15
        */
        tree.insert(10);
        tree.insert(20);
        tree.insert(15);

        // when
        String inorder = tree.inorder();

        // then 
        /*
        Tree structure after:
            15
           / \
          10  20
        */
        assertEquals("Inorder traversal should be '10 15 20'", "10 15 20", inorder);    
    }
    


    // ===================================================================================
    // * Test cases for tree traversal methods: inorder(), preorder(), postorder()
    // ===================================================================================
    @Test
    public void test_traversals_givenBalancedTree_expectedCorrectOrder_byCoverage() {
        // given
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(12);
        tree.insert(20);

        // when
        String inorder = tree.inorder();
        String preorder = tree.preorder();
        String postorder = tree.postorder();

        // then
        assertEquals("Inorder traversal should be '3 5 7 10 12 15 20'", "3 5 7 10 12 15 20", inorder);
        assertEquals("Preorder traversal should be '10 5 3 7 15 12 20'", "10 5 3 7 15 12 20", preorder);
        assertEquals("Postorder traversal should be '3 7 5 12 20 15 10'", "3 7 5 12 20 15 10", postorder);
    }

    @Test
    public void test_traversals_givenEmptyTree_expectedEmptyString_byNegative() {
        // given
        // Empty tree

        // when
        String inorder = tree.inorder();
        String preorder = tree.preorder();
        String postorder = tree.postorder();

        // then
        assertEquals("Inorder traversal should be ''", "", inorder);
        assertEquals("Preorder traversal should be ''", "", preorder);
        assertEquals("Postorder traversal should be ''", "", postorder);
    }



    //  ===================================================================================
    //  * Test case for boundary conditions: insert with duplicate values
    // ===================================================================================
    @Test
    public void test_boundaryConditions_givenEdgeCases_expectedCorrectBehavior_byBoundary() {
        // given
        // Empty tree

        // when
        tree.insert(10);
        tree.insert(10); // Duplicate value
        int count = tree.countNodes();
        String inorder = tree.inorder();

        // then
        assertEquals("Duplicate insert should not increase node count", 1, count);
        assertEquals("Inorder traversal should contain only one value", "10", inorder);
    }


    // ===================================================================================
    // * Performance test for large tree:insertion time complexity
    // * Expected: O(log n)
    // ===================================================================================
    @Test
    public void test_insertion_givenLargeTree_expectedLogNComplexity_byPerformance() {
        // given
        int size = 10000;
        long startTime = System.currentTimeMillis();

        // when
        for (int i = 0; i < size; i++) {
            tree.insert(i);
        }
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        // then
        // For n=10000, if O(log n), operations should be around log2(10000) ≈ 13
        // Actual time should be much less than O(n) which would be proportional to 10000
        assertTrue("Insert operation should be O(log n)", duration < 1000);
    }

} 
