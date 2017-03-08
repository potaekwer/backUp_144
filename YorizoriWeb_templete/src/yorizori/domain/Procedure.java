package yorizori.domain;

import java.io.Serializable;

public class Procedure implements Serializable {

    /** */
    private static final long serialVersionUID = -5500201830386932408L;

    private int sequence;
    private String procedure;
    
    //--------------------------------------------------------------------------
    
    public Procedure() {
        //
    }
    
    public Procedure(int sequence, String procedure) {
        //
        this.sequence = sequence;
        this.procedure = procedure;
    }
    
    //--------------------------------------------------------------------------
    
    public int getSequence() {
        return sequence;
    }
    public void setSequence(int sequence) {
        this.sequence = sequence;
    }
    public String getProcedure() {
        return procedure;
    }
    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }
}
