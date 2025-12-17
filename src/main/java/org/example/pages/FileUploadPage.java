package org.example.pages;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.io.File;
import static com.codeborne.selenide.Selenide.*;


public class FileUploadPage extends BasePage{

    private SelenideElement uploadFileInput = $x("//input[@id='browse']");

    @Step("Загрузить один файл")
    public void uploadFile(File file) { // только один файл
        uploadFileInput.uploadFile();
    }

    @Step("Загрузить несколько файлов")
    public void uploadFiles(File... files) { // любое количество файлов
        uploadFileInput.uploadFile(files);
    }

    @Step("Вернуть коллекцию из всех загруженных файлов")
    public ElementsCollection getUploadedFilesElements() {
        return $$x("//div[@class='file-info']/p"); // $$x все найденные элементы по XPath
    }


}

