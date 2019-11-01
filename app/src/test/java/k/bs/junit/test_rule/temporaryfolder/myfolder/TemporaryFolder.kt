package k.bs.junit.test_rule.temporaryfolder.myfolder

import java.io.File
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths

class TemporaryFolder {
    private val FILE_PREFIX = "junit"
    private val FILE_SUFFIX = ".tmp"
    private var rootFolder: File? = null

    init {
        try {
            val tempPath = Files.createTempDirectory(FILE_PREFIX)
            rootFolder = tempPath.toFile()
        } catch (ex: IOException) {
            throw TemporaryFolderException("Failed to prepare root folder!", ex)
        }
    }


    fun newFile(fileName: String): File {
        val path = Paths.get(rootFolder!!.path, fileName)
        return Files.createFile(path).toFile()
    }

    fun newDirectory(directoryName: String): File {
        val path = Paths.get(rootFolder!!.path, directoryName)
        try {
            return Files.createDirectory(path).toFile()
        } catch (ex: IOException) {
            throw TemporaryFolderException(
                    String.format("Failed to create directory: '%s'", path.toString()), ex)
        }
    }
}