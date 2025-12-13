package org.example.pages;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import java.io.File;
import static com.codeborne.selenide.Selenide.*;


public class FileUploadPage extends BasePage{

    SelenideElement uploadFileInput = $x("//input[@id='browse']");


    public void uploadFile(File file) { // только один файл
        uploadFileInput.uploadFile();
    }

    public void uploadFiles(File... files) { // любое количество файлов
        uploadFileInput.uploadFile(files);
    }

    public ElementsCollection getUploadedFilesElements() {
        return $$x("//div[@class='file-info']/p"); // $$x все найденные элементы по XPath
    }


}

