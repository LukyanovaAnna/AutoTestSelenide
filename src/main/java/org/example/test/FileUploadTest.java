package org.example.test;
import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import java.util.List;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;


public class FileUploadTest  extends BaseTest {

    @Test
    public void uploadTest() throws InterruptedException {

        homePage.redirectToSection("File Upload");

       Selenide.switchTo().frame(0);

        File file1 = new File("src/main/resources/FileToUpload.txt");
        File file2 = new File("src/main/resources/FileToUpload2");

        fileUploadPage.uploadFiles(file1, file2);

        List<String> uploadedFileNames = fileUploadPage.getUploadedFilesElements().texts();

        Assert.assertEquals(uploadedFileNames.get(0), file1.getName());
        Assert.assertEquals(uploadedFileNames.get(1), file2.getName());
        // Проверка через индексы (порядок важен)

        //Assert.assertTrue(uploadedFileNames.contains(file1.getName()));
        //Assert.assertTrue(uploadedFileNames.contains(file2.getName()));
        // Альтернатива — если порядок не гарантирован


    }
}