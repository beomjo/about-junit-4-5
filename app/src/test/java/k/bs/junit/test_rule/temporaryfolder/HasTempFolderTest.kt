package k.bs.junit.test_rule.temporaryfolder

import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder

class HasTempFolderTest {
    @get:Rule
    val folder = TemporaryFolder()


    @Test
    fun testUsingTempFolder() {
        val createdFile = folder.newFile("myfile.txt")
        val createdFolder = folder.newFolder("subfolder")

        println(createdFile)
        println(createdFolder)

        Assert.assertEquals(2,folder.root.list().size)
    }
}