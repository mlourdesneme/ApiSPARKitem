package clases;

import org.omg.CORBA.Object;

public class Respuesta {
    private String Status;
    private Token data;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Token getData() {
        return data;
    }

    public void setData(Token data) {
        this.data = data;
    }
}
