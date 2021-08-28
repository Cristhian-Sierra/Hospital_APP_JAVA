
package Modelo;
import java.util.Calendar;

/**
 *La clase Fecha es una clase que guardara  los datos
 * de dia mes y año en tres variables de tipo int y estas almacenaran la
 * informacion actual de calendario con Calendar.getInstance()
 * @author Cristhian Sierra
 */
public class Fecha {
    /**Variable que almacena dd
  */
    private int dd;
   /**Variable que almacena mm*/
    private int mm;
   /**Variable que almacena aa*/
    private int aa;

    /**
     *Constructor parametrico
     * @param dd
     * @param mm
     * @param aa
     */
    public Fecha(int dd, int mm, int aa) {
        this.dd = dd;
        this.mm = mm;
        this.aa = aa;
    }

    /**
     *Constructor basico
     */
    public Fecha() {
     Calendar f=Calendar.getInstance();
        this.dd = f.get(Calendar.DAY_OF_MONTH);
        this.mm = f.get(Calendar.MONTH)+1;
        this.aa = f.get(Calendar.YEAR);
    }

    /**
     *Retorna el valor de parametro dd
     * en la clase Fecha
     * @return int
     */
    public int getDd() {
        return dd;
    }

    /**
     *Modifica el valor de  dd
     * de la clase Fecha
     * @param dd
     */
    public void setDd(int dd) {
        this.dd = dd;
    }

    /**
     *Retorna el valor de parametro mm
     * en la clase Fecha
     * @return int
     */
    public int getMm() {
        return mm;
    }

    /**
     *Modifica el valor de  dd
     * de la clase Fecha
     * @param mm
     */
    public void setMm(int mm) {
        this.mm = mm;
    }

   
    /**
     *Retorna el valor de parametro aa
     * en la clase Fecha
     * @return int
     */
    public int getAa() {
        return aa;
    }

    /**
     *Modifica el valor de  aa
     * de la clase Fecha
     * @param aa
     */
    public void setAa(int aa) {
        this.aa = aa;
    }

       /**
  * Retorna la informacion de tipo Fecha
  * con sus atributos dd,mm,aa
  * clase Fecha.
  * @return  String */
    @Override
    public String toString() {
        return   dd +"/"+  mm +"/" + aa ;
        
    }
  
}
