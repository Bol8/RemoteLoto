package POJO;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by Oscar on 18/10/2016.
 */

@DatabaseTable(tableName = "Combination")
public class Combination {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(index = true, canBeNull = false)
    private Date fecha;

    @DatabaseField(canBeNull = false)
    private int N1;

    @DatabaseField(canBeNull = false)
    private int N2;

    @DatabaseField(canBeNull = false)
    private int N3;

    @DatabaseField(canBeNull = false)
    private int N4;

    @DatabaseField(canBeNull = false)
    private int N5;

    @DatabaseField(canBeNull = false)
    private int Est1;

    @DatabaseField(canBeNull = false)
    private int Est2;


    public Combination() { }


    public Combination(int id, Date fecha, int n1, int n2, int n3, int n4, int n5, int est1, int est2) {
        this.id = id;
        this.fecha = fecha;
        N1 = n1;
        N2 = n2;
        N3 = n3;
        N4 = n4;
        N5 = n5;
        Est1 = est1;
        Est2 = est2;
    }

    public Combination(Date fecha, int n1, int n2, int n3, int n4, int n5, int est1, int est2) {
        this.fecha = fecha;
        N1 = n1;
        N2 = n2;
        N3 = n3;
        N4 = n4;
        N5 = n5;
        Est1 = est1;
        Est2 = est2;
    }

    public int getId() {
        return id;
    }


    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getN1() {
        return N1;
    }

    public void setN1(int n1) {
        N1 = n1;
    }

    public int getN2() {
        return N2;
    }

    public void setN2(int n2) {
        N2 = n2;
    }

    public int getN3() {
        return N3;
    }

    public void setN3(int n3) {
        N3 = n3;
    }

    public int getN4() {
        return N4;
    }

    public void setN4(int n4) {
        N4 = n4;
    }

    public int getN5() {
        return N5;
    }

    public void setN5(int n5) {
        N5 = n5;
    }

    public int getEst1() {
        return Est1;
    }

    public void setEst1(int est1) {
        Est1 = est1;
    }

    public int getEst2() {
        return Est2;
    }

    public void setEst2(int est2) {
        Est2 = est2;
    }
}
