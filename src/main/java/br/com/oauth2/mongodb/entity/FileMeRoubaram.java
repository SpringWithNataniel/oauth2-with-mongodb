package br.com.oauth2.mongodb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author nataniel
 */
@Document
public class FileMeRoubaram {

    @Id
    private String id;

    private String file;

    private String originalFile;

    private String ownerFile;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getOriginalFile() {
        return originalFile;
    }

    public void setOriginalFile(String originalFile) {
        this.originalFile = originalFile;
    }

    public String getOwnerFile() {
        return ownerFile;
    }

    public void setOwnerFile(String ownerFile) {
        this.ownerFile = ownerFile;
    }

}
