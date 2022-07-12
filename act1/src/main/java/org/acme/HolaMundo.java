package org.acme;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "HolaMundo")
public class HolaMundo {
    private String saludo;

    public HolaMundo() {}

    public HolaMundo(String saludo){
        super();
        this.saludo = saludo;
    }

    @XmlElement(name = "saludos")
    public String getSaludo(){
        return saludo;
    }

    public void setSaludo(String saludo){
        this.saludo = saludo;
    }
}